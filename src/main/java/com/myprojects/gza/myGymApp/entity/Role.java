package com.myprojects.gza.myGymApp.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.myprojects.gza.myGymApp.helperClasses.Roles;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "role_name")
	private String name;
	
	public Role() {}

	public Role(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	public static Map<Integer, String> convertRoleCollectionToMap(Collection<Role> roleCollection){
		
		Map<Integer,String> mappedRoles=roleCollection.stream().collect(Collectors.toMap(Role::getId, Role::getName));
		
		return mappedRoles;
	}
	
	public static Collection<Role> convertRoleMapToExtendedCollection(Map<Integer,String> mappedRoles) {
		
		if(mappedRoles==null) return null;

		int sizeOfList=Roles.values().length;
		
		Collection<Role> roles=new ArrayList<Role>();
		
		for(int i=1; i<=sizeOfList; i++) {
			
			if(mappedRoles.containsKey(i)) {
				Role tempRole=new Role(mappedRoles.get(i));
				tempRole.setId(i);
				roles.add(tempRole);
			}else {
				roles.add(null);
			}
		}
		
		return roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
