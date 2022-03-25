package Modulo4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EjemploServlet
 */
@WebServlet("/EjemploServlet")
public class EjemploServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EjemploServlet() {
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
        Connection conn;
        String vret = null;

                try {
                        // Inicializa Conexion
                        conn = DBConnection.initializeDatabase();

                        // Utiliza el select del Crud
                        switch(request.getParameter("operation")) {
                                case "selectDepartaments":
                                        vret = DTODepartments.select(conn,new Departments(request.getParameter("dept_no")));
                                        break;
                                case "selectEmployees":
                                        vret = DTOEmployees.select(conn,new Employees(request.getParameter("emp_no")));
                                        break;
                                case "selectTittle_types":
                                        vret = DTOTitle_types.select(conn,new Title_types(request.getParameter("title_no")));
                                        break;
                                case "insert":
                                        if(DTODepartments.insert(conn,new Departments(request.getParameter("dept_no"),request.getParameter("dept_name")))) {
                                                vret = "Exito";
                                        };
                                        break;
                                case "insertEmployees":
                                        if(DTOEmployees.insert(conn,new Employees(request.getParameter("emp_no"),request.getParameter("birth_date"),request.getParameter("first_name"),request.getParameter("last_name"),request.getParameter("gender"),request.getParameter("hire_date")))) {
                                                vret = "Exito";
                                        };
                                        
                                        
                                case "insertTittle_types":
                                        if(DTOTitle_types.insert(conn,new Title_types(request.getParameter("title_no"),request.getParameter("title")))) {
                                                vret = "Exito";
                                        };
                                        break;
                                case "delete":
                                        if(DTODepartments.delete(conn, new Departments(request.getParameter("dept_no")))) {
                                                vret = "Exito";
                                        };
                                        break;
                                case "deleteEmployees":
                                        if(DTOEmployees.delete(conn, new Employees(request.getParameter("emp_no")))) {
                                                vret = "Exito";
                                        };
                                        break;
                                 case "deleteTittle_types":
                                        if(DTOTitle_types.delete(conn, new Title_types(request.getParameter("title_no")))) {
                                                vret = "Exito";
                                        };
                                        break;
                                case "update":
                                        if(DTODepartments.update(conn,new Departments(request.getParameter("dept_no"),request.getParameter("dept_name")))) {
                                                vret = "Exito";
                                        };
                                        break;
                              case "updateEmployees":
                                        if(DTOEmployees.update(conn,new Employees(request.getParameter("emp_no"),request.getParameter("birth_date"),request.getParameter("first_name"),request.getParameter("last_name"),request.getParameter("gender"),request.getParameter("hire_date")))) {
                                                vret = "Exito";
                                        }; 
                                        break;  
                                        
                              case "updateTittle_types":
                                        if(DTOTitle_types.update(conn,new Title_types(request.getParameter("title_no"),request.getParameter("title")))) {
                                                vret = "Exito";
                                        }; 
                                        break;  
                        };
                } catch (ClassNotFoundException | SQLException e) {
                        // TODO Auto-generated catch block
                        //e.printStackTrace();
                }

                response.getWriter().append(vret);
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}
