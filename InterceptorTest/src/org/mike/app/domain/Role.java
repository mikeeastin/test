package org.mike.app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity  
@Table(name = "etrole")  
public class Role {  
  
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private int id;  
      
    private String roleCode ;  
      
    private String despripe ;  
      
      
    @ManyToMany  
    @JoinTable(name="user_role" , joinColumns = {  
            @JoinColumn(name = "roleid")  
    }, inverseJoinColumns = {@JoinColumn(name="userid")})   
    private List<User> users = new ArrayList<User>();  
  
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
    public String getRoleCode() {  
        return roleCode;  
    }  
  
    public void setRoleCode(String roleCode) {  
        this.roleCode = roleCode;  
    }  
  
    public String getDespripe() {  
        return despripe;  
    }  
  
    public void setDespripe(String despripe) {  
        this.despripe = despripe;  
    }  
  
    public List<User> getUsers() {  
        return users;  
    }  
  
    public void setUsers(List<User> users) {  
        this.users = users;  
    }  
  
      
}  
