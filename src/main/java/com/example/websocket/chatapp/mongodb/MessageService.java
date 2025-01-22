package com.example.websocket.chatapp.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // Save a message to MongoDB
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    // Retrieve the last 10 messages
    public List<Message> getLast10Messages() {
        return messageRepository.findAll()
                .stream()
                .sorted((m1, m2) -> m2.getTimestamp().compareTo(m1.getTimestamp())) // Sort by timestamp descending
                .limit(10)
                .sorted((m1, m2) -> m1.getTimestamp().compareTo(m2.getTimestamp())) // Sort back ascending
                .toList();
    }
}

