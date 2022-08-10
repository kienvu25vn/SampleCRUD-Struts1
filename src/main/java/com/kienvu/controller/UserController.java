package com.kienvu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.ForwardAction;
import org.apache.struts.actions.MappingDispatchAction;

import com.kienvu.model.User;
import com.kienvu.service.UserService;

public class UserController extends MappingDispatchAction{
	
	public ActionForward login(ActionMapping mapping , ActionForm form , HttpServletRequest request , HttpServletResponse response )throws Exception{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserService userService = new UserService();
		HttpSession session = request.getSession();
		if(userService.login(user) != null) {
			session.setAttribute("userLogin", user);
			response.sendRedirect("/SampleCRUD/home.html");
		}
		request.setAttribute("message","Username or Password isn't correct!" );
		return mapping.findForward("loginError");
	}

	public ActionForward showHomePage(ActionMapping mapping , ActionForm form , HttpServletRequest request , HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		if(session.getAttribute("userLogin") == null) {
			response.sendRedirect("/SampleCRUD/login-view.html");
		}
		UserService userService = new UserService();
		List<User> users = userService.getAllUsers();
		request.setAttribute("list", users);
		return mapping.findForward("viewUser");
	}
	public ActionForward createUser(ActionMapping mapping , ActionForm form , HttpServletRequest request , HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("userLogin") == null) {
			response.sendRedirect("/SampleCRUD/login-view.html");
		}
		return mapping.findForward("createUser");
	}
	public void addUser(ActionMapping mapping , ActionForm form, HttpServletRequest request , HttpServletResponse response) throws Exception{
		
		UserService userService = new UserService();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		Integer age = Integer.valueOf(request.getParameter("age"));
		String email = request.getParameter("email");
		userService.saveUser(new User(username,password,fullname,age,email));
		response.sendRedirect("/SampleCRUD/home.html");
	}
	
	public ActionForward deleteUser(ActionMapping mapping , ActionForm form, HttpServletRequest request , HttpServletResponse response) throws Exception{
		UserService userService = new UserService();
		Integer idUser = Integer.valueOf(request.getParameter("idUser"));
		int delete = userService.deleteUser(idUser);
		if(delete > 0) {
			response.sendRedirect("/SampleCRUD/home.html");
		}else {
			request.setAttribute("message", "Cant delete user, please try again!");
		}
		List<User> users = userService.getAllUsers();
		request.setAttribute("list", users);
		return mapping.findForward("viewUser");		
	}

}
