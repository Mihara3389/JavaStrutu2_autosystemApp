package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.QuestionBean;

public class QuestionDao {
    private Connection conn;
    private PreparedStatement ps  = null;
    private ResultSet rs  = null;
    
    public  List<QuestionBean> getQuestion() throws SQLException {
        //dao.ConnectionDaoからデータベースへの接続を得る
        conn = ConnectionDao.getConnect();
        //SQLステートメント、オブジェクトの作成
        String sql = "select * from questions";
        ps = conn.prepareStatement(sql);
        //結果の出力
        rs = ps.executeQuery();
        //結果を格納
        List<QuestionBean> questionlist = new ArrayList<QuestionBean>();
        while (rs.next()) {        	
        	QuestionBean q = new QuestionBean();
        	q.setId(rs.getInt("id"));
        	q.setQuestion(rs.getString("question"));
        	questionlist.add(q);
        }
        return questionlist;
    }
}
