package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ListBean;

public class ListDao {
    private Connection conn;
    private PreparedStatement ps  = null;
    private ResultSet rs  = null;
    
    public  List<ListBean> getList() throws SQLException {
        //dao.ConnectionDaoからデータベースへの接続を得る
        conn = ConnectionDao.getConnect();
        //SQLステートメント、オブジェクトの作成
        String sql = "SELECT ROW_NUMBER() OVER(PARTITION BY questions.id ORDER BY questions.id) AS rownum, questions.id as qid, questions.question, correct_answers.id as aid, correct_answers.answer as answer FROM questions LEFT JOIN correct_answers ON questions.id = correct_answers.question_id;";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        //結果の出力
        rs = ps.executeQuery();
        //結果を格納
        List<ListBean> list = new ArrayList<ListBean>();
        while (rs.next()) {        	
        	ListBean l = new ListBean();
        	l.setId(rs.getInt("qid"));
        	l.setQuestion(rs.getString("question"));
        	l.setAnswer_count(rs.getInt("rownum"));
        	l.setAnswer(rs.getString("answer"));
        	list.add(l);
        }
        return list;
    }
}
