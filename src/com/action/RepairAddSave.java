package com.action;

import com.bean.RepairBean;
import com.bean.StudentBean;
import com.dao.RepairDao;
import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by mizeshuang on 2016/6/4.
 */
public class RepairAddSave extends ActionSupport {
    private int Repair_ID;
    private String Repair_Username;
    private String RePair_Password;
    private String Repair_Name;
    private String Repair_Tel;
    private String Repair_Sex;

    public int getRepair_ID() {
        return Repair_ID;
    }

    public void setRepair_ID(int repair_ID) {
        Repair_ID = repair_ID;
    }

    public String getRepair_Username() {
        return Repair_Username;
    }

    public void setRepair_Username(String repair_Username) {
        Repair_Username = repair_Username;
    }

    public String getRePair_Password() {
        return RePair_Password;
    }

    public void setRePair_Password(String rePair_Password) {
        RePair_Password = rePair_Password;
    }

    public String getRepair_Name() {
        return Repair_Name;
    }

    public void setRepair_Name(String repair_Name) {
        Repair_Name = repair_Name;
    }

    public String getRepair_Tel() {
        return Repair_Tel;
    }

    public void setRepair_Tel(String repair_Tel) {
        Repair_Tel = repair_Tel;
    }

    public String getRepair_Sex() {
        return Repair_Sex;
    }

    public void setRepair_Sex(String repair_Sex) {
        Repair_Sex = repair_Sex;
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

        List<RepairBean> list=new RepairDao().GetList("Repair_Username='"+Repair_Username+"'", "");
        if(list.size()>0)
        {
            out.print("<script language='javascript'>alert('用户名已经存在！');history.back(-1);</script>");
            out.flush();
            out.close();
            return null;
        }
        RepairBean cnbean = new RepairBean();
        cnbean.setRepair_Username(Repair_Username);
        cnbean.setRePair_Password(RePair_Password);
        cnbean.setRepair_Sex(Repair_Sex);
        cnbean.setRepair_Name(Repair_Name);
        cnbean.setRepair_Tel(Repair_Tel);
        new RepairDao().Add(cnbean);
        out.print("<script language='javascript'>alert('添加成功');window.location='RepairManager.action';</script>");
        out.flush();
        out.close();
        return null;
    }

    public static void main(String[] args) {
        RepairBean cnbean = new RepairBean();
        cnbean.setRepair_Username("123");
        cnbean.setRePair_Password("123");
        cnbean.setRepair_Sex("男");
        cnbean.setRepair_Name("123");
        cnbean.setRepair_Tel("123");
        new RepairDao().Add(cnbean);
    }
}
