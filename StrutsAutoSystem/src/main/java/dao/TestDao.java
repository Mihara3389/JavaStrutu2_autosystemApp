package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TestDao {
    private Connection conn;
    private PreparedStatement ps  = null;
    private ResultSet rs  = null;
    private PreparedStatement ps_2  = null;
    
    public void updateHistory(String name,int result, Timestamp created_at) throws SQLException {
        //dao.ConnectionDaoからデータベースへの接続を得る
        conn = ConnectionDao.getConnect();
        //SQLステートメント、オブジェクトの作成
        String sql = "select * from users where name = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        //結果の出力
        rs = ps.executeQuery();
        int id = 0;
        while (rs.next()) {
			id = rs.getInt("id");
        }
        ps.close();
        rs.close();
        //SQLステートメント、オブジェクトの作成
        String sql_2 = "insert into histories (user_id,point,created_at) VALUES(?,?,?)";
        ps_2 = conn.prepareStatement(sql_2);
        ps_2.setInt(1, id);
        ps_2.setInt(2, (int) result);
        ps_2.setTimestamp(3, created_at);
        ps_2.executeUpdate();
        ps_2.close();
    }
}
