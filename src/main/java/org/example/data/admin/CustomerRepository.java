package org.example.data.admin;

import org.example.domain.admin.CustomerEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

    CustomerEntity findByName(String name) throws DataAccessException;

    List<CustomerEntity> findBybankId(String bankId) throws DataAccessException;
}
