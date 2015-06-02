package me.quantumti.web.security;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.util.StringUtils;

public class SecurityUrlLogoutSuccessHandler extends
		SimpleUrlLogoutSuccessHandler {
	private final static Logger logger = LoggerFactory
			.getLogger(SecurityUrlLogoutSuccessHandler.class);

	@Override
	protected String determineTargetUrl(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("退出");
		if (isAlwaysUseDefaultTargetUrl()) {
			return getDefaultTargetUrl();
		}

		// Check for the parameter and use that if available
		String targetUrl = request.getParameter("targetUrlParameter");

		if (StringUtils.hasText(targetUrl)) {
			try {
				targetUrl = URLDecoder.decode(targetUrl, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new IllegalStateException(
						"UTF-8 not supported. Shouldn't be possible");
			}

			logger.debug("Found targetUrlParameter in request: " + targetUrl);

			return targetUrl;
		}

		// targetUrl = "/";

		// 自定义退出后跳转的页面
		String uri = request.getHeader("referer");
		if (uri.indexOf("admin") != -1) {
			targetUrl = "/admin/login/";
		} else {
			targetUrl = "/login/";
		}

		return targetUrl;
	}
}
