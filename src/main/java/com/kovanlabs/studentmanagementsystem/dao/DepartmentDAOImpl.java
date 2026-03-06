package com.kovanlabs.studentmanagementsystem.dao;

import com.kovanlabs.studentmanagementsystem.model.DepartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public String createDepartment(DepartmentModel departmentModel) {

        String query = "INSERT INTO department(department_name, no_of_faculty) VALUES (?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, departmentModel.getDepartmentName());
            preparedStatement.setInt(2, departmentModel.getFacultyCount());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "Department created";
    }

    @Override
    public List<DepartmentModel> displayDepartment(DepartmentModel departmentModel) {

        List<DepartmentModel> departmentList = new ArrayList<>();

        String query = "SELECT * FROM department";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while(resultSet.next()){

                DepartmentModel dm = new DepartmentModel();

                dm.setDepartmentId(resultSet.getLong("department_id"));
                dm.setDepartmentName(resultSet.getString("department_name"));
                dm.setFacultyCount(resultSet.getInt("no_of_faculty"));

                departmentList.add(dm);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return departmentList;
    }

    @Override
    public String updateDepartment(DepartmentModel departmentModel) {

        String query = "UPDATE department SET department_name = ?, no_of_faculty = ? WHERE department_id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, departmentModel.getDepartmentName());
            preparedStatement.setInt(2, departmentModel.getFacultyCount());
            preparedStatement.setLong(3, departmentModel.getDepartmentId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "Department updated";
    }

    @Override
    public String deleteDepartment(int departmentId) {

        String query = "DELETE FROM department WHERE department_id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, departmentId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "Department deleted";
    }
}