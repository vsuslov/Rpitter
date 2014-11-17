package ru.rs.rpitter.mbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ru.rs.rpitter.Customer;
import ru.rs.rpitter.CustomerDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
@ManagedBean(name = "index", eager = true)
@RequestScoped
public class index {

    private String login;
    private String email;

    @EJB
    private CustomerDao dao;

    public List<Customer> getCustomers() {
        return dao.findAllCustomers();
    }

    public void addCustomer(Customer c) {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
