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

//	@MessageMapping("/receiveto") // 특정 Id에게 전송
//	public void receiveto(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
//		String id = msg.getSendid();
//		String answer = "";
//		String target = msg.getReceiveid();
//		try {
//			answer = service.sendMessage(msg.getContent1());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		msg.setContent2(answer);
//		template.convertAndSend("/send/to/" + target, msg);
//	}
}
