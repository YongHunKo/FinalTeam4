package com.multi;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StomWebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").setAllowedOrigins("http://127.0.0.1:8080","http://118.67.131.90/eatnout","http://118.67.131.90/eatadmin",  "http://127.0.0.1").withSockJS();
//		NCP를 이용할땐 포트가 1개로만 하니까 뒤에있는 주소 하나만 있으면될거같다
		registry.addEndpoint("/wss").setAllowedOrigins("http://127.0.0.1:8080","http://localhost:8080", "http://127.0.0.1").withSockJS();
		registry.addEndpoint("/chbot").setAllowedOrigins("http://127.0.0.1:8080","http://localhost:8080", "http://127.0.0.1").withSockJS();
	}

	/* 어플리케이션 내부에서 사용할 path를 지정할 수 있음 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
//		registry.setApplicationDestinationPrefixes("/app");
//		registry.enableSimpleBroker("/topic");
		registry.enableSimpleBroker("/send","/broasdcast");
	}
}