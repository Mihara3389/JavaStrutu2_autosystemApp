package action;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import bean.QuestionBean;
import dao.QuestionDao;

public class TestAction extends ActionSupport{
	private List<QuestionBean> questionlist;
	public String execute() {
            	try {
            		//ログインユーザからquestionlistデータを抜き出す
            		QuestionDao questionDao = new QuestionDao();
            		questionlist =questionDao.getQuestion();
            		if(questionlist.isEmpty()) {
            			addActionError(getText("error.history"));
            			return "error";
            		}else {
            			//問題をshuffle
            			Collections.shuffle(questionlist);
            			return "success";
            		}
            	}catch(SQLException e) {
            		addActionError(getText("error.sql"));
        			return "error";
            	}
	}
	public List<QuestionBean> getQuestionlist() {
		return questionlist;
	}

	public void setQuestionlist(List<QuestionBean> questionlist) {
		this.questionlist = questionlist;
	}
}