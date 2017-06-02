package com.action;

import com.bean.RepairBean;
import com.dao.RepairDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by mizeshuang on 2016/6/4.
 */
public class RepairUpdateSave extends ActionSupport {
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
        HttpServletResponse response = null;
        response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = ServletActionContext.getRequest().getSession();
        RepairBean cnbean = new RepairBean();
        //验证是否正常登录
        if(session.getAttribute("id")==null){
            out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
            out.flush();
            out.close();
            return null;
        }
        cnbean = new RepairDao().GetBean(Repair_ID);
        List<RepairBean> list=new RepairDao().GetList("Repair_Username='"+Repair_Username+"' and Repair_ID<>'"+Repair_ID+"'", "");
        if(list.size()>0)
        {
            out.print("<script language='javascript'>alert('用户名已经存在！');history.back(-1);</script>");
            out.flush();
            out.close();
            return null;
        }
        cnbean.setRepair_ID(Repair_ID);
        cnbean.setRepair_Username(Repair_Username);
        cnbean.setRepair_Sex(Repair_Sex);
        cnbean.setRepair_Name(Repair_Name);
        cnbean.setRepair_Tel(Repair_Tel);
        if (!isInvalid(RePair_Password)) {
            cnbean.setRePair_Password(RePair_Password);
        }
        new RepairDao().Update(cnbean);
        //跳转
        out.print("<script language='javascript'>alert('修改成功！');window.location='RepairManager.action';</script>");
        out.flush();
        out.close();
        return null;
    }

    //判断是否空值
    private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
    }

    public static void main(String[] args) {

    }
}
