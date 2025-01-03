<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .del-btn {
            padding: 5px 10px;
            outline: none;
            border: none;
            background: red;
            border-radius: 10px;
            color: #fff;
            margin-left: 10px;
            margin-bottom: 10px;
            cursor: pointer;
        }
        .del-btn:hover {
            border: 1px solid orange;
            opacity: 0.8;
        }
    </style>
</head>
<body>
<h1>MVC 댄서 정보 목록</h1>
<ul id="dancer-list">
    <li>
        # 이름: <span class="dancer-name">xxx</span>,
        # 크루명: xxx,
        # 수준: xxx
        <button class="del-btn">삭제</button>
    </li>
</ul>

<a href="/mvc/v1/register">다시 등록하기</a>
</body>
</html>