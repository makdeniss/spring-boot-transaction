package org.example;

import org.example.data.admin.CustomerRepository;
import org.example.data.admin.TransactionsRepository;
import org.example.domain.admin.CustomerEntity;
import org.example.domain.admin.TransactionsEntity;
import org.example.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * Created by Deniss Makarenkov on 05/11/2016.
 * Visit http://www.makdeniss.eu/
 *
 */

@Component
public class TransactionRunner {

    private final CustomerRepository customerRepository;
    private final TransactionsRepository transactionsRepository;
    private final Parser parser;

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public TransactionRunner(CustomerRepository customerRepository, Parser parser,
                             TransactionsRepository transactionsRepository) {
        Assert.notNull(parser);
        this.parser = parser;
        Assert.notNull(customerRepository);
        this.customerRepository = customerRepository;
        Assert.notNull(transactionsRepository);
        this.transactionsRepository = transactionsRepository;
    }

    public void go() {
        Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(defaultLocale);
        parser.parse();

        List<CustomerEntity> customerEntitiesList = customerRepository.findBybankId("1");
        List<String> customerIdList = new ArrayList<>();

        for (CustomerEntity customerEntity : customerEntitiesList) {
            log.info("found customer: " + customerEntity.getName() + " with id: " + customerEntity.getId());
            log.info("  with bank_id: " + customerEntity.getBankId());
            customerIdList.add(String.valueOf(customerEntity.getId()));
        }

        List<TransactionsEntity> transactionsEntitiesList = transactionsRepository.findByCustomerIdIn(customerIdList);

        for (TransactionsEntity transactionsEntity : transactionsEntitiesList) {
            log.info("customer's " + transactionsEntity.getCustomerId()
                                   + " transactions are: " + transactionsEntity.getAmount());
        }
    }
}
