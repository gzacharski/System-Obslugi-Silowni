package com.myprojects.gza.myGymApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myprojects.gza.myGymApp.dao.RoleDAO;
import com.myprojects.gza.myGymApp.dao.UserDAO;
import com.myprojects.gza.myGymApp.entity.Role;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.helperClasses.NewUser;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private RoleDAO roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		User user=userDao.findByEmail(userEmail);
		
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
				mapRoleToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRoleToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void save(NewUser newUser) {
		
		User user=new User();
		
		user.setName(newUser.getName());
		user.setSurname(newUser.getSurname());
		user.setTelephone(newUser.getTelephoneNumber());
		user.setEmail(newUser.getEmail());
		user.setPassword(passwordEncoder.encode(newUser.getPassword()));
		
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_CLIENT")));
		
		userDao.save(user);
	}
	
	@Override
	@Transactional
	public User findByEmail(String email) {
		
		return userDao.findByEmail(email);
	}

	@Override
	@Transactional
	public User findByUserName(String userEmail) {
		
		return userDao.findByEmail(userEmail);
		//return userDao.findByUserName(userName);
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> users=new ArrayList<User>();
		
		users=userDao.getAllUsers();
		

		return userDao.getAllUsers();
	}

	
}
