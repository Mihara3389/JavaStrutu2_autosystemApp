package bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

//Serializableインターフェース
public class HistoryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    //privateメンバ変数で定義
    private int id;
    private int user_id;
    private int point;
    private Timestamp created_at;
    private List<HistoryBean> historylist;

	//引数無しのコンストラクタ
    public HistoryBean() {
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

    public List<HistoryBean> getHistorylist() {
		return historylist;
	}

	public void setHistorylist(List<HistoryBean> historylist) {
		this.historylist = historylist;
	}

}