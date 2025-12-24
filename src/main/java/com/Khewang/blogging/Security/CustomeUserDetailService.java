package com.Khewang.blogging.Security;

import com.Khewang.blogging.exception.ResourceNotFoundException;
import com.Khewang.blogging.model.User;
import com.Khewang.blogging.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loading user from data base by username

        User user =  this.userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User","Email: "+username,0));

        return user;
    }
}
