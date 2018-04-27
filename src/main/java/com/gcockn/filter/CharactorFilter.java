package com.gcockn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharactorFilter implements Filter{

	String encode = null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encode = filterConfig.getInitParameter("encode");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			if(encode!=null){
				request.setCharacterEncoding(encode);
				response.setContentType("text/html charset="+encode);
			}
			chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		encode = null;
	}

}
