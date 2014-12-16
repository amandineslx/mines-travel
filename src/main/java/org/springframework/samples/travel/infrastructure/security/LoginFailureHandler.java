package org.springframework.samples.travel.infrastructure.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailureHandler implements AuthenticationFailureHandler{

	public static int loginFailure = 0;
	
	public void onAuthenticationFailure(HttpServletRequest arg0,
			HttpServletResponse arg1, AuthenticationException arg2)
			throws IOException, ServletException {
		loginFailure ++;
		arg1.sendRedirect("../../users/login");
	}

	public static int getLoginFailure(){
		return loginFailure;
	}
}
