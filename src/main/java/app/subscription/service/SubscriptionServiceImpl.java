package app.subscription.service;

import app.subscription.model.Subscription;
import app.subscription.model.SubscriptionPeriod;
import app.subscription.model.SubscriptionStatus;
import app.subscription.model.SubscriptionType;
import app.subscription.repository.SubscriptionRepository;
import app.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void createDefaultSubscription(User user) {
        Subscription subscription = Subscription.builder()
                .owner(user)
                .status(SubscriptionStatus.ACTIVE)
                .period(SubscriptionPeriod.MONTHLY)
                .price(BigDecimal.ZERO)
                .renewalAllowed(true)
                .createdOn(LocalDateTime.now())
                .expiresOn(LocalDateTime.now().plusMonths(1))
                .type(SubscriptionType.DEFAULT)
                .build();

        subscriptionRepository.saveAndFlush(subscription);
    }

    @Override
    public int totalSubscriptionsByType(SubscriptionType subscriptionType) {
        return subscriptionRepository.countByType(subscriptionType);
    }
    @Override
    public int totalSubscriptionsByPeriod(SubscriptionPeriod subscriptionPeriod) {
        return subscriptionRepository.countByPeriod(subscriptionPeriod);
    }
}
