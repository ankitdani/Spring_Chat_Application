package com.example.Spring_Chat_application.controller;

import com.example.Spring_Chat_application.model.ChatForm;
import com.example.Spring_Chat_application.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatContoller {
    private MessageService messageService;

    public ChatContoller(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model){
        model.addAttribute("ChatMessages",this.messageService.getChatMessages());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(ChatForm chatForm,Model model){
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages",this.messageService.getChatMessages());
        return "chat";
    }

    public String[] allMessageTypes(){
        return new String[]{"Say","Shout","Whisper"};
    }
}
