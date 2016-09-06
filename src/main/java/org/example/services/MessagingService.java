package org.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by Deniss Makarenkov on 29/08/16.
 * Visit http://www.makdeniss.eu/
 */
@Service
public class MessagingService {

    private MessageSource messageSource;

    private String myMessageCode;

    @Autowired
    public MessagingService (MessageSource messageSource) {
        Assert.notNull(messageSource, "MessageSource cannot be null!");
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void initialiseService() {
        myMessageCode = messageSource.getMessage("my.message.code", null, Locale.getDefault());
    }

    public String getMyMessageCode() {
        return myMessageCode;
    }


}
