package me.quantumti.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlMappingLoginPageStrategy implements LoginPageStrategy {
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
		String targetUrl = "";
		if (uri.indexOf("admin") != -1) {
			targetUrl = "/admin/login/";
		} else {
			targetUrl = "/login/";
		}
		// String uri = request.getRequestURI();
		// String targetUrl = "";
		// if (uri.indexOf("login") != -1) {
		// targetUrl = "/toLogin.do";
		// }
		targetUrl = request.getContextPath() + targetUrl;
		response.sendRedirect(targetUrl);
	}
}
