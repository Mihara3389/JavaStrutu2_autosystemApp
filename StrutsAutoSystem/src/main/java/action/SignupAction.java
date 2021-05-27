package action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import bean.UserBean;
import dao.SignupDao;
import dao.UsersDao;

public class SignupAction extends ActionSupport {
	private String name;
	private String password;

	public String execute() {
            if(name.isEmpty()|password.isEmpty()){
            	addActionError(getText("error.invalid"));
    			return "error";
            }else if(63 < name.length() | 255 < password.length()){
            	addActionError(getText("error.length"));
    			return "error";
            }else {
            	try {
            		//登録済ユーザか確認
            		UsersDao usersDao = new UsersDao();
            		UserBean user =usersDao.getUser(name);
            		if(user==null) {
            			//ユーザ登録
            			SignupDao signupDao = new SignupDao();
            			signupDao.updateUser(name,password);
            			return "success";
            		}else {
            			addActionError(getText("error.register"));
            			return "error";
            		}
            	}catch(SQLException e) {
            		addActionError(getText("error.sql"));
        			return "error";
            	}
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