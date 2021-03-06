package org.springframework.samples.travel.infrastructure.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	public static int loginSuccess = 0;
	
	public void onAuthenticationSuccess(HttpServletRequest arg0,
			HttpServletResponse arg1, Authentication arg2) throws IOException,
			ServletException {
		loginSuccess++;
		arg1.sendRedirect("../../hotels/search/");
	}
	
	public static int getLoginSuccess(){
		return loginSuccess;
	}
}
