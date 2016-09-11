package org.example.services;

import org.example.Application;
import org.example.data.admin.CustomerRepository;
import org.example.domain.admin.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by Deniss Makarenkov on 11/09/16.
 * Visit http://www.makdeniss.eu/
 *
 * Service to handle transactions between customers
 */

@Service
public class TransactionService {

    private MessagingService messagingService;
    private CustomerRepository customerRepository;

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    public TransactionService(MessagingService messagingService, CustomerRepository customerRepository){
        Assert.notNull(messagingService, "MessagingService cannot be null");
        this.messagingService = messagingService;
        Assert.notNull(customerRepository, "CustomerRepository cannot be null");
        this.customerRepository = customerRepository;
    }

    public void makeTransactionFromSenderToReceiver(Customer sender, Customer receiver, int amount) {

        if (sender.getBalance() >= amount) {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);

            customerRepository.save(sender);
            customerRepository.save(receiver);

            log.info(messagingService.getFundsTransferredSuccessfully() + " "
                                            + messagingService.getFrom() + " "
                                                                + sender + " "
                                            + messagingService.getTo() + " "
                                                                + receiver + ".");
        }

        else {
            log.error(messagingService.getCustomer() + " " + sender.getName() + " " + messagingService.getDoesNotHaveSufficientFunds() + " " + amount);

            throw new RuntimeException();
        }
    }
}
