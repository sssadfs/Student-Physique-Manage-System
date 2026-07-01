package Servlets;

import dao.StudentDAO;
import domain.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            Student student = StudentRequestParser.parseStudent(request);
            StudentDAO studentDAO = new StudentDAO();
            studentDAO.update(student);
            RequestForwarder.forwardMessage(request, response, true, "修改学生成功", request.getContextPath() + "/updateStudent.jsp");
        } catch (Exception e) {
            RequestForwarder.forwardMessage(request, response, false, "修改学生失败：" + e.getMessage(), request.getContextPath() + "/updateStudent.jsp");
        }
    }
}
