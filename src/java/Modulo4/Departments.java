/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modulo4;

public class Departments {
	private String dept_no;
	private String dept_name;
	
	public Departments(String dept_no, String dept_name) {
		this.dept_no = dept_no;
		this.dept_name = dept_name;
	}
        
        	public Departments(String dept_no) {
		this.dept_no = dept_no;
	}
	
	public String getDept_no() {
		return dept_no;
	}
	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

}
