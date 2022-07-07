/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizzes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class QuizDAO {
    
    private QuizDTO quizDTO;
    private QuizModel quizModel;
    
    //Fields
    private final String QUIZ_DTO_FIELDS = "Id, TopicId";
    private final String QUIZ_CONTENT = "Id, TopicId, Content";
    
    //Sql queries
    private final String GET_QUIZ_CONTENT = "SELECT " + QUIZ_CONTENT
            + " FROM Quiz WHERE TopicId=?";
    
    private final String GET_QUIZ = "SELECT " + QUIZ_DTO_FIELDS
            + " FROM Quiz WHERE TopicId=?";
    
    public QuizModel getContent(int topicId) throws SQLException {
        QuizModel quizModel = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_QUIZ_CONTENT);
                ptm.setInt(1, topicId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    quizModel = new QuizModel();
                    quizModel.setTopicId(topicId);
                    quizModel.setQuizId(rs.getInt("Id"));
                    quizModel.setContent(rs.getString("Content"));
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
        return quizModel;
    }
}
