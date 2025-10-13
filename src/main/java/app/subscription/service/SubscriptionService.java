package app.subscription.service;

import app.user.model.User;

public interface SubscriptionService {
    void createDefaultSubscription(User user);
}
