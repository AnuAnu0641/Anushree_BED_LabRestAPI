package com.gl.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.student.entity.User;
import com.gl.student.repository.UserRepository;
import com.gl.student.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("Could not find user");		
		return new MyUserDetails(user);
	}

}

/**
 * this class (UserDetailsService) has only one method loadUserByUsername(String username)
 * class provided by spring security framework (springframework.security.core.userdetails.UserDetailsService)
 * Locates the user based on the username. In the actual implementation, the search
 * may possibly be case sensitive, or case insensitive depending on how the
 * implementation instance is configured. In this case, the <code>UserDetails</code>
 * object that comes back may have a username that is of a different case than what
 * was actually requested..
 * @param username the username identifying the user whose data is required.
 * @return a fully populated user record (never <code>null</code>)
 * @throws UsernameNotFoundException if the user could not be found or the user has no
 * GrantedAuthority
 */

/*
 * public class UsernameNotFoundException extends AuthenticationException {
*	public UsernameNotFoundException(String msg) {
*		super(msg);
*	}

*	public UsernameNotFoundException(String msg, Throwable cause) {
*		super(msg, cause);
*	}

*}

*/