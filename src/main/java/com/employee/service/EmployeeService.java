package com.employee.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDTO;
import com.employee.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	
	private EmployeeMapper mapper;

	public EmployeeService(EmployeeMapper mapper) {
		this.mapper = mapper;
	}

	public EmployeeDTO selectemployee(String eno, String ename) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("eno", eno);
		map.put("ename", ename);
		return mapper.selectemployee(map);
	}

	public List<EmployeeDTO> selectAllEmployee() {
		return mapper.selectAllEmployee();
	}

	public int deleteEmployee(String eno) {
		return mapper.deleteEmployee(eno);
	}

	public int insertEmployee(String eno, String eName, String eDepart, int salary, int positionNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("eno", eno);
		map.put("eName", eName);
		map.put("eDepart", eDepart);
		map.put("salary", salary);
		map.put("positionNo", positionNo);
		
		return mapper.insertEmployee(map);
	}

	public EmployeeDTO searchEmployee(String searchtype, String search) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchtype", searchtype);
		map.put("search", search);
		return mapper.searchEmployee(map);
	}

	public EmployeeDTO selectemployee1(String eno) {
		return mapper.selectemployee1(eno);
	}
	
	
}
