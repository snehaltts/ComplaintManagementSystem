package com.ltts.project.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ltts.project.Dao.ComplaintDao;
import com.ltts.project.Dao.MemberDao;
import com.ltts.project.model.Complaint;
import com.ltts.project.model.Member;

@RestController
public class HomeController {
	
	@Autowired
	MemberDao md;
	
	@Autowired
	ComplaintDao cd;

//	@InitBinder
//    public void initBinder(WebDataBinder binder) {
//        // Date - dd/MM/yyyy
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }

	@RequestMapping("/hi")
	public String firstMethod() {
		return "Hello SpringBoot";
	}
	
	@RequestMapping(" ")
	public ModelAndView secondMethod() {
		return new ModelAndView("index");
	}
	@RequestMapping("/registration")
	public ModelAndView registerUser() {
		return new ModelAndView("registration");
	}
	@RequestMapping("/login")
	public ModelAndView loginUser() {
		return new ModelAndView("login");
	}
	@RequestMapping("/ComplaintRegister")
	public ModelAndView complainregister() {
		return new ModelAndView("ComplaintRegister");
	}

	@RequestMapping(value="adduser", method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req, Model model) {
		ModelAndView mv=null;
		String empName=req.getParameter("empName");
		String password=req.getParameter("password");
		String desig=req.getParameter("desig");
		String department=req.getParameter("department");
		String immediatesupervisor=req.getParameter("immediatesupervisor");
		String mobile=req.getParameter("mobile");
		String email=req.getParameter("email");
		String empid=req.getParameter("empid");
		
	//	ApplicationContext ac=new ClassPathXmlApplicationContext();
		Member m=new Member(empName, password, desig, department, immediatesupervisor, email,
				 mobile, empid);
		System.out.println("***** INSIDE CONTROLLER ****"+m);
		boolean b=md.InsertMember(m);
		if(b==false) {
			mv=new ModelAndView("success");
			model.addAttribute("msg", "Successfully Inserted.. ");
		}
		else {
			mv=new ModelAndView("error");
			model.addAttribute("msg", "Error due to Connection");
			
		}
		return mv;
	}
	
	@RequestMapping(value="complaintregister", method=RequestMethod.POST)
	public ModelAndView complaintregister(HttpServletRequest req, Model model) {
		ModelAndView mv=null;
		String complaintDescription=req.getParameter("complaintDescription");
		String complaintIncharge=req.getParameter("complaintIncharge");
		String complaintSubject=req.getParameter("complaintSubject");
		String complaintType=req.getParameter("complaintType");
		String requestStatus=req.getParameter("requestStatus");
		String date=req.getParameter("date");
		Date d=Date.valueOf(date);
		String comid=req.getParameter("comid");

		
	//	ApplicationContext ac=new ClassPathXmlApplicationContext();
		Complaint c=new Complaint(complaintDescription, complaintIncharge, complaintSubject, complaintType, requestStatus, d, comid);
		System.out.println("***** INSIDE CONTROLLER ****"+c);
		boolean b=cd.InsertComplaint(c);
		if(b==false) {
			mv=new ModelAndView("success");
			model.addAttribute("msg", "Successfully Inserted.. ");
		}
		else {
			mv=new ModelAndView("error");
			model.addAttribute("msg", "Error due to Connection");
			
		}
		return mv;
	}
	@RequestMapping(value="checkuser", method=RequestMethod.POST)
	public ModelAndView checkUser(HttpServletRequest req, Model model) {
		ModelAndView mv=null;
		String empid=req.getParameter("empid");
		String password=req.getParameter("password");
		
		Member m=md.getMemberById(empid);
		System.out.println( m);
		if(m !=null) {
		
			if(password.equals(m.getPassword())) {
				model.addAttribute("value", m.getEmpName());
				mv=new ModelAndView("welcome");
			}
			else {
				model.addAttribute("msg", "Password Wrong");
				mv=new ModelAndView("login");
			}
		}
		else {
			model.addAttribute("msg", "User Not Found Please Register");
			mv=new ModelAndView("login");
		}
		return mv;
}
	@RequestMapping("/ComplaintView")
	public ModelAndView viewAllComplaints(Model model) {
		ModelAndView mv=new ModelAndView("ComplaintView");
		List<Complaint> li=cd.getAllComplaint();
		
		model.addAttribute("list", li);
		
		return mv;
	}
//	   @RequestMapping(value = "/update-Complaint", method = RequestMethod.GET)
//	    public String showUpdateComplaintDao(@RequestParam long comid, Model model) {
//	        ComplaintDao c = ComplaintDao.getComplaintById(comid).get();
//	        model.addAttribute("complaint", c);
//	        return "complaint";
//	    }
//
//	    @RequestMapping(value = "/update-complaint", method = RequestMethod.POST)
//	    public String updateComplaint(Model model, @Validated Complaint complaint, BindingResult result) {
//
//	        if (result.hasErrors()) {
//	            return "complaint";
//	        }
//
//	        complaint.setUserName(getLoggedInUserName(model));
//	        complaint.updateComplaint(complaint);
//	        return "redirect:/list-complaint";
//	    }

}
