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
                            <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="DamageManager.action">
                                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="72%">查询：
                                            <select name="SearchRow" id="SearchRow">
                                                <option value="Damage_Description">损坏描述</option>
                                                <option value="Damage_State">状态</option>
                                            </select>
                                            <input name="SearchKey" type="text" class="text1" id="SearchKey">
                                            <input type="submit" name="button" id="button" value="点击查询"></td>
                                    </tr>
                                </table>
                            </form>
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr align="center"  class="t1">
                                        <td height="25" bgcolor="#D5E4F4"><strong>楼宇</strong></td>
                                        <td bgcolor="#D5E4F4"><strong>损坏描述</strong></td>
                                        <td bgcolor="#D5E4F4"><strong>状态</strong></td>
                                        <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                                    </tr>
                                    <s:iterator id="aa" value="damageBeanList">
                                        <tr align="center">
                                            <td height="25" align="center">${Building_Name}</td>
                                            <td>${Damage_Description}</td>
                                            <td>${Damage_State}</td>
                                            <td align="center">
                                            <s:if test="Damage_State!='正在维修'">
                                                <a href="DamageSubmit.action?Damage_ID=${Damage_ID}&&Repair_ID=<%=session.getAttribute("id")%>" onClick="return confirm('确定提交么，提交证明你要开始维修工作！')">提交</a>
                                            </s:if>
                                            <s:if test="Damage_State=='正在维修'">
                                            <a href="DamageDel.action?Damage_ID=${Damage_ID}" onClick="return confirm('确定提交么，提交证明你已经完成了维修工作！')">完成</a>
                                            </s:if>
                                            </td>
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

