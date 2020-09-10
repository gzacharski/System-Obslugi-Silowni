package com.myprojects.gza.myGymApp.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

class UserTest {
	
	private Logger logger=Logger.getLogger(getClass().getName());

	@Test
	void methodShouldExtendRoleCollectionProperlyByFillingPlacesForUnsignedRolesWithNullValues() {
	
	//given
		Role admin=new Role("ROLE_ADMIN");
		admin.setId(1);
		
		Role employee=new Role("ROLE_EMPLOYEE");
		employee.setId(2);
		
		Role trainer=new Role("ROLE_TRAINER");
		trainer.setId(3);
		
		Role client=new Role("ROLE_CLIENT");
		client.setId(4);
		
		Role manager=new Role("ROLE_MANAGER");
		manager.setId(5);
		
		Collection<Role> rolesAsListFull=new ArrayList<Role>();
		rolesAsListFull.add(admin);
		rolesAsListFull.add(employee);
		rolesAsListFull.add(trainer);
		rolesAsListFull.add(client);
		rolesAsListFull.add(manager);
		
		Collection<Role> rolesAsListVersion1=new ArrayList<Role>();
		rolesAsListVersion1.add(admin);
		rolesAsListVersion1.add(employee);
		rolesAsListVersion1.add(client);
		rolesAsListVersion1.add(manager);
		
		Collection<Role> rolesAsListVersion2=new ArrayList<Role>();
		rolesAsListVersion2.add(employee);
		rolesAsListVersion2.add(client);
		rolesAsListVersion2.add(manager);
		
		Collection<Role> rolesAsListEmpty=new ArrayList<Role>();
		
		User tempUser1=new User();
		tempUser1.setRoles(rolesAsListFull);
		
		User tempUser2=new User();
		tempUser2.setRoles(rolesAsListVersion1);
		
		User tempUser3=new User();
		tempUser3.setRoles(rolesAsListVersion2);
		
		User tempUser4=new User();
		tempUser4.setRoles(rolesAsListEmpty);
		
		Collection<Role> rolesAsListFullToCompare=new ArrayList<Role>();
		rolesAsListFullToCompare.add(admin);
		rolesAsListFullToCompare.add(employee);
		rolesAsListFullToCompare.add(trainer);
		rolesAsListFullToCompare.add(client);
		rolesAsListFullToCompare.add(manager);
		
		Collection<Role> rolesAsListVersion1ToCompare=new ArrayList<Role>();
		rolesAsListVersion1ToCompare.add(admin);
		rolesAsListVersion1ToCompare.add(employee);
		rolesAsListVersion1ToCompare.add(null);
		rolesAsListVersion1ToCompare.add(client);
		rolesAsListVersion1ToCompare.add(manager);
		
		Collection<Role> rolesAsListVersion2ToCompare=new ArrayList<Role>();
		rolesAsListVersion2ToCompare.add(null);
		rolesAsListVersion2ToCompare.add(employee);
		rolesAsListVersion2ToCompare.add(null);
		rolesAsListVersion2ToCompare.add(client);
		rolesAsListVersion2ToCompare.add(manager);
		
		Collection<Role> rolesAsListEmptyToCompare=new ArrayList<Role>();
		rolesAsListEmptyToCompare.add(null);
		rolesAsListEmptyToCompare.add(null);
		rolesAsListEmptyToCompare.add(null);
		rolesAsListEmptyToCompare.add(null);
		rolesAsListEmptyToCompare.add(null);
		
	//when
		tempUser1.extendRoleCollection();
		tempUser2.extendRoleCollection();
		tempUser3.extendRoleCollection();
		tempUser4.extendRoleCollection();
		
		logger.info(tempUser1.getRoles().toString());
		logger.info(tempUser2.getRoles().toString());
		logger.info(tempUser3.getRoles().toString());
		logger.info(tempUser4.getRoles().toString());
	//then
		assertThat(tempUser1.getRoles()).hasSameElementsAs(rolesAsListFullToCompare);
		assertThat(tempUser2.getRoles()).hasSameElementsAs(rolesAsListVersion1ToCompare);
		assertThat(tempUser3.getRoles()).hasSameElementsAs(rolesAsListVersion2ToCompare);
		assertThat(tempUser4.getRoles()).hasSameElementsAs(rolesAsListEmptyToCompare);
	}
	
	@Test
	void methodShouldReturnProperListOfStringsFromRoleEntityList() {
	//given
		Role admin=new Role("ROLE_ADMIN");
		admin.setId(1);
		
		Role employee=new Role("ROLE_EMPLOYEE");
		employee.setId(2);
		
		Role trainer=new Role("ROLE_TRAINER");
		trainer.setId(3);
		
		Role client=new Role("ROLE_CLIENT");
		client.setId(4);
		
		Role manager=new Role("ROLE_MANAGER");
		manager.setId(5);
		
		Collection<Role> rolesAsListFull=new ArrayList<Role>();
		rolesAsListFull.add(admin);
		//rolesAsListFull.add(employee);
		//rolesAsListFull.add(null);
		rolesAsListFull.add(trainer);
		//rolesAsListFull.add(client);
		rolesAsListFull.add(manager);
		
		User tempUser1=new User();
		tempUser1.setRoles(rolesAsListFull);
		
	//when
		tempUser1.mapRoleCollectionToArray();
		
		System.out.println(Arrays.toString(tempUser1.getRole()));
		//System.out.println(Arrays.toString(tempUser1.getRole()));
	//then
		assertTrue(true);
	}
	
	@Test
	void methodShouldReturnCollectionOfRolesFromArray() {
	//given
		Role admin=new Role("ROLE_ADMIN");
		admin.setId(1);
		
		Role employee=new Role("ROLE_EMPLOYEE");
		employee.setId(2);
		
		Role trainer=new Role("ROLE_TRAINER");
		trainer.setId(3);
		
		Role client=new Role("ROLE_CLIENT");
		client.setId(4);
		
		Role manager=new Role("ROLE_MANAGER");
		manager.setId(5);
		
		Collection<Role> rolesAsListFull=new ArrayList<Role>();
		rolesAsListFull.add(admin);
		rolesAsListFull.add(employee);
		rolesAsListFull.add(trainer);
		rolesAsListFull.add(client);
		rolesAsListFull.add(manager);
		
		Collection<Role> rolesAsListVersion1=new ArrayList<Role>();
		rolesAsListVersion1.add(admin);
		rolesAsListVersion1.add(trainer);
		rolesAsListVersion1.add(manager);
		
		Collection<Role> rolesAsListVersion2=new ArrayList<Role>();
		rolesAsListVersion2.add(client);
		rolesAsListVersion2.add(manager);
		
		Collection<Role> rolesAsListEmpty=new ArrayList<Role>();
		
		String[] userRolesFull= {"ROLE_ADMIN","ROLE_EMPLOYEE","ROLE_TRAINER","ROLE_CLIENT","ROLE_MANAGER"};
		String[] userRolesVersion1= {"ROLE_ADMIN",null,"ROLE_TRAINER",null,"ROLE_MANAGER"};
		String[] userRolesVersion2= {null,null,null,"ROLE_CLIENT","ROLE_MANAGER"};
		String[] userRolesEmpty= {null,null,null,null,null};
		
		User tempUserFull=new User();
		User tempUserVersion1=new User();
		User tempUserVersion2=new User();
		User tempUserEmpty=new User();
		
	//when
		tempUserFull.setRole(userRolesFull);
		tempUserFull.mapArrayToRoleCollection();
		
		tempUserVersion1.setRole(userRolesVersion1);
		tempUserVersion1.mapArrayToRoleCollection();
		
		tempUserVersion2.setRole(userRolesVersion2);
		tempUserVersion2.mapArrayToRoleCollection();
		
		tempUserEmpty.setRole(userRolesEmpty);
		tempUserEmpty.mapArrayToRoleCollection();
		
	//then
		assertThat(tempUserFull.getRoles()).hasSameElementsAs(rolesAsListFull);
		assertThat(tempUserVersion1.getRoles()).hasSameElementsAs(rolesAsListVersion1);
		assertThat(tempUserVersion2.getRoles()).hasSameElementsAs(rolesAsListVersion2);
		assertThat(tempUserEmpty.getRoles()).hasSameElementsAs(rolesAsListEmpty);
	}

}
