<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>按名字查询学生</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, "Microsoft YaHei", sans-serif;
            background: #f3f6fb;
            color: #1f2937;
        }
        .page {
            max-width: 520px;
            margin: 48px auto;
            padding: 0 24px;
        }
        .top {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 22px;
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
        form {
            background: #fff;
            border: 1px solid #d9e2ef;
            border-radius: 8px;
            padding: 24px;
            box-shadow: 0 8px 24px rgba(15, 23, 42, 0.06);
        }
        label {
            display: block;
            margin-bottom: 14px;
            font-weight: 600;
        }
        input {
            width: 100%;
            box-sizing: border-box;
            margin-top: 8px;
            padding: 10px 12px;
            border: 1px solid #cbd5e1;
            border-radius: 6px;
            font-size: 16px;
        }
        button {
            width: 100%;
            margin-top: 8px;
            padding: 12px 16px;
            border: 0; border-radius: 6px;
            background: #2563eb;
            color: #fff;
            font-size: 17px;
            font-weight: 700; cursor: pointer;
        }
        button:hover {
            background: #1d4ed8;
        }
    </style>
</head>
<body>
<main class="page">
    <div class="top">
        <h1>按名字查询学生</h1>
        <a href="${pageContext.request.contextPath}/index.jsp">返回主页</a>
    </div>
    <form action="${pageContext.request.contextPath}/student/query" method="get">
        <label>姓名
            <input type="text" name="name" required>
        </label>
        <button type="submit">查询</button>
    </form>
</main>
</body>
</html>
