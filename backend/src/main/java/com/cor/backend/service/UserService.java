package com.cor.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cor.backend.config.WebSecurityConfig;
import com.cor.backend.model.User;
import com.cor.backend.repository.UserRepository;

@Service
public class UserService implements UserDetailsService  {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private WebSecurityConfig webSecurityConfig;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public UserDetails loadUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    
    public User findById(Long id) {
		Optional<User> ou = userRepository.findById(id);
		if (ou.isPresent())
			return ou.get();
		return null;
	}

    
    @Transactional
	public User enableUser(String email) {
		User u = userRepository.findByEmail(email);
		if (u != null) {
			
			if (u.isEnabled())
				u.setEnabled(false);
			else
				u.setEnabled(true);
			return userRepository.save(u);
		} 
		return null;
	}
    
    public Boolean checkIfPasswordsMatch(String password, String email) {
		User u = userRepository.findByEmail(email);
		PasswordEncoder pe = this.webSecurityConfig.passwordEncoder();
		if (pe.matches(password, u.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

    public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}


}
