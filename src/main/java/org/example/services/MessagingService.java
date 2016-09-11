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

    private String customer;
    private String myMessageCode;
    private String doesNotHaveSufficientFunds;
    private String fundsTransferredSuccessfully;
    private String hasBalanceInAmount;
    private String from;
    private String to;

    @Autowired
    public MessagingService (MessageSource messageSource) {
        Assert.notNull(messageSource, "MessageSource cannot be null!");
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void initialiseService() {
        customer = messageSource.getMessage("customer", null, Locale.getDefault());
        myMessageCode = messageSource.getMessage("my.message.code", null, Locale.getDefault());
        doesNotHaveSufficientFunds = messageSource.getMessage("does.not.have.sufficient.funds", null, Locale.getDefault());

        fundsTransferredSuccessfully = messageSource.getMessage("funds.sent.successful", null, Locale.getDefault());
        hasBalanceInAmount = messageSource.getMessage("has.balance.in.amount", null, Locale.getDefault());
        from = messageSource.getMessage("from", null, Locale.getDefault());
        to = messageSource.getMessage("to", null, Locale.getDefault());

    }

    public String getCustomer() {
        return customer;
    }

    public String getMyMessageCode() {
        return myMessageCode;
    }

    public String getDoesNotHaveSufficientFunds() {
        return doesNotHaveSufficientFunds;
    }

    public String getFundsTransferredSuccessfully() {
        return fundsTransferredSuccessfully;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getHasBalanceInAmount() {
        return hasBalanceInAmount;
    }
}
