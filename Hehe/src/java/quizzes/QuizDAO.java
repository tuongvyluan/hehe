/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizzes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author admin
 */
public class QuizDAO {

    private QuizDTO quizDTO;

    //Sql queries
    private final String GET_QUIZ_BY_TOPIC = "SELECT Id, TopicId, Content, Date, NumberAnswers FROM Quiz Where TopicId=?";

    public ArrayList<QuizDTO> get(int topicId) throws SQLException {
        ArrayList<QuizDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_QUIZ_BY_TOPIC);
                ptm.setInt(1, topicId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    quizDTO = new QuizDTO();
                    quizDTO.setQuizId(rs.getInt("Id"));
                    quizDTO.setTopicId(rs.getInt("TopicId"));
                    quizDTO.setContent(rs.getString("Content"));
                    quizDTO.setDate(rs.getDate("Date"));
                    quizDTO.setNumberAnswers(rs.getInt("NumberAnswers"));
                    list.add(quizDTO);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
}
