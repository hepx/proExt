<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/extjs/resources/css/ext-all_1.css">
    <style type="text/css">
            /*
            body {
                background-image: url("../images/desktop.jpg");
            }
            */
        #login-logo .x-plain-body {
            background: url("${pageContext.request.contextPath}/assets/images/logo.jpg") no-repeat scroll center;
        }

        .icon-redo {
            background-image: url("${pageContext.request.contextPath}/assets/images/icons/redo.png") ! important;
        }

        .icon-save {
            background-image: url("${pageContext.request.contextPath}/assets/images/icons/save.png") ! important;
        }

        .icon-user {
            background: url("${pageContext.request.contextPath}/assets/images/icons/user.png") no-repeat 2px 2px;
        }

        .icon-lock {
            background: url("${pageContext.request.contextPath}/assets/images/icons/lock.png") no-repeat 2px 2px;
        }

        .icon-barcode {
            background: url("${pageContext.request.contextPath}/assets/images/icons/barcode.png") no-repeat 2px 2px;
        }

        .icon-login {
            background-image: url("${pageContext.request.contextPath}/assets/images/icons/logout.png") ! important;
        }

        .icon-guestinfo {
            background-image: url("${pageContext.request.contextPath}/assets/images/icons/guestinfo.png") !important;
        }

        .icon-help {
            background-image: url("${pageContext.request.contextPath}/assets/images/icons/help.png") !important;
        }

        .icon-next {
            background-image: url("${pageContext.request.contextPath}/assets/images/icons/search.png") !important;
        }

        .icon-lock, .icon-user, .icon-barcode {
            padding-left: 20px;
            font-size: 12px;
        }

        .msg .x-box-mc {
            font-size: 14px;
            color: green;
        }

        #msg-div {
            position: absolute;
            left: 35%;
            top: 10px;
            width: 200px;
            z-index: 20000;
        }
    </style>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/extjs/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/extjs/ext-all_1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/extjs/src/locale/ext-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/util/commonUtils.js"></script>
    <!--
    <script type="text/javascript" src="../util/userRegistWin.js"></script>
     -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/main/login.js"></script>
    <title>proExt-登录</title>
</head>
<body>
<div id="login"></div>
</body>
</html>