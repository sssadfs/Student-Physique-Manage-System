<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>操作结果</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, "Microsoft YaHei", sans-serif;
            background: #f3f6fb;
            color: #1f2937;
        }

        .page {
            max-width: 640px;
            margin: 72px auto;
            padding: 0 24px;
        }

        .panel {
            background: #fff;
            border: 1px solid #d9e2ef;
            border-radius: 8px;
            padding: 32px 28px;
            box-shadow: 0 8px 24px rgba(15, 23, 42, 0.06);
            text-align: center;
        }

        h1 {
            margin: 0 0 18px;
            font-size: 30px;
            letter-spacing: 0;
        }

        .message {
            margin: 0 0 28px;
            font-size: 18px;
            line-height: 1.8;
        }

        .success {
            color: #166534;
        }

        .error {
            color: #b91c1c;
        }

        a {
            display: inline-block;
            padding: 12px 22px;
            border-radius: 6px;
            background: #2563eb;
            color: #fff;
            text-decoration: none;
            font-weight: 700;
        }

        a:hover {
            background: #1d4ed8;
        }
    </style>
</head>
<body>
<main class="page">
    <div class="panel">
        <h1>操作结果</h1>
        <p class="message ${success ? 'success' : 'error'}">
            ${empty message ? '未获取到操作结果' : message}
        </p>
        <a href="<%= request.getAttribute("returnUrl") == null ? request.getContextPath() + "/index.jsp" : request.getAttribute("returnUrl") %>">返回</a>
    </div>
</main>
</body>
</html>
