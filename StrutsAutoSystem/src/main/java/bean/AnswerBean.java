package bean;

import java.io.Serializable;
import java.util.List;

//Serializableインターフェース
public class AnswerBean implements Serializable {
    private static final long serialVersionUID = 1L;

    //privateメンバ変数で定義
    private int id;
    private int question_id;
    private String answer;
    private List<AnswerBean> answerlist;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<AnswerBean> getAnswerlist() {
		return answerlist;
	}

	public void setAnswerlist(List<AnswerBean> answerlist) {
		this.answerlist = answerlist;
	}

	//引数無しのコンストラクタ
    public AnswerBean() {
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

}