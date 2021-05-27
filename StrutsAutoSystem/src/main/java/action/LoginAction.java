package action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import bean.UserBean;
import dao.UsersDao;

public class LoginAction extends ActionSupport {
	private String name;
	private String password;

	public String execute() {
		try {
            UsersDao usersDao = new UsersDao();
            UserBean user =usersDao.getUser(name);
            if(user==null) {
            	addActionError(getText("error.user"));
    			return "error";
            }else if(!password.equals(user.getPassword())) {
            	addActionError(getText("error.pass"));
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
    }
}