/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import da.StudentDA;
import da.ProgrammeDA;
import domain.Student;
import domain.Programme;

/**
 *
 * @author Tang Chun Xuan
 */
public class SimpleAddStudent extends HttpServlet {

    
    StudentDA studControl;
    ProgrammeDA progControl;

    @Override
    public void init() throws ServletException {
        studControl = new StudentDA();
        progControl = new ProgrammeDA();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        //parameter passing
        String id = request.getParameter("id");
        String ic = request.getParameter("ic");
        String name = request.getParameter("name");
        char level = request.getParameter("level").charAt(0);
        String programmeCode = request.getParameter("programme");
        String year = request.getParameter("yearStudy");
        int yr = 0;
        
        out.print(id);
        out.print(ic);
        out.print(name);
        out.print(level);
        out.print(programmeCode);
        out.print(year);
        
        
            try {
            yr = Integer.parseInt(request.getParameter("yearStudy"));
//            Programme programme = progControl.getRecord(programmeCode);
            Student student = new Student(id, ic, name, level, programmeCode, yr);
            studControl.addRecord(student);
            //create html that give response
            out.println("Student <b>" + id + "</b> has been added into the database.<br>");
            
        } catch (Exception ex) {
            //do something
            out.println("error!");
            out.println(""+ex);

        } finally {
            //close PrintWriter 
            out.close();
        }
        
        
        
//        if("2".equals(choice)){
//             try {
//            yr = Integer.parseInt(request.getParameter("yearStudy"));
//            Programme programme = progControl.getRecord(programmeCode);
//            Student student = new Student(id, ic, name, level, programmeCode, yr);
//            studControl.addRecord(student);
//            //self do
//            studControl.getRecord(id);
//            //create html that give response
//            out.println(studControl.getRecord(id));
//            out.println("hi");
//            
//        } catch (Exception ex) {
//            //do something
//            out.println("error!");
//            out.println(""+ex);
//
//        } finally {
//            //close PrintWriter 
//            out.close();
//        }
//        }
        
       

    }

}
