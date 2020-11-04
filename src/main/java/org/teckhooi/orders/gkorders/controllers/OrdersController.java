package org.teckhooi.orders.gkorders.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teckhooi.orders.gkorders.domain.Customer;
import org.teckhooi.orders.gkorders.domain.Order;
import org.teckhooi.orders.gkorders.domain.OrderRequest;
import org.teckhooi.orders.gkorders.repos.CustomersRepos;
import org.teckhooi.orders.gkorders.repos.OrdersRepos;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private CustomersRepos customersRepos;

    @Autowired
    private OrdersRepos ordersRepos;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderRequest request) throws Exception {
        Optional<Customer> customerOpt = customersRepos.findById(request.getCustomerID());
        if (customerOpt.isPresent()) {
            Order entity = new Order();
            BeanUtils.copyProperties(request, entity);
            entity.setCustomer(customerOpt.get());
            ordersRepos.save(entity);
            return ResponseEntity.created(new URI(String.format("http://localhost:8080/orders?%d", entity.getOrderID()))).body(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(ordersRepos.findAll(Sort.by("customer.customerName")));
    }
}
