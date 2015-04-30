<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<s:param name="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改密码</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/extjs/resources/css/ext-all.css">
    <script type="text/javascript" src="${ctx}/assets/extjs/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="${ctx}/assets/extjs/ext-all.js"></script>
    <script type="text/javascript" src="${ctx}/static/util/commonUtils.js"></script>
    <script type="text/javascript" src="${ctx}/static/main/modifyInitPwd.js"></script>
</head>
<body>
<div id="div_pwd"></div>
</body>
</html>