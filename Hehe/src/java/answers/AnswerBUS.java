/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package answers;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class AnswerBUS {

    private AnswerDAO dao;

    public ArrayList<AnswerModel> getAnswers(int quizId) throws SQLException {
        dao = new AnswerDAO();
        ArrayList<AnswerModel> list = dao.getAnswersContent(quizId);
        return list;
    }

    public boolean checkMultipleAnswerQuiz(ArrayList<Integer> answerIds, int quizId) throws SQLException {
        boolean check = false;
        dao = new AnswerDAO();
        ArrayList<Integer> result = dao.getCorrectAnswers(quizId);
        int resultSize = result.size();
        int answerSize = answerIds.size();
        boolean found;
        for (int i = 0; i < answerSize; i++) {
            found = false;
            for (int j = 0; j < resultSize; j++) {
                if (answerIds.get(i).intValue() == result.get(j).intValue()) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                check = found;
                break;
            }
        }

        return check;
    }

    public boolean checkSingleAnswerQuiz(Integer answerId, int quizId) throws SQLException {
        boolean check = false;
        dao = new AnswerDAO();
        ArrayList<Integer> result = dao.getCorrectAnswers(quizId);
        if (answerId.intValue() == result.get(0).intValue()) {
            check = true;
        }
        return check;
    }
}
