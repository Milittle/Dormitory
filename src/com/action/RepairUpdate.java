package com.action;

import com.bean.RepairBean;
import com.dao.RepairDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by mizeshuang on 2016/6/3.
 */
public class RepairUpdate extends ActionSupport {
    private String Repair_ID;
    private RepairBean cnbean = new RepairBean();

    public RepairBean getCnbean() {
        return cnbean;
    }

    public void setCnbean(RepairBean cnbean) {
        this.cnbean = cnbean;
    }

    public String getRepair_ID() {
        return Repair_ID;
    }

    public void setRepair_ID(String repair_ID) {
        Repair_ID = repair_ID;
    }

    @Override
    public String execute() throws Exception {
        HttpServletResponse response = null;
        response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = ServletActionContext.getRequest().getSession();
        cnbean = new RepairDao().GetBean(Integer.parseInt(Repair_ID));
        return SUCCESS;
    }
}
