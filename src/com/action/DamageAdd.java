package com.action;

import com.bean.BuildingBean;
import com.dao.BuildingDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mizeshuang on 2016/6/4.
 */
public class DamageAdd extends ActionSupport {
    private List<BuildingBean> list = new ArrayList<>();

    public List<BuildingBean> getList() {
        return list;
    }

    public void setList(List<BuildingBean> list) {
        this.list = list;
    }

    @Override
    public String execute() throws Exception {
        //解决乱码，用于页面输出
        HttpServletResponse response=null;
        response= ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //创建session对象
        HttpSession session = ServletActionContext.getRequest().getSession();
        //验证是否正常登录
        if(session.getAttribute("id")==null){
            out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
            out.flush();out.close();return null;
        }
        list=new BuildingDao().GetList("","");
        return SUCCESS;
    }

    public static void main(String[] args) {
        System.out.println(new BuildingDao().GetList("", ""));
    }
}
