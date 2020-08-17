package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.gza.myGymApp.entity.Page;

@Repository
public class PageDAOImpl implements PageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Page page) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Page tempPage=getPageByName(page.getPage());
		
		if(tempPage==null) {
			tempPage=page;
			tempPage.setNumberOfViews(0);
		}
		
		tempPage.setNumberOfViews(tempPage.getNumberOfViews()+1);
		
		try {
			currentSession.saveOrUpdate(tempPage);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public Page getById(int id) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Page tempPage=null;
		
		try {
			tempPage=currentSession.get(Page.class, id);
		}catch(Exception e) {
			e.printStackTrace();
			tempPage=null;
		}
		
		return tempPage;
	}

	@Override
	public List<Page> getAll() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Page> theQuery=currentSession.createQuery("from Page order by page",Page.class);
		
		List<Page> allPages=theQuery.getResultList();
		
		return allPages;
	}

	@Override
	public List<Page> search(String searchedPhrase) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Page> theQuery=null;
		
		if(searchedPhrase!=null && searchedPhrase.trim().length()>0) {
			theQuery=currentSession.createQuery("from Page where lower(page) like :theSearchName", Page.class);
			theQuery.setParameter("theSearchName", "%"+searchedPhrase+"%");
		}else {
			theQuery=currentSession.createQuery("from Page order by page",Page.class);
		}
		
		List<Page> searchedPage=theQuery.getResultList();
		
		return searchedPage;
	}

	@Override
	public boolean update(Page page) {
		return save(page);
	}

	@Override
	public boolean delete(int id) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Page> theQuery=currentSession.createQuery("delete from Page where id=:pageId", Page.class);
		theQuery.setParameter("pageId", id);
		
		try {
			theQuery.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public Page getPageByName(String pageName) {
		
		Session curreSession=sessionFactory.getCurrentSession();
		
		Query<Page> theQuery=curreSession.createQuery("from Page where page=:pageName", Page.class);
		theQuery.setParameter("pageName", pageName);
		
		Page tempPage=null;
		
		try {
			tempPage=theQuery.getSingleResult();
		}catch(Exception e) {
			tempPage=null;
		}
		
		
		return tempPage;
	}

	

}
