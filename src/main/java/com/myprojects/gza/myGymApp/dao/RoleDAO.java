package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import com.myprojects.gza.myGymApp.entity.Role;

public interface RoleDAO {
	Role findRoleByName(String roleName);
	List<Role> getAllRoles();
}
