package org.example.data.admin;

import org.example.domain.admin.TransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Deniss Makarenkov on 05/11/2016.
 * Visit http://www.makdeniss.eu/
 */
@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Long> {

    List<TransactionsEntity> findByCustomerIdIn(List<String> customerEntities);

    List<TransactionsEntity> findBycustomerId(String customerId);
}
