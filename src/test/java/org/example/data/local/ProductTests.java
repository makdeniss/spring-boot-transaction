package org.example.data.local;

import org.example.Application;
import org.example.domain.local.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductTests {

  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock
  private ProductRepository mockProductRepository;

  @Test
  public void testCreationOfProduct() {
    final Product product = new Product();
    product.setName("Test Product");
    mockProductRepository.save(product);

    when(mockProductRepository.save(product)).thenReturn(product);
    verify(mockProductRepository, times(1)).save(product);

  }
}
