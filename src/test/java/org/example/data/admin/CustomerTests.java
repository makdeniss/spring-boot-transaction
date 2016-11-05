package org.example.data.admin;

import org.example.domain.admin.CustomerEntity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerTests {

  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock
  private CustomerRepository mockCustomerRepository;

  @Test
  public void testCreationOfCustomer() {
    final CustomerEntity customer = new CustomerEntity();
    customer.setName("TestCustomer");
    customer.setBalance(50);

    mockCustomerRepository.save(customer);

    when(mockCustomerRepository.save(customer)).thenReturn(customer);
    verify(mockCustomerRepository, times(1)).save(customer);

  }
}
