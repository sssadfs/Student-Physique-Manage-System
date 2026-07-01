package Servlets;

import domain.Student;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ResponseWriter {
    public static void prepareJson(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
    }

    public static void writeSuccess(HttpServletResponse response, String message) throws IOException {
        response.getWriter().write("{\"success\":true,\"message\":\"" + escape(message) + "\"}");
    }

    public static void writeError(HttpServletResponse response, String message) throws IOException {
        response.getWriter().write("{\"success\":false,\"message\":\"" + escape(message) + "\"}");
    }

    public static void writeStudent(HttpServletResponse response, Student student) throws IOException {
        if (student == null) {
            response.getWriter().write("{\"success\":true,\"data\":null}");
            return;
        }
        response.getWriter().write("{\"success\":true,\"data\":" + toJson(student) + "}");
    }

    public static void writeStudents(HttpServletResponse response, List<Student> students) throws IOException {
        StringBuilder json = new StringBuilder();
        json.append("{\"success\":true,\"data\":[");
        for (int i = 0; i < students.size(); i++) {
            if (i > 0) {
                json.append(",");
            }
            json.append(toJson(students.get(i)));
        }
        json.append("]}");
        response.getWriter().write(json.toString());
    }

    private static String toJson(Student student) {
        return "{"
                + "\"id\":\"" + escape(student.getId()) + "\","
                + "\"name\":\"" + escape(student.getName()) + "\","
                + "\"gender\":\"" + escape(student.getGender()) + "\","
                + "\"age\":" + student.getAge() + ","
                + "\"weight\":" + student.getWeight() + ","
                + "\"height\":" + student.getHeight()
                + "}";
    }

    private static String escape(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("\\", "\\\\").replace("\"", "\\\"").replace("\r", "\\r").replace("\n", "\\n");
    }
}
