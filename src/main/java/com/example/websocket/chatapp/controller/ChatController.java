package com.example.websocket.chatapp.controller;

import com.example.websocket.chatapp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage") // Handles messages sent to /app/sendMessage
    @SendTo("/topic/public") // Sends messages to /topic/public
    public ChatMessage sendMessage(ChatMessage message) {
        // Add a timestamp to the message
        message.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        return message;
    }
}

