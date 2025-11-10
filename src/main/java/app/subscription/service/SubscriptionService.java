package app.subscription.service;

import app.subscription.model.SubscriptionPeriod;
import app.subscription.model.SubscriptionType;
import app.user.model.User;

public interface SubscriptionService {
    void createDefaultSubscription(User user);

    int totalSubscriptionsByType(SubscriptionType subscriptionType);

    int totalSubscriptionsByPeriod(SubscriptionPeriod subscriptionPeriod);
}
