package action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import bean.UserBean;
import dao.SignupDao;
import dao.UsersDao;

public class SignupAction extends ActionSupport {
	private String name;
	private String password;
	private String errorMessage;

	public String execute() {
            if(name.isEmpty()|password.isEmpty()){
                return showMessage("ユーザ名またはパスワードが未入力です！");
            }else if(63 < name.length() | 255 < password.length()){
                return showMessage("ユーザ名は63文字以内、パスワードは255文字以内に設定してください！");
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
            			return showMessage("ユーザーは登録済です！");
            		}
            	}catch(SQLException e) {
            		return showExceptionMessage("DBの例外が発生しました、管理者へ連絡してください！");
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