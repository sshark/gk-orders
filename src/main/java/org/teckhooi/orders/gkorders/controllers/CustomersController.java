package org.teckhooi.orders.gkorders.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teckhooi.orders.gkorders.repos.CustomersRepos;
import org.teckhooi.orders.gkorders.domain.Customer;
import org.teckhooi.orders.gkorders.domain.CustomerRequest;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersRepos customersRepos;

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody CustomerRequest request) throws Exception {
        Customer entity = new Customer();
        BeanUtils.copyProperties(request, entity);
        customersRepos.save(entity);
        return ResponseEntity.created(new URI(String.format("http://localhost:8080/customers/%d", entity.getCustomerID()))).body(entity);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customersRepos.findAll());
    }
}
