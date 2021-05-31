package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.HistoryBean;

public class HistoriesDao {
    private Connection conn;
    private PreparedStatement ps  = null;
    private ResultSet rs  = null;
    private PreparedStatement ps_2  = null;
    private ResultSet rs_2  = null;
    
    public  List<HistoryBean> getHistory(String name) throws SQLException {
        //dao.ConnectionDaoからデータベースへの接続を得る
        conn = ConnectionDao.getConnect();
        //SQLステートメント、オブジェクトの作成(users)
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
        //SQLステートメント、オブジェクトの作成(histories)
        String sql_2 = "select * from histories where user_id = ?";
        ps_2 = conn.prepareStatement(sql_2);
        ps_2.setInt(1, id);
        //結果の出力
        rs_2 = ps_2.executeQuery();
        //結果を格納
        List<HistoryBean> historylist = new ArrayList<HistoryBean>();
        while (rs_2.next()) {        	
        	HistoryBean history = new HistoryBean();
        	history.setId(rs_2.getInt("id"));
        	history.setUser_id(rs_2.getInt("user_id"));
        	history.setPoint(rs_2.getInt("point"));
        	history.setCreated_at(rs_2.getTimestamp("created_at"));
        	historylist.add(history);
        }
        return historylist;
    }
}
