package com.jdbcLearning.DAOs;

import com.jdbcLearning.Models.User;
import com.jdbcLearning.Util.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements UserRepository {
    @Override
    public int insertUser(User user) {

        int status = 0;

        try (Connection connection2 = SQLConnector.createConnection()) {
            String sql = "INSERT INTO User (firstName, lastName, phoneNumber, address) Values (?,?,?,?)";
            PreparedStatement ps = connection2.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setLong(3, user.getPhoneNumber());
            ps.setString(4, user.getAddress());

            status = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return status;

    }

    @Override
    public List<User> getAllUser() {

        ArrayList<User> userList = new ArrayList<>();
        try (Connection connection2 = SQLConnector.createConnection()) {
            String query = "SELECT * from user";
            PreparedStatement ps = connection2.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User userRs = new User();
                userRs.setId(rs.getInt(1));
                userRs.setFirstName(rs.getString(2));
                userRs.setLastName(rs.getString(3));
                userRs.setPhoneNumber(rs.getLong(4));
                userRs.setAddress(rs.getString(5));
                userList.add(userRs);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;

    }


    @Override
    public int updateUser(User updatedUser) {
        int status = 0;
        try (Connection connection2 = SQLConnector.createConnection()){
            String updateQuery = "UPDATE user set firstName =?, lastName = ?, phoneNumber = ?, address=? where userId = ?";
            PreparedStatement ps = connection2.prepareStatement(updateQuery);
            ps.setString(1, updatedUser.getFirstName());
            ps.setString(2, updatedUser.getLastName());
            ps.setLong(3, updatedUser.getPhoneNumber());
            ps.setString(4, updatedUser.getAddress());
            ps.setInt(5, updatedUser.getId());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }

    @Override
    public int deleteUser(User deletedUser) {
        int status = 0;
        try (Connection connection2 = SQLConnector.createConnection()) {
            String deleteQuery = "DELETE from user where userId = ?";
            PreparedStatement ps = connection2.prepareStatement(deleteQuery);
            ps.setInt(1, deletedUser.getId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }
}
