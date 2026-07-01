package Servlets;

import dao.StudentDAO;
import domain.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ResponseWriter.prepareJson(response);

        try {
            Student student = new Student();
            student.setId(StudentRequestParser.requiredParam(request, "id"));

            StudentDAO studentDAO = new StudentDAO();
            studentDAO.remove(student);
            ResponseWriter.writeSuccess(response, "删除学生成功");
        } catch (Exception e) {
            ResponseWriter.writeError(response, "删除学生失败：" + e.getMessage());
        }
    }
}
