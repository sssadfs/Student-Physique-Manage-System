<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>学生体质信息管理系统</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, "Microsoft YaHei", sans-serif;
            background: #f3f6fb;
            color: #1f2937;
        }

        .page {
            max-width: 900px;
            margin: 72px auto;
            padding: 0 24px;
        }

        h1 {
            margin: 0 0 32px;
            text-align: center;
            font-size: 34px;
            font-weight: 700;
            letter-spacing: 0;
        }

        .actions {
            display: flex;
            flex-direction: column;
            gap: 18px;
            max-width: 360px;
            margin: 0 auto;
        }

        .action {
            display: block;
            padding: 22px 18px;
            border: 1px solid #d9e2ef;
            border-radius: 8px;
            background: #ffffff;
            color: #1f2937;
            text-align: center;
            text-decoration: none;
            font-size: 18px;
            font-weight: 600;
            box-shadow: 0 8px 24px rgba(15, 23, 42, 0.06);
            width: 100%;
            box-sizing: border-box;
        }

        .action:hover {
            border-color: #2563eb;
            color: #2563eb;
        }
    </style>
</head>
<body>
<main class="page">
    <h1>学生体质信息管理系统</h1>
    <section class="actions">
        <a class="action" href="${pageContext.request.contextPath}/addStudent.jsp">增加学生</a>
        <a class="action" href="${pageContext.request.contextPath}/deleteStudent.jsp">删除学生</a>
        <a class="action" href="${pageContext.request.contextPath}/queryAllStudents.jsp">查询全部学生</a>
        <a class="action" href="${pageContext.request.contextPath}/queryStudentByName.jsp">按名字查询学生</a>
        <a class="action" href="${pageContext.request.contextPath}/updateStudent.jsp">更新学生信息</a>
    </section>
</main>
</body>
</html>
