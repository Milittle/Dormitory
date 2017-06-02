<%--
  Created by IntelliJ IDEA.
  User: mizeshuang
  Date: 2016/6/3
  Time: 20:29
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
    <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</head>
<script language="JavaScript">


    function mycheck(){
        if(isNull(form1.Damage_Description.value)){
            alert("请输入损坏详细情况！");
            return false;
        }
    }

    function isNull(str){
        if ( str == "" ) return true;
        var regu = "^[ ]+$";
        var re = new RegExp(regu);
        return re.test(str);
    }


</script>
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
                            <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">楼宇物品损坏登记</td>
                        </tr>
                        <tr>
                            <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
                                <form name="form1" method="post" action="DamageAddSave.action" onSubmit="return mycheck()" >
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td height="30" colspan="2" align="center" style="color:red;">请仔细确认信息是否正确</td>
                                        </tr>
                                        <tr>
                                            <td width="33%" height="30" align="right">建筑选择：</td>
                                            <td>
                                                <select name="Building_ID" id="Building_ID">
                                                    <option value="">请选择</option>
                                                    <s:iterator  id="aa" value="list">
                                                        <option value="${Building_ID}">${Building_Name}</option>
                                                    </s:iterator>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td height="30" align="right">损坏情况描述：</td>
                                            <td><textarea name="Damage_Description" id="Damage_Description" cols="45" rows="5"></textarea></td>
                                        </tr>
                                        <tr>
                                            <td height="30">&nbsp;</td>
                                            <td><input type="submit" name="button" id="button" value="确认提交">
                                                &nbsp;&nbsp;
                                                <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                                        </tr>
                                    </table>
                                </form></td>
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
