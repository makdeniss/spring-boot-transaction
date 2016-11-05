package org.example.data.admin;

import org.example.domain.admin.CustomerEntity;
import org.example.services.MessagingService;
import org.example.services.TransactionService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Deniss Makarenkov on 11/09/16.
 * Visit http://www.makdeniss.eu/
 *
 * Test TransactionService
 */

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TransactionServiceTests {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private MessagingService mockMessagingService;

    @Mock
    private CustomerRepository mockCustomerRepository;

    @InjectMocks
    TransactionService transactionService;

    @Test
    public void testTransactionBetweenCustomersAndBalanceOfReceiverAndSender() {
        int AMOUNT = 50;

        CustomerEntity customerReceiver = new CustomerEntity();
        customerReceiver.setName("TestReceiver");
        customerReceiver.setBalance(12);
        mockCustomerRepository.save(customerReceiver);

        CustomerEntity customerSender = new CustomerEntity();
        customerSender.setName("TestSender");
        customerSender.setBalance(50);
        mockCustomerRepository.save(customerSender);

        int expectedReceiverAmount = customerReceiver.getBalance() + AMOUNT;
        int expectedSenderAmount = customerSender.getBalance() - AMOUNT;

        transactionService.makeTransactionFromSenderToReceiver(customerSender, customerReceiver, AMOUNT);

        assertEquals(expectedSenderAmount, customerSender.getBalance());
        assertEquals(expectedReceiverAmount, customerReceiver.getBalance());

        when(mockCustomerRepository.save(customerSender)).thenReturn(customerSender);
        verify(mockCustomerRepository, times(2)).save(customerSender);
    }
}
