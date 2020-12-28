package com.hdu.mxd.service;

//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hdu.mxd.entity.UserAndPower;
import com.hdu.mxd.mapper.UserAndAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by DELL(mxd) on 2020/12/8 23:05
 */

@Service("userDatailsService")
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserAndAuthor userAndAuthor;
    // 百度没有   Springboot 通过IOC注入 HttpServletRequest  在通过 httpServletRequest.getSession();
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        QueryWrapper<Users> wrapper = new QueryWrapper<>();
//        wrapper.eq("username",username);
        HttpSession session = httpServletRequest.getSession();


        UserAndPower users = userAndAuthor.getUserAndPower(username);

        String auth = "ROLE_"+users.getPower();
//        System.out.print(auth);
        if (users == null){
            return (UserDetails) new UsernameNotFoundException("用户名不存在！！");
        }
        session.setAttribute("username",users.getUsername());
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList(auth);

        return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()),auths);

    }
}
