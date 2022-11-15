package com.multi.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;





@Service
public class OauthService {
    
	
	
	/**
	 * GOOGLE AccessToken 처리
	 */
	
	
	public String getGoogleAccessToken(String authorize_code) {
		String access_Token = "";
		String reqURL = "https://www.googleapis.com/oauth2/v4/token";
		
	    try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        
	        //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
	        conn.setRequestMethod("POST");
	        conn.setDoOutput(true);
	        //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	        StringBuilder sb = new StringBuilder();
	        sb.append("grant_type=authorization_code");
	        sb.append("&client_id=414674411151-8otfjo97eobc9r4lk262bvegl1e27so6.apps.googleusercontent.com");
	        sb.append("&client_secret=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");
	        sb.append("&redirect_uri=http://localhost:80/google/callback");
	        sb.append("&code="+authorize_code);
	        sb.append("&state=url_parameter");
	        bw.write(sb.toString());
	        bw.flush();
	        
	        //결과 코드가 200이라면 성공
	        int responseCode = conn.getResponseCode();
	        if(responseCode==200){
	            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line = "";
	            String result = "";
	            
	            while ((line = br.readLine()) != null) {
	                result += line;
	            }
	            
	            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
	            JsonParser parser = new JsonParser();
	            JsonElement element = parser.parse(result);
	            System.out.println("result : "+result);
	            access_Token = element.getAsJsonObject().get("access_token").getAsString();
	          //refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
	            br.close();
	            bw.close();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	    
	    return access_Token;
	}
   
	/**
	 * GOOGLE USER INFO
	 * @param access_Token
	 */
	
	public HashMap<String, Object> getGoogleUserInfo(String access_Token) {
		 //요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
	    HashMap<String, Object> googleUserInfo = new HashMap<>();
	    //String reqURL = "https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token="+access_Token;
	    String reqURL = "https://www.googleapis.com/userinfo/v2/me?access_token="+access_Token;
	    try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	        //요청에 필요한 Header에 포함될 내용
	        conn.setRequestProperty("Authorization", "Bearer " + access_Token);

	        int responseCode = conn.getResponseCode();
	        System.out.println("responseCode : "+responseCode);
	        if(responseCode == 200){
		        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        
		        String line = "";
		        String result = "";
		        
		        while ((line = br.readLine()) != null) {
		            result += line;
		        }
		        JsonParser parser = new JsonParser();
		        System.out.println("result : "+result);
		        JsonElement element = parser.parse(result);
		        
		        String name = element.getAsJsonObject().get("name").getAsString();
		        String email = element.getAsJsonObject().get("email").getAsString();
		        String id = "GOOGLE_"+element.getAsJsonObject().get("id").getAsString();
		        String profile=element.getAsJsonObject().get("picture").getAsString();
		        googleUserInfo.put("name", name);
		        googleUserInfo.put("email", email);
		        googleUserInfo.put("id", id);
		        googleUserInfo.put("profile", profile);
		        
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return googleUserInfo;
	}

    
    
    
}
