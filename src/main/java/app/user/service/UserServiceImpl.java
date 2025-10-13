package app.user.service;

import app.subscription.service.SubscriptionService;
import app.user.model.User;
import app.user.model.UserRole;
import app.user.repository.UserRepository;
import app.wallet.service.WalletService;
import app.web.dto.LoginRequest;
import app.web.dto.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final WalletService walletService;
    private final SubscriptionService subscriptionService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, WalletService walletService, SubscriptionService subscriptionService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.walletService = walletService;
        this.subscriptionService = subscriptionService;
    }

    public User login (LoginRequest loginRequest) {
        Optional<User> byUsername = userRepository.findByUsername(loginRequest.username());
        if (byUsername.isEmpty()) {
            throw new RuntimeException(String.format("Username %s does not exists!", loginRequest.username()));
        }

        String rawPassword = loginRequest.password();
        String hashedPassword = byUsername.get().getPassword();

        if (!passwordEncoder.matches(rawPassword, hashedPassword)) {
            throw new RuntimeException(String.format("Incorrect username or password!"));
        }

        return byUsername.get();
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        Optional<User> byUsername = userRepository.findByUsername(registerRequest.username());
        if (byUsername.isPresent()) {
            throw new RuntimeException(String.format("Username %s already exists", registerRequest.username()));
        }
        User user = User.builder()
                .username(registerRequest.username())
                .password(passwordEncoder.encode(registerRequest.password()))
                .role(UserRole.USER)
                .country(registerRequest.country())
                .isActive(true)
                .createdOn(LocalDateTime.now())
                .build();

        userRepository.saveAndFlush(user);
        walletService.createDefaultWallet(user);
        subscriptionService.createDefaultSubscription(user);


        log.info(String.format("User %s has been created!", registerRequest.username()));
    }
}
