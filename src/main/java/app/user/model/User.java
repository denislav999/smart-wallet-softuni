package app.user.model;

import app.subscription.model.Subscription;
import app.transaction.model.Transaction;
import app.wallet.model.Wallet;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(name = "profile_picture")
    private String profilePicture;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Column
    @Enumerated(EnumType.STRING)
    private Country country;
    @Column(nullable = false)
    private boolean isActive;
    @Column(nullable = false, name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    @OrderBy("createdOn")
    private Set<Subscription> subscriptions = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private Set<Wallet> wallets = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private Set<Transaction> transactions = new HashSet<>();

}
