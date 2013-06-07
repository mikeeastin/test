<%@ page language="java" pageEncoding="utf8"
    contentType="text/html;charset=gbk" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
 String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 pageContext.setAttribute("basePath",basePath);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<HEAD>
<TITLE>登陆页面</TITLE>
<base href=" <%=basePath%>">
<link rel="stylesheet" href="resources/css/Default.css" />
<link rel="stylesheet" href="resources/css/xtree.css" />
<link rel="stylesheet" href="resources/css/User_Login.css" />
</HEAD>
<BODY id="userlogin_body">
<DIV></DIV>
<form action="<%=path %>/j_spring_security_check" method="post">
<DIV id="user_login">
<DL>
    <DD id="user_top">
    <UL>
        <LI class="user_top_l"></LI>
        <LI class="user_top_c"><!-- -->
        <p
            style="font-size: 30px; text-shadow: -1px -1px 3px #ffb69a, 1px 1px 3px #1C27C2, -1px -1px #1C27C2, 1px 1px #1C27C2; color: #1C27C2;">

        <p />

        dddssss</LI>
        <LI class="user_top_r"></LI>
    </UL>
    <DD id="user_main">
    <UL>
        <LI class="user_main_l"></LI>
        <LI class="user_main_c">
        <DIV class="user_main_box">
        <UL>
            <LI class="user_main_text">用户名：</LI>
            <LI class="user_main_input"><INPUT class="TxtUserNameCssClass"
                id="TxtUserName" maxLength="20" name="j_username"></LI>
        </UL>
        <UL>
            <LI class="user_main_text">密码：</LI>
            <LI class="user_main_input"><INPUT class="TxtPasswordCssClass"
                id="TxtPassword" type="password" name="j_password"></LI>
        </UL>
        <UL>
            <LI class="user_main_text">保存密码:</LI>
            <LI class="user_main_input"><SELECT id=DropExpiration
                name="DropExpiration">
                <OPTION value="None selected">不保存</OPTION>
                <OPTION value="Day">保存一天</OPTION>
                <OPTION value="Month">保存一个月</OPTION>
                <OPTION value="Year">保存一年</OPTION>
            </SELECT>
            </LI>
        </UL>
        mike:<c:out value="${error}"></c:out>
        <br><br>



        </DIV>

        </LI>
        <LI class="user_main_r"><INPUT class="IbtnEnterCssClass"
            id=IbtnEnter
            style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"
            type='submit' name="IbtnEnter"></LI>

    </UL>
    <DD id="user_bottom">
    <UL>
        <LI class="user_bottom_l"></LI>
        <LI class="user_bottom_c"><SPAN style="MARGIN-TOP: 40px">如果你还没注册，请点击这里
        <A href="http://www.baidu.com">注册</A></SPAN></LI>
        <LI class="user_bottom_r"></LI>
    </UL>
    </DD>
</DL>
</DIV>
<SPAN id="ValrUserName" style="DISPLAY: none; COLOR: red"></SPAN> <SPAN
    id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN> <SPAN
    id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
<DIV id="ValidationSummary1" style="DISPLAY: none; COLOR: red"></DIV>

<DIV></DIV>

</FORM>
</BODY>
</HTML>
