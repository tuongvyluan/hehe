/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package answers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class AnswerDAO {
        private AnswerDTO answerDTO;

    //Sql queries
    private final String GET_ANSWER_BY_QUIZ = "SELECT Id, QuizId, Content, IsCorrect FROM Answer Where QuizId=?";

    public ArrayList<AnswerDTO> get(int topicId) throws SQLException {
        ArrayList<AnswerDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ANSWER_BY_QUIZ);
                ptm.setInt(1, topicId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    answerDTO = new AnswerDTO();
                    answerDTO.setAnswerId(rs.getInt("Id"));
                    answerDTO.setQuizId(rs.getInt("QuizId"));
                    answerDTO.setContent(rs.getString("Content"));
                    answerDTO.setCorrect(rs.getBoolean("IsCorrect"));
                    list.add(answerDTO);
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
