package com.action;

import com.bean.DamageBean;
import com.dao.DamageDao;
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
public class DamageManager extends ActionSupport {
    private List<DamageBean> damageBeanList = new ArrayList<>();
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

    public List<DamageBean> getDamageBeanList() {
        return damageBeanList;
    }

    public void setDamageBeanList(List<DamageBean> damageBeanList) {
        this.damageBeanList = damageBeanList;
    }

    @Override
    public String execute() throws Exception {
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
            out.flush();
            out.close();
            return null;
        }
        //查询条件
        String strWhere="1=1";
        strWhere += " and Repair_ID in (0," + session.getAttribute("id")+")";
        if(!(isInvalid(SearchKey)))
        {
            strWhere+=" and "+SearchRow+" like '%"+SearchKey+"%'";
        }
        damageBeanList = new DamageDao().GetList(strWhere, "");
        return SUCCESS;
    }

    //判断是否空值
    private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
    }

}
