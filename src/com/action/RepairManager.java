package com.action;

import com.bean.RepairBean;
import com.dao.RepairDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mizeshuang on 2016/6/3.
 */
public class RepairManager extends ActionSupport {
    private List<RepairBean> repairBeanList = new ArrayList<>();

    private String SearchRow;
    private String SearchKey;

    public String getSearchRow() {
        return SearchRow;
    }

    public void setSearchRow(String searchRow) {
        SearchRow = searchRow;
    }

    public String getSearchKey() {
        return SearchKey;
    }

    public void setSearchKey(String searchKey) {
        SearchKey = searchKey;
    }

    public List<RepairBean> getRepairBeanList() {
        return repairBeanList;
    }

    public void setRepairBeanList(List<RepairBean> repairBeanList) {
        this.repairBeanList = repairBeanList;
    }

    @Override
    public String execute() throws Exception {
        HttpServletResponse response = null;
        response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = ServletActionContext.getRequest().getSession();
        if(session.getAttribute("id")==null){
            out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
            out.flush();
            out.close();
            return null;
        }

        //查询条件
        String strWhere="1=1";
        if(!(isInvalid(SearchKey)))
        {
            strWhere+=" and "+SearchRow+" like '%"+SearchKey+"%'";
        }

        repairBeanList = new RepairDao().GetList(strWhere,"Repair_Username");

        return SUCCESS;
    }

    private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
    }

    public static void main(String[] args) {
        System.out.println(new RepairDao().GetList("1=1","Repair_Username"));
    }
}
