package com.employee.dto;

import org.apache.ibatis.type.Alias;

@Alias("employee")
public class EmployeeDTO {
	private String eno;
	private String eName;
	private String eDepart;
	private String positionName;
	private int positionNo;
	private int salary;
	
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(String eno, String eName, String eDepart, String positionName, int positionNo, int salary) {
		super();
		this.eno = eno;
		this.eName = eName;
		this.eDepart = eDepart;
		this.positionName = positionName;
		this.positionNo = positionNo;
		this.salary = salary;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteDepart() {
		return eDepart;
	}

	public void seteDepart(String eDepart) {
		this.eDepart = eDepart;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getPositionNo() {
		return positionNo;
	}

	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [eno=" + eno + ", eName=" + eName + ", eDepart=" + eDepart + ", positionName="
				+ positionName + ", positionNo=" + positionNo + ", salary=" + salary + "]";
	}



}
