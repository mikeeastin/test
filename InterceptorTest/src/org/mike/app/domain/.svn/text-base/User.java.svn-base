package org.mike.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "etuser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    private String username ;

    private String password ;

    private int age ;

    @ManyToMany
    @JoinTable(name="user_role" , joinColumns = {
            @JoinColumn(name = "userid")
    }, inverseJoinColumns = {@JoinColumn(name="roleid")})
    private List<Role> roles = new ArrayList<Role>();

    @Temporal(TemporalType.DATE)
    private Date regDate ;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(final Date regDate) {
        this.regDate = regDate;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(final List<Role> roles) {
        this.roles = roles;
    }


}
