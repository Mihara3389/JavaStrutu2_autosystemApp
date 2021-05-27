package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserBean;

public class UsersDao {
    private Connection conn;
    private UserBean user = new UserBean();
    private PreparedStatement ps  = null;
    private ResultSet rs  = null;
    
    public UserBean getUser(String name) throws SQLException {
        //dao.ConnectionDaoからデータベースへの接続を得る
        conn = ConnectionDao.getConnect();
        //SQLステートメント、オブジェクトの作成
        String sql = "select * from users where name = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        //結果の出力
        rs = ps.executeQuery();
        while (rs.next()) {        	
        	user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
        return null;
    }
}
