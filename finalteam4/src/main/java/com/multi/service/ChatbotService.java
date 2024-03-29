package com.multi.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;

@Controller
public class ChatbotService {
	private String apiURL = "https://5rg3w5fpd8.apigw.ntruss.com/custom/v1/8468/675ddbcbc9b8ae74a2737a31c33b056d8aeb2cfc89ef7a5132734f180376fe9d";
	private String secretKey = "RXhKZ1NDYlN4UmN3WFF3Qm5UT0RSZUd4WG1OV0ZrcG8=";

	public String sendMessage(String chatMessage) throws IOException {
		URL url = new URL(apiURL);
		String chatbotMessage = chatMessage;
		String message = getReqMessage(chatbotMessage);
		System.out.println("##" + message);
		String encodeBase64String = makeSignature(message, secretKey);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json;UTF-8");
		con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

		// post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.write(message.getBytes("UTF-8"));
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();

		BufferedReader br;

		if (responseCode == 200) { // Normal call
			System.out.println(con.getResponseMessage());

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String decodedString;
			while ((decodedString = in.readLine()) != null) {
				chatbotMessage = decodedString;
			}

			JSONParser jsonparser = new JSONParser();
			try {

				JSONObject json = (JSONObject) jsonparser.parse(chatbotMessage);
				JSONArray bubblesArray = (JSONArray) json.get("bubbles");
				JSONObject bubbles = (JSONObject) bubblesArray.get(0);
				JSONObject data = (JSONObject) bubbles.get("data");
				String description = "";
				description = (String) data.get("description");
				chatMessage = description;
			} catch (Exception e) {
				System.out.println("error");
				e.printStackTrace();
			}

			in.close();

		} else { // 에러 발생
			System.out.println("Error");

			chatMessage = con.getResponseMessage();
		}
		System.out.println("REsult:" + chatMessage);
		return chatMessage;
	}

	public static String makeSignature(String message, String secretKey) {

		String encodeBase64String = "";

		try {
			byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

			SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);

			byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
			encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);

			return encodeBase64String;

		} catch (Exception e) {
			System.out.println(e);
		}

		return encodeBase64String;

	}

	public static String getReqMessage(String voiceMessage) {

		String requestBody = "";

		try {

			JSONObject obj = new JSONObject();

			long timestamp = new Date().getTime();

			System.out.println("##" + timestamp);

			obj.put("version", "v2");
			obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2");
//=> userId is a unique code for each chat user, not a fixed value, recommend use UUID. use different id for each user could help you to split chat history for users.

			obj.put("timestamp", timestamp);

			JSONObject bubbles_obj = new JSONObject();

			bubbles_obj.put("type", "text");

			JSONObject data_obj = new JSONObject();
			data_obj.put("description", voiceMessage);

			bubbles_obj.put("type", "text");
			bubbles_obj.put("data", data_obj);

			JSONArray bubbles_array = new JSONArray();
			bubbles_array.add(bubbles_obj);

			obj.put("bubbles", bubbles_array);
			obj.put("event", "send");

			requestBody = obj.toString();

		} catch (Exception e) {
			System.out.println("## Exception : " + e);
		}

		return requestBody;

	}
}
