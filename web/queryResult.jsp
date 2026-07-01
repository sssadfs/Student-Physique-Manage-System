<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Student" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>查询结果</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, "Microsoft YaHei", sans-serif;
            background: #f3f6fb;
            color: #1f2937;
        }

        .page {
            max-width: 1020px;
            margin: 48px auto;
            padding: 0 24px;
        }

        .top {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
            gap: 16px;
        }

        h1 {
            margin: 0;
            font-size: 28px;
            letter-spacing: 0;
        }

        a {
            color: #2563eb;
            text-decoration: none;
        }

        .panel {
            background: #fff;
            border: 1px solid #d9e2ef;
            border-radius: 8px;
            padding: 24px;
            box-shadow: 0 8px 24px rgba(15, 23, 42, 0.06);
        }

        .message {
            margin: 0 0 18px;
            color: #b91c1c;
            font-weight: 600;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #d9e2ef;
            padding: 12px 10px;
            text-align: center;
            font-size: 15px;
        }

        th {
            background: #eff6ff;
            font-weight: 700;
        }

        .empty {
            padding: 24px 0;
            text-align: center;
            color: #6b7280;
        }
    </style>
</head>
<body>
<main class="page">
    <div class="top">
        <h1>${empty queryTitle ? '查询结果' : queryTitle}</h1>
        <a href="${pageContext.request.contextPath}/index.jsp">返回主页</a>
    </div>
    <div class="panel">
        <p class="message">${empty message ? '' : message}</p>
        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            if (students == null || students.isEmpty()) {
        %>
        <div class="empty">没有查询到数据</div>
        <%
            } else {
        %>
        <table>
            <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>体重</th>
                <th>身高</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Student student : students) {
            %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getGender() %></td>
                <td><%= student.getAge() %></td>
                <td><%= student.getWeight() %></td>
                <td><%= student.getHeight() %></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <%
            }
        %>
    </div>
</main>
</body>
</html>
