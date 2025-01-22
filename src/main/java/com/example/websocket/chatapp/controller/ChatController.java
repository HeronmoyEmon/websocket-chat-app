package com.example.websocket.chatapp.controller;

import com.example.websocket.chatapp.model.ChatMessage;
import com.example.websocket.chatapp.mongodb.Message;
import com.example.websocket.chatapp.mongodb.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage message) {
        // Set the timestamp as LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        message.setTimestamp(now.toString()); // This is used for broadcasting (as a string)

        // Save the message in MongoDB
        messageService.saveMessage(
                Message.builder()
                        .sender(message.getSender())
                        .content(message.getContent())
                        .timestamp(now) // Save LocalDateTime directly
                        .build()
        );

        return message; // Broadcast the message
    }
}

