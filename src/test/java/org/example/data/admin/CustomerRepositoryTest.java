package org.example.data.admin;

import org.example.Application;
import org.example.domain.admin.Customer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;

import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * Created by Deniss Makarenkov on 11/09/16.
 * Visit http://www.makdeniss.eu/
 *
 * CustomerRepository class Tests
 */

@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = CustomerRepository.class)
public class CustomerRepositoryTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private CustomerRepository mockCustomerRepository;

    @Test
    public void testFindAllCustomers() {

        Customer testCustomer1 = new Customer();
        testCustomer1.setName("TestCustomer1");
        testCustomer1.setBalance(50);

        mockCustomerRepository.save(testCustomer1);

        Customer testCustomer2 = new Customer();
        testCustomer2.setName("TestCustomer2");
        testCustomer2.setBalance(60);

        mockCustomerRepository.save(testCustomer2);

        when(mockCustomerRepository.findAll()).thenReturn(Arrays.asList(testCustomer1, testCustomer2));
        verify(mockCustomerRepository, times(1)).save(testCustomer1);
        verify(mockCustomerRepository, times(1)).save(testCustomer2);
    }

    @Test
    public void testFindCustomerByName() {

        Customer testCustomer = new Customer();
        testCustomer.setName("TestCustomer");
        testCustomer.setBalance(50);

        mockCustomerRepository.save(testCustomer);

        when(mockCustomerRepository.findByName("TestCustomer")).thenReturn(testCustomer);
        verify(mockCustomerRepository, times(1)).save(testCustomer);
    }
}
