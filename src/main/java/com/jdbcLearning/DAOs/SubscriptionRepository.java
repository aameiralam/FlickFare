package com.jdbcLearning.DAOs;

import com.jdbcLearning.Models.Movies;
import com.jdbcLearning.Models.Subscription;

import java.util.List;

public interface SubscriptionRepository {

    public int insertSubscription(Subscription subscription);

    public int updateSubscription(Subscription updatedSubscription);

    public int deleteSubscription(Subscription deletedSubscription);

}
