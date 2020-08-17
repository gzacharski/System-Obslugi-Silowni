package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.gza.myGymApp.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Role findRoleByName(String roleName) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Role> theQuery=currentSession.createQuery("from Role where name=:roleName",Role.class);
		theQuery.setParameter("roleName", roleName);
		
		Role role=null;
		
		try {
			role=theQuery.getSingleResult();
		}catch(Exception e) {
			role=null;
		}
		
		return role;
	}

	@Override
	public List<Role> getAllRoles() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Role> theQuery=currentSession.createQuery("from Role",Role.class);
		
		List<Role> roles=theQuery.getResultList();
		
		return roles;
	}

}
