package com.myprojects.gza.myGymApp.dao;

import com.myprojects.gza.myGymApp.entity.Page;

public interface PageDAO extends DAO<Page>{
	Page getPageByName(String pageName);
}
