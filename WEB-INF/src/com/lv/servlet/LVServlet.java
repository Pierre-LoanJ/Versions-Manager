package com.lv.servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import com.lv.auth.*;
import com.lv.cache.Cache;
import com.harry.dll.*;

import java.net.ServerSocket;
import java.net.Socket;

public class LVServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendError(401);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String key = request.getParameter("key");
		String ad = "782BCBA8E5B8";
		String dKey = null;
		try {
			//dKey = jHPAPI.getInstance().getDecryptKey(key, ad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("CLE " + dKey);
		boolean bOK = dKey != null;
		bOK = true;
		if (bOK) {
			
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
		}
		else {
			response.sendError(403);
		}
		//response.sendRedirect("jsp/home.jsp");									// jsp.home.jsp apparait dans l'url
	}
}
