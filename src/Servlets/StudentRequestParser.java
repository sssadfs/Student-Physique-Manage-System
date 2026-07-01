package Servlets;

import domain.Student;

import jakarta.servlet.http.HttpServletRequest;

public class StudentRequestParser {
    public static Student parseStudent(HttpServletRequest request) throws Exception {
        Student student = new Student();
        student.setId(requiredParam(request, "id"));
        student.setName(requiredParam(request, "name"));
        student.setGender(optionalParam(request, "gender", optionalParam(request, "sex", "")));
        student.setAge(parseInt(requiredParam(request, "age"), "age"));
        student.setWeight(parseDouble(requiredParam(request, "weight"), "weight"));
        student.setHeight(parseDouble(requiredParam(request, "height"), "height"));
        return student;
    }

    public static String requiredParam(HttpServletRequest request, String name) throws Exception {
        String value = request.getParameter(name);
        if (value == null || value.trim().length() == 0) {
            throw new Exception("缺少参数 " + name);
        }
        return value.trim();
    }

    private static String optionalParam(HttpServletRequest request, String name, String defaultValue) {
        String value = request.getParameter(name);
        if (value == null || value.trim().length() == 0) {
            return defaultValue;
        }
        return value.trim();
    }

    private static int parseInt(String value, String name) throws Exception {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new Exception("参数 " + name + " 必须是整数");
        }
    }

    private static double parseDouble(String value, String name) throws Exception {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new Exception("参数 " + name + " 必须是数字");
        }
    }
}
