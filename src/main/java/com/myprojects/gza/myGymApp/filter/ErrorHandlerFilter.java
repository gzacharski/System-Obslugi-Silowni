package com.myprojects.gza.myGymApp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class ErrorHandlerFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse httpResponse=(HttpServletResponse) response;
		System.out.println("helllo from filter");
		if(httpResponse.getStatus()==404) {
			httpResponse.sendRedirect("/error/404");
		}else {
			try {
				chain.doFilter(request, response);
			} catch (Exception ex) {
				request.getRequestDispatcher("/WEB-INF/view/errors/error.jsp").forward(request, response);
			}
		}
	}
}
