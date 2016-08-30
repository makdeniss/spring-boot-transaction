package org.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by Deniss Makarenkov on 29/08/16.
 * Visit http://www.makdeniss.eu/
 */
@Service
public class MessagingService {

    @Autowired
    MessageSource messageSource;

    private String myMessageCode;

    @PostConstruct
    public void initialiseService() {
        myMessageCode = messageSource.getMessage("my.message.code", null, Locale.getDefault());
    }

    public String getMyMessageCode() {
        return myMessageCode;
    }


}
