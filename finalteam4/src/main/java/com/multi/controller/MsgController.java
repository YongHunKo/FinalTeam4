package com.multi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.multi.dto.Msg;
import com.multi.service.ChatbotService;

@Controller
public class MsgController {

	@Autowired
	SimpMessagingTemplate template;

	@Autowired
	ChatbotService service;

	/**
	 * receiveme 해당 메소드는 챗봇과 연결을 하기 위한 메소드로
	 * 자기 자신에게 메시지를 보내는 메소드와 
	 * 특정 메시지에 반응하는 챗봇 메소드를 합쳤다.
	 * @param msg
	 * @param headerAccessor
	 */
	@MessageMapping("/receiveme")
	public void receiveme(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
		String id = msg.getSendid();
		String answer = "";
		try {
			answer = service.sendMessage(msg.getContent1());
		} catch (IOException e) {
			e.printStackTrace();
		}
		msg.setContent2(answer);
		System.out.println("answer : " + answer);
		template.convertAndSend("/send/" + id, msg);
	}

	/**
	 * receiveto2 해당 메소드는 특정 id에게 메시지를 전송하는 메소드이다.
	 * 특정id(adminid)를 입력시 연결된 웹소켓으로 정해진 메시지를 보내는 메소드이다.
	 * @param msg
	 * @param headerAccessor
	 */
	@MessageMapping("/receiveto") // 특정 Id에게 전송
	public void receiveto2(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
		String id = msg.getSendid();
		String target = msg.getReceiveid();
		template.convertAndSend("/send/to/"+target,msg);
	}
}
