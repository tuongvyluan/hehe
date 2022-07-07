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
        ArrayList<AnswerModel> list = dao.getAnswers(quizId);
        return list;
    }
    
}
