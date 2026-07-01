package Servlets;

import dao.StudentDAO;
import domain.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class QueryStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            StudentDAO studentDAO = new StudentDAO();
            String id = request.getParameter("id");
            String name = request.getParameter("name");

            if (id != null && id.trim().length() > 0) {
                Student query = new Student();
                query.setId(id.trim());
                Student student = studentDAO.find(query);
                request.setAttribute("queryTitle", "按学号查询结果");
                request.setAttribute("students", student == null ? Collections.emptyList() : Collections.singletonList(student));
                request.getRequestDispatcher("/queryResult.jsp").forward(request, response);
            } else if (name != null && name.trim().length() > 0) {
                Student student = studentDAO.findByName(name.trim());
                request.setAttribute("queryTitle", "按名字查询结果");
                request.setAttribute("students", student == null ? Collections.emptyList() : Collections.singletonList(student));
                request.getRequestDispatcher("/queryResult.jsp").forward(request, response);
            } else {
                List<Student> students = studentDAO.findAll();
                request.setAttribute("queryTitle", "全部学生信息");
                request.setAttribute("students", students);
                request.getRequestDispatcher("/queryResult.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("queryTitle", "查询结果");
            request.setAttribute("students", Collections.<Student>emptyList());
            request.setAttribute("message", "查询学生失败：" + e.getMessage());
            request.getRequestDispatcher("/queryResult.jsp").forward(request, response);
        }
    }
}
