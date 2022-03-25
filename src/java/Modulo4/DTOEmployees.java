package Modulo4;

import java.sql.*;


public class DTOEmployees {
	
	public static boolean insert(Connection conn, Employees employees) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("INSERT INTO employees VALUES (?,?,?,?,?,?)" );
                        pst.setString(1, employees.getEmp_no());
                        pst.setString(2, employees.getBirth_date());
			pst.setString(3, employees.getFirst_name());
                        pst.setString(4, employees.getLast_name());
                        pst.setString(5, employees.getGender());
                        pst.setString(6, employees.getHire_date());
			pst.execute();
			vret = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}	
	
	public static String select(Connection conn, Employees employees) {
		PreparedStatement pst;
		String vret = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM employees WHERE emp_no=?" );
                        pst.setString(1, employees.getEmp_no());
			ResultSet rs = pst.executeQuery();
			rs.next();
			vret = rs.getString("emp_no") + ";" + rs.getString("hire_date") + ";" + rs.getString("first_name") + ";" + rs.getString("last_name") + ";" + rs.getString("gender") + ";" + rs.getString("birth_date");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}
        
        public static boolean delete(Connection conn, Employees employees) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("delete FROM employees WHERE emp_no=?" );
                        pst.setString(1, employees.getEmp_no());
			pst.execute();
			vret = true; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}	
        
         public static boolean update(Connection conn, Employees employees) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("UPDATE employees SET birth_date=?, first_name=?, last_name=?, gender=?, hire_date=? WHERE emp_no=?" );
                        pst.setString(1, employees.getBirth_date());
			pst.setString(2, employees.getFirst_name());
                        pst.setString(3, employees.getLast_name());
                        pst.setString(4, employees.getGender());
                        pst.setString(5, employees.getHire_date());
                        pst.setString(6, employees.getEmp_no());
			if (pst.executeUpdate() > 0) {
				vret = true;
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}

}
