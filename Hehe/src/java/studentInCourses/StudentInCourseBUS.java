/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInCourses;

import courses.CourseDTO;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import studentInTopics.StudentInTopicDAO;
import topics.TopicDAO;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInCourseBUS {

    private StudentInCourseDAO dao;

    public StudentInCourseModel enrollCourse(int studentId, int courseId) {
        StudentInCourseModel enrollment = null;
        try {
            dao = new StudentInCourseDAO();
            enrollment = dao.insert(studentId, courseId);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return enrollment;
    }

    public ArrayList<CourseDTO> getStudyingCourses(int studentId) throws SQLException {
        dao = new StudentInCourseDAO();
        ArrayList<CourseDTO> list = dao.getStudyingCourses(studentId);
        return list;
    }
    
    public double getCourseProgress(int studentId, int courseId) throws SQLException {
        double progress = 0;
        DecimalFormat df = new DecimalFormat("0.0");
        StudentInTopicDAO studentInTopicDAO = new StudentInTopicDAO();
        TopicDAO topicDAO = new TopicDAO();
        int completedCourse = studentInTopicDAO.countCompletedTopicsByCourse(studentId, courseId);
        int totalTopics = topicDAO.countTopicsByCourse(courseId);
        if (totalTopics != 0) {
            progress = completedCourse * 100 / totalTopics;
        }
        return Double.parseDouble(df.format(progress));
    }
    
    public ArrayList<Double> getCoursesProgress(int studentId, ArrayList<CourseDTO> courses) throws SQLException {
        ArrayList<Double> progressList = null;
        if (courses != null && !courses.isEmpty()) {
            progressList = new ArrayList<>();
            double progress = 0;
            for (CourseDTO courseDTO : courses) {
                progress = getCourseProgress(studentId, courseDTO.getCourseId());
                progressList.add(progress);
            }
        }
        return progressList;
    }
}
