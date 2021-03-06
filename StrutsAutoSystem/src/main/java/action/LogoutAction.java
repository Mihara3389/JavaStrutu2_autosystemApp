package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute() {
		//セッションにユーザの名前削除
		session.remove("name");
		return "success";
	}
	public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}