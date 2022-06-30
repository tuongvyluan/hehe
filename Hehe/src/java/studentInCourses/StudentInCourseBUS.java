/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInCourses;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInCourseBUS {
    
    private StudentInCourseDAO dao;
    
    public StudentInCourseModel enrollCourse(int studentId, int courseId) {
        StudentInCourseModel enrollment = null;
        try {
            enrollment = dao.insert(studentId, courseId);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return enrollment;
    }
}
