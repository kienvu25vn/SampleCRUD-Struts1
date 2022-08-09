package com.kienvu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.ForwardAction;
import org.apache.struts.actions.MappingDispatchAction;

import com.kienvu.model.User;
import com.kienvu.service.UserService;
import com.sun.java_cup.internal.internal_error;

public class UserController extends MappingDispatchAction{
	

	public ActionForward showHomePage(ActionMapping mapping , ActionForm form , HttpServletRequest request , HttpServletResponse response) throws Exception{
		UserService userService = new UserService();
		List<User> users = userService.getAllUsers();
		request.setAttribute("list", users);
		return mapping.findForward("viewUser");
	}
	
	public void addUser(ActionMapping mapping , ActionForm form, HttpServletRequest request , HttpServletResponse response) throws Exception{
		
		UserService userService = new UserService();
		String name = request.getParameter("name");
		Integer age = Integer.valueOf(request.getParameter("age"));
		String email = request.getParameter("email");
		userService.saveUser(new User(name,age,email));
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
