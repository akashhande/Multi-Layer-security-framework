package com.src.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.bo.ServiceValidator;
import com.src.dao.GenericDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceValidator validate = new ServiceValidator();
    	
		if((validate.validate(request.getParameter("email")) && validate.validate(request.getParameter("email"))) && 
				((request.getParameter("email")!=null && request.getParameter("email")!=""))) {
		    try {
		    	GenericDao gDao = new GenericDao();
		    	Map<String, ArrayList<String>> result = gDao.checkEntry(request.getParameter("email"), request.getParameter("password"));
		    	if(result.get("iduser_info")!=null && !result.get("iduser_info").isEmpty()) {
		    		request.setAttribute("message", result);
			        request.getRequestDispatcher("/home.jsp").forward(request, response);
		    	} else if(result.get("iduser_info")==null) {
		    		request.setAttribute("message", result);
			        request.getRequestDispatcher("/home.jsp").forward(request, response);
		    	} else {
		    		request.setAttribute("message", "Please enter valid userid and password");
			        request.getRequestDispatcher("/index.jsp").forward(request, response);
		    	}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("message", "Please do not enter restricted special character and malicious keyword");
	        request.getRequestDispatcher("/index.jsp").forward(request, response);
			System.out.println("Please do not enter restricted special character and malicious keyword");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
