//package com.itl.configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.itl.entities.User;
//import com.itl.login.Repository.UserRepository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private UserRepository userepo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		 List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
//		 
//		// Collection<? extends GrantedAuthority> role = new ArrayList<>();
//
//		User user = userepo.findByUsername(username);
//
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	   //role.add("ADMIN");
//		authList.add(new SimpleGrantedAuthority("ADMIN")); 		
//	
//		
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
//				authList);
//	}
//
//
//
//	
//	
//}
