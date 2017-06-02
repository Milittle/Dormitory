package com.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class DomitoryDel extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Domitory_ID ;

	private List<StudentBean> studentBeanList = new ArrayList<>();

	public List<StudentBean> getStudentBeanList() {
		return studentBeanList;
	}

	public void setStudentBeanList(List<StudentBean> studentBeanList) {
		this.studentBeanList = studentBeanList;
	}

	public String getDomitory_ID() {
		return Domitory_ID;
	}

	public void setDomitory_ID(String userID) {
		Domitory_ID = userID;
	}

	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}

		studentBeanList = new StudentDao().GetAllList("Student_DomitoryID=" + Domitory_ID, "");
		if (studentBeanList.size() > 0) {
			out.print("<script language='javascript'>alert('不能删除这个宿舍，因为宿舍有住人！');window.location='DomitoryManager.action';</script>");
			out.flush();
			out.close();
			return null;
		}
		else{
			//删除
			new DomitoryDao().Delete("Domitory_ID="+Domitory_ID);
		}
		return SUCCESS;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}
