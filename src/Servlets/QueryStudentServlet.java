package Servlets;

import dao.StudentDAO;
import domain.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseWriter.prepareJson(response);

        try {
            StudentDAO studentDAO = new StudentDAO();
            String id = request.getParameter("id");
            String name = request.getParameter("name");

            if (id != null && id.trim().length() > 0) {
                Student query = new Student();
                query.setId(id.trim());
                ResponseWriter.writeStudent(response, studentDAO.find(query));
            } else if (name != null && name.trim().length() > 0) {
                ResponseWriter.writeStudent(response, studentDAO.findByName(name.trim()));
            } else {
                List<Student> students = studentDAO.findAll();
                ResponseWriter.writeStudents(response, students);
            }
        } catch (Exception e) {
            ResponseWriter.writeError(response, "查询学生失败：" + e.getMessage());
        }
    }
}
