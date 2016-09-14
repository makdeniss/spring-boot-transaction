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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CustomerTests {

  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock
  private CustomerRepository mockCustomerRepository;

  @Test
  public void testCreationOfCustomer() {
    final Customer customer = new Customer();
    customer.setName("TestCustomer");
    customer.setBalance(50);

    mockCustomerRepository.save(customer);

    when(mockCustomerRepository.save(customer)).thenReturn(customer);
    verify(mockCustomerRepository, times(1)).save(customer);

  }
}
