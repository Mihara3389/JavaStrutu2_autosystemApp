package action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import bean.ListBean;
import dao.ListDao;

public class ListAction extends ActionSupport{
	private List<ListBean> list;
	public String execute() {
            	try {
            		//listデータを抜き出す
            		ListDao listDao = new ListDao();
            		list =listDao.getList();
            		if(list.isEmpty()) {
            			addActionError(getText("error.list"));
            			return "register";
            		}else {
            			return "success";
            		}
            	}catch(SQLException e) {
            		addActionError(getText("error.sql"));
        			return "error";
            	}
	}

    public List<ListBean> getList() {
		return list;
	}

	public void setList(List<ListBean> list) {
		this.list = list;
	}

}