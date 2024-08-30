package com.jdbcLearning.DAOs;

import com.jdbcLearning.Models.Subscription;
import com.jdbcLearning.Util.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubscriptionImpl implements SubscriptionRepository {
    @Override
    public int insertSubscription(Subscription subscription) {
        int status = 0;

        try (Connection connection2 = SQLConnector.createConnection()) {
            String sql = "INSERT INTO subscription (subscriptionType, startDate, subscriptionStatus) Values (?,?,?)";
            PreparedStatement ps = connection2.prepareStatement(sql);
            ps.setString(1, subscription.getSubscriptionType());
            ps.setString(2, subscription.getStartDate());
            ps.setString(3, subscription.getSubscriptionStatus());

            status = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return status;
    }

    @Override
    public int updateSubscription(Subscription updatedSubscription) {
        int status = 0;
        try (Connection connection2 = SQLConnector.createConnection()){
            String updateQuery = "UPDATE subscription set subscriptionType =?, startDate = ?, subscriptionStatus = ? where subscriptionId = ?";
            PreparedStatement ps = connection2.prepareStatement(updateQuery);
            ps.setString(1, updatedSubscription.getSubscriptionType());
            ps.setString(2, updatedSubscription.getStartDate());
            ps.setString(3, updatedSubscription.getSubscriptionStatus());
            ps.setInt(4, updatedSubscription.getSubscriptionId());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }

    @Override
    public int deleteSubscription(Subscription deletedSubscription) {
        int status = 0;
        try (Connection connection2 = SQLConnector.createConnection()) {
            String deleteQuery = "DELETE from subscription where subscriptionId = ?";
            PreparedStatement ps = connection2.prepareStatement(deleteQuery);
            ps.setInt(1, deletedSubscription.getSubscriptionId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
}
