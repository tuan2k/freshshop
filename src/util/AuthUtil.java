package util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthUtil {
	
	public static boolean checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		if (session.getAttribute("userLogin") == null) {
			return false;
		}
		return true;
	}
	
	public static boolean checkLoginAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		if (session.getAttribute("userAdmin") == null) {
			return false;
		}
		return true;
	}
}
