package bean;

import java.io.Serializable;
import java.util.List;

//Serializableインターフェース
public class QuestionBean implements Serializable {
    private static final long serialVersionUID = 1L;

    //privateメンバ変数で定義
    private int id;
    private String question;
    private List<QuestionBean> questionlist;

	//引数無しのコンストラクタ
    public QuestionBean() {
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<QuestionBean> getQuestionlist() {
		return questionlist;
	}

	public void setQuestionlist(List<QuestionBean> questionlist) {
		this.questionlist = questionlist;
	}

}