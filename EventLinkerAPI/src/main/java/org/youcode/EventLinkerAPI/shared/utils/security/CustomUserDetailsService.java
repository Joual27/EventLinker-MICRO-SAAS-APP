package org.youcode.EventLinkerAPI.shared.utils.security;

import lombok.AllArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.user.User;
import org.youcode.EventLinkerAPI.user.UserDAO;


import java.util.List;

@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user was found with given Username"));
        List<GrantedAuthority> authorities = user.getAuthorities().stream().toList();
        return new org.springframework.security.core.userdetails.User(user.getUsername() , null  , authorities);
    }
}
