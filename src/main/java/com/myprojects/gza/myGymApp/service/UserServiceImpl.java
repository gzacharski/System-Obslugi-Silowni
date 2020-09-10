package com.myprojects.gza.myGymApp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myprojects.gza.myGymApp.dao.PasswordDAO;
import com.myprojects.gza.myGymApp.dao.RoleDAO;
import com.myprojects.gza.myGymApp.dao.TrainerDAO;
import com.myprojects.gza.myGymApp.dao.UserDAO;
import com.myprojects.gza.myGymApp.entity.Password;
import com.myprojects.gza.myGymApp.entity.Role;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.entity.UserAddress;
import com.myprojects.gza.myGymApp.entity.UserAgreements;
import com.myprojects.gza.myGymApp.helperClasses.NewUser;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private RoleDAO roleDao;
	
	@Autowired
	private TrainerDAO trainerDAO;
	
	@Autowired
	private PasswordDAO passwordDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		User user=userDao.findByEmail(userEmail);
		
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword().getPassword(), 
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
		user.setUserAddress(new UserAddress());
		user.setUserAgreements(new UserAgreements());
		user.setUserDetails(new com.myprojects.gza.myGymApp.entity.UserDetails());
		
		Password password=new Password();
		password.setPassword(passwordEncoder.encode(newUser.getPassword()));
		password.setUser(user);
		
		user.setPassword(password);
		
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_CLIENT")));
		
		System.out.println(user.toString()+"-"+password.toString());
		
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
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	@Override
	@Transactional
	public User getById(int id) {
		// TODO Auto-generated method stub
		return userDao.getById(id);
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional
	public User getAllUserInfoById(int id) {
		User tempUser=userDao.getById(id);
		
		Hibernate.initialize(tempUser.getUserAddress());
		Hibernate.initialize(tempUser.getUserAgreements());
		Hibernate.initialize(tempUser.getUserDetails());
		
		return tempUser;
	}

	@Override
	@Transactional
	public boolean update(User user) {
		
	  System.out.println("Test"); 
	  System.out.println(user.toString());
	  System.out.println(user.getUserAddress().toString());
	  System.out.println(user.getUserAgreements().toString());
	  System.out.println(user.getUserDetails().toString());
	   
	  userDao.update(user);
	  return true;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		return userDao.delete(id);
	}

	@Override
	@Transactional
	public List<User> search(String searchedPhrase) {
	
		return userDao.search(searchedPhrase);
	}

	@Override
	@Transactional
	public List<User> getUserWithTrainerRole() {
		
		List<User> usersWithTrainerRoleList=userDao.getAll();
		
		System.out.println("test1");
		System.out.println(usersWithTrainerRoleList.toString());
		
		Set<User> usersWithTrainerRoleSet=usersWithTrainerRoleList.stream()
			.filter(user -> user.getRoles().contains(roleDao.findRoleByName("ROLE_TRAINER")))
			.collect(Collectors.toSet());
		
		System.out.println("test2");
		System.out.println(usersWithTrainerRoleSet.toString());
		
		Set<User> trainers=trainerDAO.getTrainers()
				.stream()
				.map(trainer->trainer.getUser())
				.collect(Collectors.toSet());
		
		usersWithTrainerRoleSet.removeAll(trainers);
		
		System.out.println(usersWithTrainerRoleSet.toString());
		
		return usersWithTrainerRoleSet.stream().collect(Collectors.toList());
	}

	
}
