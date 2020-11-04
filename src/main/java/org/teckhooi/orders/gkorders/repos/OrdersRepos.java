package org.teckhooi.orders.gkorders.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teckhooi.orders.gkorders.domain.Order;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OrdersRepos extends JpaRepository<Order, Integer> {

}
