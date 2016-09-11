package org.example.data.local;

import org.example.data.AbstractEntityRepository;
import org.example.domain.local.Product;
import org.springframework.dao.DataAccessException;

public interface ProductRepository extends AbstractEntityRepository<Product> {

    Product findByName(String name) throws DataAccessException;
}
