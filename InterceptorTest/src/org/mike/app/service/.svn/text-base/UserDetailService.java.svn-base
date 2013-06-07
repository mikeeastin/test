package org.mike.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.mike.app.dao.UserDao;
import org.mike.app.domain.Role;
import org.mike.app.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
/**
 * 该类用户从数据库获取用户信息和用户权限信息 提供给spring-security使用
 * @author Administrator
 *
 */
@Repository("ETUserDetailService")
public class UserDetailService implements UserDetailsService{

    @Resource(name = "UserDao")
    private UserDao userdao ;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        final User etuser = userdao.findUserByUserName(username);
       final UserDetails user = null ;
//        final User user = null;
        if(etuser != null){
//            user = new User(username, etuser.getPassword(), true,
//                    true ,
//                    true,
//                    true,findUserAuthorities(etuser) );

        }

        return user;
    }

    /**
     * 获取用户的权限
     * @param user
     * @return
     */
    @SuppressWarnings("deprecation")
    public Collection<GrantedAuthority> findUserAuthorities(final User user){
        final List<GrantedAuthority> autthorities = new ArrayList<GrantedAuthority>();
        final List<Role> roles =  user.getRoles();
        System.out.println(roles.size());
        for (final Role role : roles) {
            autthorities.add(new GrantedAuthorityImpl(role.getRoleCode()));
        }
        return autthorities ;
    }


}
