/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rs.rpitter;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public void removeCustomer(Customer customer) {
     
     String login=customer.getLogin();
     String email=customer.getEmail();
       Customer c=findByLoginAndEmail(login,email);
       if(c!=null) {
        em.remove(c);
       }
    }
    
    public Customer findByLoginAndEmail(String login, String email){
        Customer result=null;
        Query query=em.createNamedQuery("customerByLoginAndEmail").setParameter("login", login).setParameter("email", email);
        List<Customer> list= query.getResultList();
       if(list.size()>0) {
           result=list.get(0);
       }
       return result;
    }
}
