<%--
  Created by IntelliJ IDEA.
  User: mizeshuang
  Date: 2016/6/3
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>校园宿舍管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<center>
    <table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">校园宿舍管理系统</td>
        </tr>
        <tr>
            <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
        </tr>
        <tr>
            <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
                        <%@ include file="Left.jsp"%>
                    </td>
                    <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">维修员管理</td>
                        </tr>
                        <tr>
                            <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="RepairManager.action">
                                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <a href="RepairAdd.jsp">添加维修员</a></td>
                                        <td width="72%">查询：
                                            <select name="SearchRow" id="SearchRow">
                                                <option value="Repair_Name">姓名</option>
                                                <option value="Repair_Username">用户名</option>
                                            </select>
                                            <input name="SearchKey" type="text" class="text1" id="SearchKey">
                                            <input type="submit" name="button" id="button" value="点击查询"></td>
                                    </tr>
                                </table>
                            </form>
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr align="center"  class="t1">
                                        <td height="25" bgcolor="#D5E4F4"><strong>用户名</strong></td>
                                        <td bgcolor="#D5E4F4"><strong>姓名</strong></td>
                                        <td bgcolor="#D5E4F4"><strong>性别</strong></td>
                                        <td bgcolor="#D5E4F4"><strong>联系方式</strong></td>
                                        <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                                    </tr>
                                    <s:iterator id="aa" value="repairBeanList">
                                        <tr align="center">
                                            <td height="25" align="center">${Repair_Username}</td>
                                            <td>${Repair_Name}</td>
                                            <td>${Repair_Sex}</td>
                                            <td>${Repair_Tel}</td>
                                            <td align="center"><a href="RepairUpdate.action?Repair_ID=${Repair_ID}">修改</a> <a href="RepairDel.action?Repair_ID=${Repair_ID}" onClick="return confirm('确定要删除该维修员吗？')">删除</a></td>
                                        </tr>
                                    </s:iterator>
                                </table></td>
                        </tr>
                    </table></td>
                </tr>
            </table></td>
        </tr>
        <tr>
            <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
        </tr>
    </table>

</center>
</body>
</html>

