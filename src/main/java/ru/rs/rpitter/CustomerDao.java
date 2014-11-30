/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rs.rpitter;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
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
    
    public Customer findCustomerById(Long id) {
        return em.find(Customer.class, id);
    }
    
    public void removeCustomer(Long id) {
     EntityTransaction t= em.getTransaction();
     t.begin();
       Customer c=findCustomerById(id);
        em.remove(c);
       t.commit();
    }
    
    public Customer findByLoginAndEmail(String login, String email){
        return (Customer) em.createNamedQuery("customerByLoginAndEmail").getSingleResult();
    }
}
