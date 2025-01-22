package com.example.websocket.chatapp.controller;

import com.example.websocket.chatapp.mongodb.Message;
import com.example.websocket.chatapp.mongodb.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
public class MessageController {

    @Autowired
    private MessageService messageService;

    // Endpoint to retrieve the last 10 messages
    @GetMapping
    public List<Message> getLast10Messages() {
        return messageService.getLast10Messages();
    }

    // Endpoint to save a new message
    @PostMapping
    public Message saveMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }
}

