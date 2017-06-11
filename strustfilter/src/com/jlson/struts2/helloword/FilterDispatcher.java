package com.jlson.struts2.helloword;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FilterDispatcher
 */
@WebFilter("*.action")
public class FilterDispatcher implements Filter
{

	/**
	 * Default constructor.
	 */
	public FilterDispatcher()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{

		// 1.获取ServletPath
		HttpServletRequest req = (HttpServletRequest) request;
		String servletPath = req.getServletPath();
		// 2.解析请求地址,若为/producnt-input.action，则转发/WEB-INF/input.jsp
		String path = null;
		if ("/producnt-input.action".equals(servletPath))
		{
			path = "/WEB-INF/input.jsp";
		}
		// 3.若为product-save.action，则
		if ("/product-save.action".equals(servletPath))
		{
			String productName = req.getParameter("productName");
			String productDes = req.getParameter("productDes");
			String productPrice = req.getParameter("productPrice");
			Product product = new Product(productName, 1001, productDes, Double.parseDouble(productPrice));
			req.setAttribute("product", product);
			System.out.println(product);
			path = "/WEB-INF/detail.jsp";
		}

		if (path != null)
		{
			req.getRequestDispatcher(path).forward(request, response);
			return;
		}

		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		// TODO Auto-generated method stub
	}

}
