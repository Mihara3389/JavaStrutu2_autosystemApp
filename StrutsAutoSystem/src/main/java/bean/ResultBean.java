package bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

//Serializableインターフェース
public class ResultBean implements Serializable {
    private static final long serialVersionUID = 1L;

    //privateメンバ変数で定義
    private int total_question;
    private int correct_answer;
    private int result;
    private Timestamp created_at;
    private List<ResultBean> resultlist;
    
	public int getTotal_question() {
		return total_question;
	}
	public void setTotal_question(int total_question) {
		this.total_question = total_question;
	}
	public int getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(int correct_answer) {
		this.correct_answer = correct_answer;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public List<ResultBean> getResultlist() {
		return resultlist;
	}
	public void setResultlist(List<ResultBean> resultlist) {
		this.resultlist = resultlist;
	}
}