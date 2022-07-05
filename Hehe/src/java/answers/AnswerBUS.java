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
    private AnswerDTO answerDTO;
    private AnswerModel answerModel;

    public ArrayList<AnswerDTO> get(int quizId) throws SQLException {
        dao = new AnswerDAO();
        ArrayList<AnswerDTO> list = dao.get(quizId);
        return list;
    }
}
