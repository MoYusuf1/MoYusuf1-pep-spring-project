package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Message;
import com.example.repository.MessageRepository;
import com.example.repository.AccountRepository;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private AccountRepository accountRepository;

    public Message createMessage(Message message) {
        if (message.getMessageText() == null || message.getMessageText().trim().isEmpty() || 
            message.getMessageText().length() > 255 || 
            accountRepository.findById(message.getPostedBy()).isEmpty()) {
            return null;
        }
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Integer messageId) {
        return messageRepository.findByMessageId(messageId);
    }

    public List<Message> getMessagesByUser(Integer userId) {
        return messageRepository.findByPostedBy(userId);
    }

    public Integer deleteMessage(Integer messageId) {
        Message message = messageRepository.findByMessageId(messageId);
        if (message != null) {
            messageRepository.delete(message);
            return 1;
        }
        return 0;
    }

    public Integer updateMessage(Integer messageId, Message updatedMessage) {
        Message message = messageRepository.findByMessageId(messageId);
        if (message != null && updatedMessage.getMessageText() != null && 
            !updatedMessage.getMessageText().trim().isEmpty() && 
            updatedMessage.getMessageText().length() <= 255) {
            message.setMessageText(updatedMessage.getMessageText());
            messageRepository.save(message);
            return 1;
        }
        return 0;
    }
}
