package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class SignupDao {
    private Connection conn;
    private PreparedStatement ps  = null;
    
    public void updateUser(String name,String password) throws SQLException {
        //dao.ConnectionDaoからデータベースへの接続を得る
        conn = ConnectionDao.getConnect();
        //現在時刻を取得する
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //SQLステートメント、オブジェクトの作成
        String sql = "insert into users (name,password,created_at) VALUES(?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, password);
        ps.setTimestamp(3, timestamp);
        ps.executeUpdate();
        ps.close();
    }
}
