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
    private AnswerModel answerModel;

    //Fields
    private final String ANSWER_CONTENT = "Id, QuizId, Content, IsCorrect";
    private final String ANSWER_DTO_FIELDS = "Id, QuizId, IsCorrect";

    //Sql queries
    private final String GET_ANSWERS_CONTENT = "SELECT " + ANSWER_CONTENT
            + " FROM Answer WHERE QuizId=? AND Status='ACTIVE' ORDER BY NEWID()";

    private final String GET_RESULT = "SELECT Id FROM Answer "
            + "WHERE QuizId=? AND IsCorrect='TRUE' AND Status='ACTIVE'";

    public ArrayList<AnswerModel> getAnswersContent(int quizId) throws SQLException {
        ArrayList<AnswerModel> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ANSWERS_CONTENT);
                ptm.setInt(1, quizId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    answerModel = new AnswerModel();
                    answerModel.setQuizId(quizId);
                    answerModel.setAnswerId(rs.getInt("Id"));
                    answerModel.setContent(rs.getString("Content"));
                    answerModel.setCorrect(rs.getBoolean("IsCorrect"));
                    list.add(answerModel);
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

    public ArrayList<Integer> getCorrectAnswers(int quizId) throws SQLException {
        ArrayList<Integer> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int ansId;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_RESULT);
                ptm.setInt(1, quizId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    ansId = rs.getInt("Id");
                    list.add(ansId);
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
