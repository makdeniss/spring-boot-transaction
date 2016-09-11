package org.example.data.admin;

import org.example.Application;
import org.example.domain.admin.Customer;
import org.example.services.MessagingService;
import org.example.services.TransactionService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Deniss Makarenkov on 11/09/16.
 * Visit http://www.makdeniss.eu/
 *
 * Test TransactionService
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TransactionServiceTests {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private MessagingService mockMessagingService;
    @Mock
    private CustomerRepository mockCustomerRepository;

    @Autowired
    TransactionService transactionService;

    @Test
    public void testTransactionBetweenCustomersAndBalanceOfReceiver() {

        int AMOUNT = 50;

        // prepare your test data unless you always expect those values to exist.
        Customer customerReceiver = new Customer();
        customerReceiver.setName("TestReceiver");
        customerReceiver.setBalance(12);
        mockCustomerRepository.save(customerReceiver);

        Customer customerSender = new Customer();
        customerSender.setName("TestSender");
        customerSender.setBalance(50);
        mockCustomerRepository.save(customerSender);

        int expectedReceiverAmount = customerReceiver.getBalance() + AMOUNT;
        int expectedSenderAmount = customerSender.getBalance() - AMOUNT;
        transactionService.makeTransactionFromSenderToReceiver(customerSender, customerReceiver, AMOUNT);

        assertEquals(expectedSenderAmount, customerSender.getBalance());
        assertEquals(expectedReceiverAmount, customerReceiver.getBalance());

    }
}