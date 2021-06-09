package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AnswerBean;

public class AnswerDao {
    private Connection conn;
    private PreparedStatement ps  = null;
    private ResultSet rs  = null;
    
    public  List<AnswerBean> getAnswer() throws SQLException {
        //dao.ConnectionDaoからデータベースへの接続を得る
        conn = ConnectionDao.getConnect();
        //SQLステートメント、オブジェクトの作成
        String sql = "select * from  correct_answers";
        ps = conn.prepareStatement(sql);
        //結果の出力
        rs = ps.executeQuery();
        //結果を格納
        List<AnswerBean> answerlist = new ArrayList<AnswerBean>();
        while (rs.next()) {        	
        	AnswerBean a = new AnswerBean();
        	a.setId(rs.getInt("id"));
        	a.setQuestion_id(rs.getInt("question_id"));
        	a.setAnswer(rs.getString("answer"));
        	answerlist.add(a);
        }
        return answerlist;
    }
}
