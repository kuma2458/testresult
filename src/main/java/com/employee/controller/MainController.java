package com.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.employee.dto.EmployeeDTO;
import com.employee.service.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@Controller
public class MainController {
	
	private EmployeeService service;

	public MainController(EmployeeService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public ModelAndView start(ModelAndView view) {
		view.setViewName("index");
		return view;
	}
	
	@PostMapping("/login")
	public String login(@PathParam(value = "") String eno,@PathParam(value = "")  String ename, HttpSession session, HttpServletResponse response) throws IOException {
		EmployeeDTO dto = service.selectemployee(eno,ename);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		if(dto==null) {
			pw.write("<script>alert('입력하신 정보를 확인하세요'); location.href='/';</script>");
			return null;
		}
		if(dto.getPositionNo()<4) {
			pw.write("<script>alert('권한이 없습니다'); location.href='/';</script>");
			return null;
		}
		session.setAttribute("dto", dto);
		return "redirect:/main";
	}
	
	@RequestMapping("/main")
	public ModelAndView main(ModelAndView view) {
		view.setViewName("employee_main");
		List<EmployeeDTO> list=service.selectAllEmployee();
		view.addObject("list", list);
		return view;
	}
	
	@RequestMapping("/employee/delete")
	public String deleteEmployee(String eno) {
		service.deleteEmployee(eno);
		return "redirect:/main";
	}
	
	@RequestMapping("/employee/update/view")
	public ModelAndView updateEmployee(String eno,ModelAndView view) {
		EmployeeDTO dto=service.selectemployee1(eno);
		view.addObject("dto", dto);
		view.setViewName("employee_update");
		return view;
	}
	
	@PostMapping("/employee/insert")
	public String insertemployee(String eno,String eName,String eDepart,int salary,int positionNo, HttpServletResponse response) throws IOException {
		
		int result = service.insertEmployee(eno,eName,eDepart,salary,positionNo);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		if(result==0) {
			pw.write("<script>alert('데이터 등록에 실패하였습니다'); location.href='/';</script>");
			return null;
		}
		return "redirect:/main";
	}
	
	@PostMapping("/employee/search")
	public ResponseEntity searchEmployee(String searchtype,String search) {
		System.out.println(searchtype);
		System.out.println(search);
		HashMap<String, Object> map=new HashMap<String,Object>();
		EmployeeDTO dto = service.searchEmployee(searchtype,search);
		map.put("dto", dto);
		return new ResponseEntity(map,HttpStatus.OK);
	}
}
