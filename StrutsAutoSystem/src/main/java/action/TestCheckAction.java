package action;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import bean.AnswerBean;
import bean.ResultBean;
import dao.AnswerDao;
import dao.TestDao;

public class TestCheckAction extends ActionSupport implements SessionAware{
	private List<String> question_id;
    private List<String> answer;
	private List<AnswerBean> answerlist;
    private List<ResultBean> resultlist = new ArrayList<ResultBean>();
	private String name;
	private Map<String, Object> session;
	public String execute() {
            	try {
            		//カウンターの宣言と初期化
            		double total_question = 0;
            		double correct_answer = 0;
            		//DBの答えを取得
            		AnswerDao answerDao = new AnswerDao();
            		answerlist =answerDao.getAnswer();
            		//問題数のカウント
            		total_question = question_id.size();
            		//答え分ループ
            		for(int i = 0; i < answer.size(); i++){
            			//int型を変換させる
            			int formId = Integer.parseInt(question_id.get(i));
            			String formAnswer = answer.get(i);
            			//nullチェック
            			if (formAnswer == null) { 
            				continue; 
            			}
            			//答え分ループ
            			for(int j = 0; j < answerlist.size(); j++){
            				//問題のidと答えの問題idが一致したら
            				int answerId = answerlist.get(j).getQuestion_id();
            				String answerAnswer = answerlist.get(j).getAnswer();
            				//nullチェック
            				if (answerlist == null) { 
            					continue; 
            				}
            				if(formId == answerId){
            					//答えの内容が一致したら
            					if(formAnswer.equals(answerAnswer)) {
            						correct_answer = correct_answer + 1;
            						break;
            					}
            				}
            			}
            		}
            		//採点を結果（小数点以下四捨五入）
            		ResultBean bean = new ResultBean();
            		long result = Math.round(((correct_answer/total_question)*100));
            		bean.setTotal_question((int) total_question);
            		bean.setCorrect_answer((int) correct_answer);
            		bean.setResult((int) result);
            		//現在時刻取得
            		Timestamp created_at = new Timestamp(System.currentTimeMillis());
            		bean.setCreated_at(created_at);
            		//セッションからログイン中ユーザー情報を取得
            		String name = (String) session.get("name");
            		//採点結果登録処理へ
            		TestDao testDao = new TestDao();
            		testDao.updateHistory(name,(int) result,created_at);
            		//Jspへ
            		resultlist.add(bean);
           			return "success";
            	}catch(SQLException e) {
            		addActionError(getText("error.sql"));
        			return "error";
            	}
	}
	public List<String> getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(List<String> question_id) {
		this.question_id = question_id;
	}
	public List<String> getAnswer() {
		return answer;
	}
	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}
	public List<ResultBean> getResultlist() {
		return resultlist;
	}
	public void setResultlist(List<ResultBean> resultlist) {
		this.resultlist = resultlist;
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