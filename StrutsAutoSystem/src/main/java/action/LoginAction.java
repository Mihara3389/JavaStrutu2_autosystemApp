package action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import bean.UserBean;
import dao.UsersDao;

public class LoginAction extends ActionSupport {
	private String name;
	private String password;
	private String errorMessage;

	public String execute() {
		try {
            UsersDao usersDao = new UsersDao();
            UserBean user =usersDao.getUser(name);
            if(user==null) {
                return showMessage("ユーザ名は存在しないので、管理者へ連絡してください！");
            }else if(!password.equals(user.getPassword())) {
                return showMessage("パスワードは不正です！");
            }else {
                return "success";
            }
        }catch(SQLException e) {
            return showExceptionMessage("DBの例外が発生しました、管理者へ連絡してください！");
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
	public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
	public String showMessage(String errorMessage) {
        this.errorMessage=errorMessage;
        return "error";
    }
    public String showExceptionMessage(String errorMessage) {
        this.errorMessage=errorMessage;
        return "error";
    }
}