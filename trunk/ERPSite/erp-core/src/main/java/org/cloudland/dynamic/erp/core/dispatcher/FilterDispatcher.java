/**
  *
  * @Title FilterDispatcher.java
  * @Package org.cloudland.dynamic.erp.dispatcher
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-9-29
  * @version 1.0
  */
package org.cloudland.dynamic.erp.core.dispatcher;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

/**
 * 
 * @ClassName FilterDispatcher
 * @Description TODO
 * @author Lei
 * @date 2012-9-29 上午09:36:01
 *
 */
public class FilterDispatcher implements Filter {
	
	/**
	  * @Fields LOGGER 日志对象
	  */
	private static final Logger LOGGER = Logger.getLogger(FilterDispatcher.class);
	
	/* 
	 * Title init
	 * Description
	 * @param filerConfig
	 * @throws ServletException
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filerConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	/* 
	 * Title destroy
	 * Description
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* 
	 * Title doFilter
	 * Description
	 * @param servletRequest
	 * @param servletResponse
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		LOGGER.info("========================");
	}

}
