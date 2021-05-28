package action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.mindrot.jbcrypt.BCrypt;

import com.opensymphony.xwork2.ActionSupport;

import bean.UserBean;
import dao.UsersDao;

public class LoginAction extends ActionSupport implements SessionAware{
	
	private String name;
	private String password;
	private Map<String, Object> session;

	public String execute() {
		try {
            UsersDao usersDao = new UsersDao();
            UserBean user =usersDao.getUser(name);
            if(user==null) {
            	addActionError(getText("error.user"));
    			return "error";
            }else{
            	if(BCrypt.checkpw(password, user.getPassword())) {
            		//セッションにユーザの名前格納
        			session.put("name",name);
            		return "success";
            	}else {
            		addActionError(getText("error.pass"));
            		return "error";
            	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
    }
	public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}