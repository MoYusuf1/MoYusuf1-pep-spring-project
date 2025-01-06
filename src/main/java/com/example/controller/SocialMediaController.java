package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;
import java.util.List;

@RestController
public class SocialMediaController {
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private MessageService messageService;

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account) {
        Account registeredAccount = accountService.register(account);
        if (registeredAccount != null) {
            return ResponseEntity.ok(registeredAccount);
        }
        return ResponseEntity.status(409).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account account) {
        Account loggedInAccount = accountService.login(account);
        if (loggedInAccount != null) {
            return ResponseEntity.ok(loggedInAccount);
        }
        return ResponseEntity.status(401).build();
    }

    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);
        if (createdMessage != null) {
            return ResponseEntity.ok(createdMessage);
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @GetMapping("/messages/{message_id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("message_id") Integer messageId) {
        Message message = messageService.getMessageById(messageId);
        return message != null ? ResponseEntity.ok(message) : ResponseEntity.ok().build();
    }

    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<Integer> deleteMessage(@PathVariable("message_id") Integer messageId) {
        Integer result = messageService.deleteMessage(messageId);
        return result > 0 ? ResponseEntity.ok(result) : ResponseEntity.ok().build();
    }

    @PatchMapping("/messages/{message_id}")
    public ResponseEntity<Integer> updateMessage(
            @PathVariable("message_id") Integer messageId,
            @RequestBody Message message) {
        Integer result = messageService.updateMessage(messageId, message);
        return result > 0 ? ResponseEntity.ok(result) : ResponseEntity.status(400).build();
    }

    @GetMapping("/accounts/{account_id}/messages")
    public ResponseEntity<List<Message>> getMessagesByUser(@PathVariable("account_id") Integer userId) {
        return ResponseEntity.ok(messageService.getMessagesByUser(userId));
    }
}
