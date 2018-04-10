package com.ctg.flag.web.controller;

import com.ctg.flag.pojo.dto.ResponseDto;
import com.ctg.flag.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/starSpace")
    public ResponseDto getSpaceMessage() {
        String message = messageService.getSpaceMessage();
        return ResponseDto.succeed(null, message);
    }

    @GetMapping(value = "/council")
    public ResponseDto getCouncilMessage() {
        String message = messageService.getCouncilMessage();
        return ResponseDto.succeed(null, message);
    }
}
