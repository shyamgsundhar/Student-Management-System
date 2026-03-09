package com.kovanlabs.studentmanagementsystem.dao;

import com.kovanlabs.studentmanagementsystem.model.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CourseDAOImpl implements  CourseDAO{
    @Autowired
    private DataSource dataSource;

    @Override
    public String createCourse(CourseModel courseModel) {

        String query= ("INSERT INTO course(course_id,course_name,department_id) VALUES (?,?,?)");
         try(Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(query)) {
             preparedStatement.setInt(1, courseModel.getCourseId());
             preparedStatement.setString(2,courseModel.getCourseName());
             preparedStatement.setInt(3, courseModel.getDepartmentId());

             preparedStatement.executeUpdate();

         } catch (SQLException e) {
             throw new RuntimeException(e);
         }

        return "Created course";
    }

    @Override
    public List<CourseModel> displayCourse(CourseModel courseModel) {
        List<CourseModel> courseModelList = new ArrayList<>();
        String query= ("SELECT * FROM course");
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery()) {

            while (resultSet.next()){
                CourseModel cm = new CourseModel();
                cm.setCourseId(resultSet.getInt("course_id"));
                cm.setCourseName(resultSet.getString("course_name"));
                cm.setCourseId(resultSet.getInt("department_id"));

                courseModelList.add(cm);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courseModelList;
    }

    @Override
    public String updateCourse(CourseModel courseModel) {

        String query= "UPDATE course SET department_id=? WHERE course_id=?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(query)){
            preparedStatement.setInt(1,courseModel.getDepartmentId());
            preparedStatement.setInt(2, courseModel.getCourseId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Updated course";
    }

    @Override
    public String deleteCourse(int courseId) {

        String query= "DELETE FROM course WHERE course_id =?";

        try(Connection connection= dataSource.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(query)) {
            preparedStatement.setInt(1,courseId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "Course deleted";
    }

    public List<CourseModel> getCourseWithDepartment() {

        List<CourseModel> list = new ArrayList<>();

        String query = "SELECT c.course_id, c.course_name, d.department_name " +
                "FROM course c JOIN department d " +
                "ON c.department_id = d.department_id";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {

                CourseModel cm = new CourseModel();

                cm.setCourseId(rs.getInt("course_id"));
                cm.setCourseName(rs.getString("course_name"));
                cm.setDepartmentName(rs.getString("department_name"));

                list.add(cm);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

}
