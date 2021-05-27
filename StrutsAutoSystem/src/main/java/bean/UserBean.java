package bean;

import java.io.Serializable;

//Serializableインターフェース
public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    //privateメンバ変数で定義
    private String name;
    private String password;

    //引数無しのコンストラクタ
    public UserBean() {
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

    //getter(参照するためのアクセッサー）/setter(設定するためのアクセッサ-）
    
}