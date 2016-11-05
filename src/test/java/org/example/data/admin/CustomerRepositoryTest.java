package org.example.data.admin;

import org.example.domain.admin.CustomerEntity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Deniss Makarenkov on 11/09/16.
 * Visit http://www.makdeniss.eu/
 *
 * CustomerRepository class Tests
 */

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private CustomerRepository mockCustomerRepository;

    @Test
    public void testFindAllCustomers() {
        CustomerEntity testCustomer1 = new CustomerEntity();
        testCustomer1.setName("TestCustomer1");
        testCustomer1.setBalance(50);

        mockCustomerRepository.save(testCustomer1);

        CustomerEntity testCustomer2 = new CustomerEntity();
        testCustomer2.setName("TestCustomer2");
        testCustomer2.setBalance(60);

        mockCustomerRepository.save(testCustomer2);

        when(mockCustomerRepository.findAll()).thenReturn(Arrays.asList(testCustomer1, testCustomer2));
        verify(mockCustomerRepository, times(1)).save(testCustomer1);
        verify(mockCustomerRepository, times(1)).save(testCustomer2);
    }

    @Test
    public void testFindCustomerByName() {
        CustomerEntity testCustomer = new CustomerEntity();
        testCustomer.setName("TestCustomer");
        testCustomer.setBalance(50);
        mockCustomerRepository.save(testCustomer);

        when(mockCustomerRepository.findByName("TestCustomer")).thenReturn(testCustomer);
        verify(mockCustomerRepository, times(1)).save(testCustomer);

        ArgumentCaptor<CustomerEntity> transactRepViewModelArgumentCaptor = ArgumentCaptor.forClass(CustomerEntity.class);

        verify(mockCustomerRepository, times(1)).save(transactRepViewModelArgumentCaptor.capture());
        assertEquals("TestCustomer", transactRepViewModelArgumentCaptor.getValue().getName());
    }
}
