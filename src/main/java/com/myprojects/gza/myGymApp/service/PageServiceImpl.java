package com.myprojects.gza.myGymApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.gza.myGymApp.dao.PageDAO;
import com.myprojects.gza.myGymApp.entity.Page;

@Service
public class PageServiceImpl implements PageService{
	
	@Autowired
	private PageDAO pageDAO;
	
	@Transactional
	@Override
	public boolean saveOrUpdate(Page page) {
		
		return pageDAO.save(page);
	}

	@Transactional
	@Override
	public List<Page> getAllPages() {
		
		return pageDAO.getAll();
	}

	@Transactional
	@Override
	public List<Page> searchPage(String pageName) {

		return pageDAO.search(pageName);
	}

}
