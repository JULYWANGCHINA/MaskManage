package me.quantumti.web.security;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

public class SecurityLoginSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {
	private final static Logger logger = LoggerFactory
			.getLogger(SecurityLoginSuccessHandler.class);

	@Override
	protected String determineTargetUrl(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("登录成功");
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
		
//		SystemUser user = (SystemUser) SecurityContextHolder.getContext()
//		.getAuthentication().getPrincipal();
	//model.addAttribute("user", user);

		String uri = request.getHeader("referer");
		logger.info("uri referer:" + uri);
		if (uri.indexOf("admin") != -1) {
			targetUrl = "/admin/index";
		} else {
			targetUrl = "/index/";
		}

		logger.info("URL地址:" + targetUrl);
		return targetUrl;
	}
}
