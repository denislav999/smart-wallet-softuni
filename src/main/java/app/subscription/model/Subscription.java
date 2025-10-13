package app.subscription.model;

import app.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User owner;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;
    @Column
    @Enumerated(EnumType.STRING)
    private SubscriptionPeriod period;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SubscriptionType type;
    @Column(nullable = false, name = "renewal_allowed")
    private boolean renewalAllowed;
    @Column(nullable = false, name = "created_on")
    private LocalDateTime createdOn;
    @Column(nullable = false, name = "expires_on")
    private LocalDateTime expiresOn;

}
