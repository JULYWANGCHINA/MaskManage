package me.quantumti.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

public class SecurityLoginErrorHandler extends
		ExceptionMappingAuthenticationFailureHandler {
	private final static Logger logger = LoggerFactory
			.getLogger(SecurityLoginErrorHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		logger.info("登录失败");
		// String url = "/?msg=1";
		String url = "";
		request.getSession().setAttribute("errorMsg", "用户名密码错误!");
		String uri = request.getHeader("referer");
		if (uri.indexOf("admin") != -1) {
			url = "/admin/login/";
		} else {
			url = "/login/";
		}
		getRedirectStrategy().sendRedirect(request, response, url);
	}
}
