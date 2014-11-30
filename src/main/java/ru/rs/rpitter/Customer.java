/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rs.rpitter;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Admin
 */
@Entity
@NamedQueries( {
@NamedQuery(name = "allCustomers", query = "select c from Customer c"),
@NamedQuery(name="customerByLoginAndEmail", query = "select c from Customer c where c.login=:login and c.email=:email")})
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String email;

    protected Customer() {
    }

    public Customer(String login, String email) {
        this.login = login;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", login=" + login + ", email=" + email + '}';
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

    public Long getId() {
        return id;
    }

}
