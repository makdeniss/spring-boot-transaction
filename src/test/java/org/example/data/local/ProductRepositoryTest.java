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
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * Created by Deniss Makarenkov on 11/09/16.
 * Visit http://www.makdeniss.eu/
 *
 * ProductRepository class Tests
 */

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    ProductRepository mockProductRepository;

    @Test
    public void testFindAllProducts() {
        Product testProduct1 = new Product();
        testProduct1.setName("TestProduct1");

        mockProductRepository.save(testProduct1);

        Product testProduct2 = new Product();
        testProduct2.setName("TestProduct2");

        mockProductRepository.save(testProduct2);

        when(mockProductRepository.findAll()).thenReturn(Arrays.asList(testProduct1, testProduct2));
        verify(mockProductRepository, times(1)).save(testProduct1);
        verify(mockProductRepository, times(1)).save(testProduct2);
    }

    @Test
    public void testFindProductByName() {
        Product testProduct = new Product();
        testProduct.setName("TestProduct");

        mockProductRepository.save(testProduct);

        when(mockProductRepository.findByName("TestProduct")).thenReturn(testProduct);
        verify(mockProductRepository, times(1)).save(testProduct);
    }
}
