package com.myprojects.gza.myGymApp.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.myprojects.gza.myGymApp.helperClasses.Roles;
import com.myprojects.gza.myGymApp.helperClasses.View;
import com.myprojects.gza.myGymApp.validation.ValidTelephoneNumber;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@JsonView(View.Summary.class)
	private int id;
	
	@NotNull(message ="Imię użytkownika jest wymagane.")
	@Size(min = 2, max = 32, message = "Imię użytkownika powinno zawierać od 2 do 32 znaków.")
	@Column(name="name")
	@JsonView(View.Summary.class)
	private String name;
	
	@NotNull(message ="Nazwisko użytkownika jest wymagane.")
	@Size(min = 2, max = 32, message = "Nazwisko użytkownika powinno zawierać od 2 do 32 znaków.")
	@Column(name="surname")
	@JsonView(View.Summary.class)
	private String surname;
	
	@Email
	@NotNull(message ="Adres email jest wymagany.")
	@Column(name="email")
	@JsonView(View.Summary.class)
	private String email;
	
	@ValidTelephoneNumber()
	@Column(name="telephone")
	@JsonView(View.Summary.class)
	private String telephone;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Password userPassword;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_details_id")
	@JsonView(View.Details.class)
	private UserDetails userDetails;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_address_id")
	private UserAddress userAddress;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_agreements_id")
	private UserAgreements userAgreements;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="role_id"))
	private Collection<Role> roles;
	
	@ManyToMany(mappedBy = "users", cascade = {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	private Collection<FitnessEvent> fitnessEvents;
	
	@Transient
	private String[] role=new String[Roles.values().length];
	
	public User() {}
	
	public User(int id, String name, String surname, String email, String telephone, Password password) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone = telephone;
		this.userPassword=password;
	}

	public User(String name, String surname, String email, String telephone, Password password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone=telephone;
		this.userPassword=password;
	}
	
	public User(String name, String surname, String email, String telephone) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone=telephone;
	}
	
	public User(int id, String name, String surname, String email) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public User(int id, String name, String surname, String email, String telephone, Password password,
			UserDetails userDetails, UserAddress userAddress, UserAgreements userAgreements, Collection<Role> roles) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone = telephone;
		this.userPassword=password;
		this.userDetails = userDetails;
		this.userAddress = userAddress;
		this.userAgreements = userAgreements;
		this.roles = roles;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Password getPassword() {
		return userPassword;
	}

	public void setPassword(Password password) {
		this.userPassword = password;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public UserAgreements getUserAgreements() {
		return userAgreements;
	}

	public void setUserAgreements(UserAgreements userAgreements) {
		this.userAgreements = userAgreements;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	public void extendRoleCollection() {
		
		Map<Integer, String> mappedRoles=Role.convertRoleCollectionToMap(this.getRoles());
		
		this.setRoles(Role.convertRoleMapToExtendedCollection(mappedRoles));
	}
	
	public void shortenRoleCollection() {
		
		Collection<Role> tempRoles=this.getRoles()
				.stream()
				.filter(role->role!=null)
				.collect(Collectors.toList());
		
		this.setRoles(tempRoles);
	}
	
	public void mapRoleCollectionToArray() {
		
		int size=Roles.values().length;
		
		Map<Integer,String> mappedCollection=Role.convertRoleCollectionToMap(this.getRoles());
		
		System.out.println(mappedCollection.toString());
		
		String[] userRoles=new String[size];
		
		for(int i=0; i<size; i++) {
			if(mappedCollection.containsKey(i+1)) {
				userRoles[i]=mappedCollection.get(i+1);
			}else {
				userRoles[i]=null;
			}
		}
		
		this.role=userRoles;
	}
	
	public void mapArrayToRoleCollection() {
		
		String[] userRoles=this.getRole();
		
		Collection<Role> tempRoles=new ArrayList<Role>();
		
		for(int i=0; i<userRoles.length; i++) {
			if(userRoles[i]!=null) {
				Role tempRole=new Role(userRoles[i]);
				tempRole.setId(i+1);
				tempRoles.add(tempRole);
			}else {
				continue;
			}
		}
		
		this.setRoles(tempRoles);
	}
	
	public String[] getRole() {
		return role;
	}
	
	public void setRole(String[] role) {
		this.role=role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", telephone="
				+ telephone + ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	
}
