package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class TopAction extends ActionSupport implements SessionAware{
	
	private Map<String, Object> session;
	
	public String execute() {
		if(((String)session.get("name")).isEmpty()){
			addActionError(getText("error.session"));
			return "error";
		}else {
			return "success";
		}
	}
	public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}