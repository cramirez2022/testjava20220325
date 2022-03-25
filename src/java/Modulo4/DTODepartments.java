package Modulo4;

import java.sql.*;


public class DTODepartments {
	
	public static boolean insert(Connection conn, Departments departments) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("INSERT INTO departments VALUES (?,?)" );
                        pst.setString(1, departments.getDept_no());
			pst.setString(2, departments.getDept_name());
			pst.execute();
			vret = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}	
	
	public static String select(Connection conn, Departments departments) {
		PreparedStatement pst;
		String vret = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM departments WHERE dept_no=?" );
                        pst.setString(1, departments.getDept_no());
			ResultSet rs = pst.executeQuery();
			rs.next();
			vret = rs.getString("dept_no") + ";" + rs.getString("dept_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}
        
        public static boolean delete(Connection conn, Departments departments) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("delete FROM departments WHERE dept_no=?" );
                        pst.setString(1, departments.getDept_no());
			pst.execute();
			vret = true; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}	
        
         public static boolean update(Connection conn, Departments departments) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("UPDATE departments SET dept_name=? WHERE dept_no=?" );
			pst.setString(1, departments.getDept_name());
			pst.setString(2, departments.getDept_no());
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
