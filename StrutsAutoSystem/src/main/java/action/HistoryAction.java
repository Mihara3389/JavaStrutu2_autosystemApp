package action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import bean.HistoryBean;
import dao.HistoriesDao;

public class HistoryAction extends ActionSupport implements SessionAware{
	
	private String name;
	private Map<String, Object> session;
	public String execute() {
            	try {
            		//セッションからログイン中ユーザー情報を取得
            		String name = (String) session.get("name");
            		//ログインユーザからhistoriesデータを抜き出す
            		HistoriesDao historiesDao = new HistoriesDao();
            		List<HistoryBean> histories =historiesDao.getHistory(name);
            		if(histories.isEmpty()) {
            			addActionError(getText("error.history"));
            			return "error";
            		}else {
            			return "success";
            		}
            	}catch(SQLException e) {
            		addActionError(getText("error.sql"));
        			return "error";
            	}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}