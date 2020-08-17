package com.myprojects.gza.myGymApp.service;

import java.util.List;

import com.myprojects.gza.myGymApp.entity.Page;

public interface PageService {
	boolean saveOrUpdate(Page page);
	List<Page> getAllPages();
	List<Page> searchPage(String pageName);
}
