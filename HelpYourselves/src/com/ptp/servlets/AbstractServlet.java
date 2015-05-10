package com.ptp.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class AbstractServlet
 */
public abstract class AbstractServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1665149782285298814L;
	private static final Logger logger = LoggerFactory.getLogger(AbstractServlet.class);
	
	protected static final String CONTENT_KEY = "CONTENT_KEY";
	
	public void sendResponse(HttpServletRequest request, HttpServletResponse response,
			String baseResponse) {
		response.setStatus(HttpServletResponse.SC_OK);
		response.setCharacterEncoding("UTF-8");
		
		try (PrintWriter writer = response.getWriter()) {
			// response.setContentType("application/json");
			writer.write(baseResponse);
		} catch (IOException e) {
			logger.error("Error with response PrintWriter", e);
		}
	}

	public String getContentString(HttpServletRequest request) {

		String content = null;
		Object o = request.getAttribute(CONTENT_KEY);
		if (o == null) {
			try (BufferedReader reader = request.getReader()) {
				StringBuilder builder = new StringBuilder();
				String line;
				while (null != (line = reader.readLine())) {
					builder.append(line);
				}
				content = builder.toString();
				request.setAttribute(CONTENT_KEY, content);
			} catch (IOException e) {
				logger.error("Error with BufferedReader from request", e);
			}
		} else if (o instanceof String) {
			content = (String) o;
		}
		return content;
	}

}
