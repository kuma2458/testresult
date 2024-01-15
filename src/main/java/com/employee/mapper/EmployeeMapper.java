package com.employee.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.employee.dto.EmployeeDTO;

@Mapper
public interface EmployeeMapper {

	EmployeeDTO selectemployee(HashMap<String, Object> map);

	List<EmployeeDTO> selectAllEmployee();

	int deleteEmployee(String eno);

	int insertEmployee(HashMap<String, Object> map);

	EmployeeDTO searchEmployee(HashMap<String, Object> map);

	EmployeeDTO selectemployee1(String eno);

}
