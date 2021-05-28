package action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.mindrot.jbcrypt.BCrypt;

import com.opensymphony.xwork2.ActionSupport;

import bean.UserBean;
import dao.SignupDao;
import dao.UsersDao;

public class SignupAction extends ActionSupport implements SessionAware{
	
	private String name;
	private String password;
	private Map<String, Object> session;

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
            			//入力パスワードのハッシュ化
            			String hashedCode = BCrypt.hashpw(password, BCrypt.gensalt());
            			//ユーザ登録
            			SignupDao signupDao = new SignupDao();
            			signupDao.updateUser(name,hashedCode);
            			//セッションにユーザの名前格納
            			session.put("name",name);
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
	public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}