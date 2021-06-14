package bean;

import java.io.Serializable;
import java.util.List;

//Serializableインターフェース
public class ListBean implements Serializable {
    private static final long serialVersionUID = 1L;

    //privateメンバ変数で定義
    private int id;
    private String question;
    private int answer_count;
    private String answer;
    private List<ListBean> list;

	public List<ListBean> getList() {
		return list;
	}

	public void setList(List<ListBean> list) {
		this.list = list;
	}

	//引数無しのコンストラクタ
    public ListBean() {
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

	public int getAnswer_count() {
		return answer_count;
	}

	public void setAnswer_count(int answer_count) {
		this.answer_count = answer_count;
	}
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}