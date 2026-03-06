package com.kovanlabs.studentmanagementsystem.dao;

import com.kovanlabs.studentmanagementsystem.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private DataSource dataSource;
    @Override
    public void addStudent(StudentModel student) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO students(student_name,email,department) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getStudent_name());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getDepartment());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<StudentModel> getAllStudents() {
        List<StudentModel> list = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM students";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentModel s = new StudentModel();
                s.setId(rs.getInt("student_id"));
                s.setStudent_name(rs.getString("student_name"));
                s.setEmail(rs.getString("email"));
                s.setDepartment(rs.getString("department"));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

   @Override
    public StudentModel getStudentById(int id) {
        StudentModel s = new StudentModel();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM students WHERE student_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setId(rs.getInt("student_id"));
                s.setStudent_name(rs.getString("student_name"));
                s.setEmail(rs.getString("email"));
                s.setDepartment(rs.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    @Override
    public void updateStudent(StudentModel student) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "UPDATE students SET student_name=?, email=?, department=? WHERE student_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getStudent_name());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getDepartment());
            ps.setInt(4, student.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "DELETE FROM students WHERE student_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}