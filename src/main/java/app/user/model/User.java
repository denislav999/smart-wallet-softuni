package app.user.model;

import app.subscription.model.Subscription;
import app.wallet.model.Wallet;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
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
    private Country country;
    @Column(nullable = false)
    private boolean isActive;
    @Column(nullable = false, name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private Set<Subscription> subscriptions = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private Set<Wallet> wallets = new HashSet<>();






}

//        · username – a String, the username of the user
//· firstName – a String, the first name of the user
//· lastName – a String, the last name of the user
//· profilePicture – a String, URL containing link to picture of the user
//· email – a String, email of the user
//· password – a String, password of the user
//· role – a UserRole, enumerated value (ADMIN, USER)
//· country – a Country, enumerated value (BULGARIA, GERMANY, FRANCE)
//· isActive – a boolean value which indicates whether the User is active
//· createdOn – LocalDateTime, the date and time the User account was initialized
//· updatedOn – LocalDateTime, the date and time the User account was updated
//· subscriptions – a List of Subscription containing user's subscriptions
//        · wallets – a List of Wallet containing user's wallets

