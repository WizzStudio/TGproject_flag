package com.ctg.flag.service.impl;

import com.ctg.flag.dao.MessageDao;
import com.ctg.flag.enums.MessageKindEnum;
import com.ctg.flag.enums.MessageStateEnum;
import com.ctg.flag.pojo.entity.Message;
import com.ctg.flag.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private MessageDao messageDao;

    @Autowired
    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public String getSpaceMessage() {
        Message message = messageDao.getByKindAndState(MessageKindEnum.START_SPACE.getValue(), MessageStateEnum.EXISTING.getValue());
        return message.getContent();
    }

    @Override
    public String getCouncilMessage() {
        Message message = messageDao.getByKindAndState(MessageKindEnum.COUNCIL.getValue(), MessageStateEnum.EXISTING.getValue());
        return message.getContent();
    }
}
