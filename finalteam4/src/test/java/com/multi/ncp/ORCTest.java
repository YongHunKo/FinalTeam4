package com.multi.ncp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ORCTest {

	@Test
	void contextLoads() {
		String apiURL = "https://6bdyzr1ytz.apigw.ntruss.com/custom/v1/18933/d65e547f9736729838578e2a05d4db3f174e9401ee790a80d2d9a57dbb6fe05f/infer";
		String secretKey = "RXpab3JQbHFIbmFRSktzeW90aWJKY1RsSUVMZlRBWng=";
		String imgpath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static", "img")
				.toString();
		String imageFile = imgpath + "/receipt1.jpg";
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);

			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "jpg");
			image.put("name", "demo");
			JSONArray images = new JSONArray();
			images.add(image);
			json.put("images", images);
			String postParams = json.toString();

			con.connect();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			long start = System.currentTimeMillis();
			File file = new File(imageFile);
			System.out.println("----------" + file.getName());
			System.out.println("----------" + file.getPath());
			System.out.println("----------" + file.getAbsolutePath());
			writeMultiPart(wr, postParams, file, boundary);
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println("REsult:");
			System.out.println("image result JSON : " + response);

			JSONParser jsonparser = new JSONParser();
			Object obj = jsonparser.parse(response.toString());
			System.out.println(obj);
//			JSONObject jsonObj = (JSONObject) jsonparser.parse(response.toString());
//			System.out.println(jsonObj.toString());
						
//			JSONParser 
//			JSONParser jsonparser = new JSONParser();
//			JSONObject jsonObj = (JSONObject)jsonparser.parse(response.toString());
//			System.out.println(jsonObj.toString());
			
//			JSONArray jsonArray = (JSONArray) jsonObj.get("images");
//			JSONObject jsonObj1 = (JSONObject) jsonArray.get(0);
//			JSONArray ja2 = (JSONArray) jo1.get("fields");
//			
//			
//			JSONObject f1 = (JSONObject) ja2.get(0);
//			JSONObject f2 = (JSONObject) ja2.get(1);
//			JSONObject f3 = (JSONObject) ja2.get(2);
//			
//			String name1 = (String) f1.get("inferText");
//			String name2 = (String) f2.get("inferText");
//			String no = (String) f3.get("inferText");
//			
//			System.out.println(name1);
//			System.out.println(name2);
//			System.out.println(no);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("--").append(boundary).append("\r\n");
		sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
		sb.append(jsonMessage);
		sb.append("\r\n");

		out.write(sb.toString().getBytes("UTF-8"));
		out.flush();

		if (file != null && file.isFile()) {
			out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
			StringBuilder fileString = new StringBuilder();
			fileString.append("Content-Disposition:form-data; name=\"file\"; filename=");
			fileString.append("\"" + file.getName() + "\"\r\n");
			fileString.append("Content-Type: application/octet-stream\r\n\r\n");
			out.write(fileString.toString().getBytes("UTF-8"));
			out.flush();

			try (FileInputStream fis = new FileInputStream(file)) {
				byte[] buffer = new byte[8192];
				int count;
				while ((count = fis.read(buffer)) != -1) {
					out.write(buffer, 0, count);
				}
				out.write("\r\n".getBytes());
			}

			out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
		}
		out.flush();
	}
}
