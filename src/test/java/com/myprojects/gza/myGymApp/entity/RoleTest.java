package com.myprojects.gza.myGymApp.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Roles")
class RoleTest {
	
	private Logger logger=Logger.getLogger(this.getClass().getName());

	@Test
	void newInstanceOfRoleShouldHaveNullString() {
		//given
		//when
		Role newRole=new Role();
		
		//then
		assertNull(newRole.getName());
		assertThat(newRole.getName()).isNull();
		
		assertEquals(newRole.getId(), 0);
		assertThat(newRole.getId()).isEqualTo(0);
	}
	
	@Test
	void newInstanceOfRoleShouldReturnTheSameStringNameWhichWasPassedInConstructor() {
		//given
		//when
		Role newRole=new Role("ROLE_ADMIN");
		
		//then
		assertThat(newRole.getName()).isEqualTo("ROLE_ADMIN");
	}
	
	@Test
	void arrayListConvertedToMapShouldHaveTheSameElementsAsTheGivenMap() {
		
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
		
		Collection<Role> rolesAsList=new ArrayList<Role>();
		
		rolesAsList.add(admin);
		rolesAsList.add(employee);
		rolesAsList.add(trainer);
		rolesAsList.add(client);
		rolesAsList.add(manager);
		
		logger.info(rolesAsList.toString());
		
		Map<Integer,String> rolesAsMap=new HashMap<Integer, String>();
		rolesAsMap.put(1, "ROLE_ADMIN");
		rolesAsMap.put(2, "ROLE_EMPLOYEE");
		rolesAsMap.put(3, "ROLE_TRAINER");
		rolesAsMap.put(4, "ROLE_CLIENT");
		rolesAsMap.put(5, "ROLE_MANAGER");
		
		logger.info(rolesAsMap.toString());
		
	//when
		
		Map<Integer,String> newRolesAsMap=Role.convertRoleCollectionToMap(rolesAsList);
		logger.info(newRolesAsMap.toString());
		
	//then
		assertThat(rolesAsMap).containsAllEntriesOf(newRolesAsMap);
	}
	
	@Test
	void arrayOfStringConvertedFromMapShouldHaveTheSameElementsAsGivenArray() {
	
	//given
		Map<Integer,String> rolesAsMapFull=new HashMap<Integer, String>();
		rolesAsMapFull.put(1, "ROLE_ADMIN");
		rolesAsMapFull.put(2, "ROLE_EMPLOYEE");
		rolesAsMapFull.put(3, "ROLE_TRAINER");
		rolesAsMapFull.put(4, "ROLE_CLIENT");
		rolesAsMapFull.put(5, "ROLE_MANAGER");
		
		Map<Integer, String> rolesAsMapVersion1=new HashMap<Integer, String>();
		rolesAsMapVersion1.put(1, "ROLE_ADMIN");
		rolesAsMapVersion1.put(2, "ROLE_EMPLOYEE");
		rolesAsMapVersion1.put(4, "ROLE_CLIENT");
		rolesAsMapVersion1.put(5, "ROLE_MANAGER");
		
		Map<Integer, String> rolesAsMapVersion2=new HashMap<Integer, String>();
		rolesAsMapVersion2.put(2, "ROLE_EMPLOYEE");
		rolesAsMapVersion2.put(4, "ROLE_CLIENT");
		rolesAsMapVersion2.put(5, "ROLE_MANAGER");
		
		Map<Integer, String> rolesAsMapEmpty=new HashMap<Integer, String>();
				
		logger.info(rolesAsMapFull.toString());
		logger.info(rolesAsMapVersion1.toString());
		logger.info(rolesAsMapVersion2.toString());
		logger.info(rolesAsMapEmpty.toString());
		
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
		rolesAsListVersion1.add(null);
		rolesAsListVersion1.add(client);
		rolesAsListVersion1.add(manager);
		
		Collection<Role> rolesAsListVersion2=new ArrayList<Role>();
		rolesAsListVersion2.add(null);
		rolesAsListVersion2.add(employee);
		rolesAsListVersion2.add(null);
		rolesAsListVersion2.add(client);
		rolesAsListVersion2.add(manager);
		
		Collection<Role> rolesAsListEmpty=new ArrayList<Role>();
		rolesAsListEmpty.add(null);
		rolesAsListEmpty.add(null);
		rolesAsListEmpty.add(null);
		rolesAsListEmpty.add(null);
		rolesAsListEmpty.add(null);
		
		logger.info(rolesAsListFull.toString());
		logger.info(rolesAsListVersion1.toString());
		logger.info(rolesAsListVersion2.toString());
		logger.info(rolesAsListEmpty.toString());
		
	//when
		Collection<Role> rolesAsListFullToCompare=Role.convertRoleMapToExtendedCollection(rolesAsMapFull);
		Collection<Role> rolesAsListVersion1ToCompare=Role.convertRoleMapToExtendedCollection(rolesAsMapVersion1);
		Collection<Role> rolesAsListVersion2ToCompare=Role.convertRoleMapToExtendedCollection(rolesAsMapVersion2);
		Collection<Role> rolesAsListEmptyToCompare=Role.convertRoleMapToExtendedCollection(rolesAsMapEmpty);
		
		logger.info(rolesAsListFullToCompare.toString());
		logger.info(rolesAsListVersion1ToCompare.toString());
		logger.info(rolesAsListVersion2ToCompare.toString());
		logger.info(rolesAsListEmptyToCompare.toString());
		
	//then
		assertThat(rolesAsListFull).hasSameElementsAs(rolesAsListFullToCompare);
		assertThat(rolesAsListVersion1).hasSameElementsAs(rolesAsListVersion1ToCompare);
		assertThat(rolesAsListVersion2).hasSameElementsAs(rolesAsListVersion2ToCompare);
		assertThat(rolesAsListEmpty).hasSameElementsAs(rolesAsListEmptyToCompare);
	}

}
