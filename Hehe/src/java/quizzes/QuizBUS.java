/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizzes;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class QuizBUS {
    private QuizDAO dao;
    private QuizDTO quizDTO;
    private QuizModel quizModel;
    
    public ArrayList<QuizDTO> get (int topicId) throws SQLException{
        dao = new QuizDAO();
        ArrayList<QuizDTO> list= dao.get(topicId);
        return list;
    }
}
