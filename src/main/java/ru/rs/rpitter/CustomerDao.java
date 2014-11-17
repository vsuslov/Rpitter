/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rs.rpitter;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
public class CustomerDao {

    @PersistenceContext(unitName = "rpitter")
    private EntityManager em;

    public Long addCustomer(Customer c) {
        em.persist(c);
        return c.getId();
    }

    public List<Customer> findAllCustomers() {
        return em.createNamedQuery("allCustomers").getResultList();
    }
}
