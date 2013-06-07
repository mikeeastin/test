package org.mike.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.mike.app.domain.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("UserDao")  
@Transactional(propagation = Propagation.REQUIRED)  
public class UserDao extends HibernateDaoSupport{  
      
      
    /** 
     * 根据用户名查询用户 
     * @param username 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public User findUserByUserName(String username){  
        List<User> result =  getHibernateTemplate().find("from ETUser e where e.username = ?"  
                , username );  
        if(result != null && !result.isEmpty())      
            return result.get(0);  
        return null ;  
    }  
  
    /** 
     * 根据用户名和密码查询用户 
     * @param username 
     * @param password 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public User findUserBuNameAndPwd(String username , String password){  
        List<User> result =  getHibernateTemplate().find("from ETUser e where e.username = ? and e.password = ?"  
                , username , password);  
        if(result != null && !result.isEmpty())    
            return result.get(0);  
        return null ;  
    }  
      
    @Resource(name = "sessionFactory")  
    public void setMySessionFactory(SessionFactory sessionFactory){  
        super.setSessionFactory(sessionFactory);  
    }  
  
  
}  