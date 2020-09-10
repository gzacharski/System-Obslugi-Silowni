package com.myprojects.gza.myGymApp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class Error404HandlerFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			chain.doFilter(request, response);
		} catch (Exception ex) {
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
		}
	}

}
