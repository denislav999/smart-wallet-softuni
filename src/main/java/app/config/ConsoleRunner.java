//package app.config;
//
//import app.subscription.service.SubscriptionService;
//import app.user.model.User;
//import app.user.service.UserService;
//import app.wallet.service.WalletService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class ConsoleRunner implements CommandLineRunner {
//    public final UserService userService;
//    public final WalletService walletService;
//    public final SubscriptionService subscriptionService;
//
//    @Autowired
//    public ConsoleRunner(UserService userService, WalletService walletService, SubscriptionService subscriptionService) {
//        this.userService = userService;
//        this.walletService = walletService;
//        this.subscriptionService = subscriptionService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        User user = userService.getByUsername("pencho1234");
//        walletService.createDefaultWallet(user);
//        subscriptionService.createDefaultSubscription(user);
//
//    }
//}

//insert into users (id, country, created_on, email, first_name, is_active, last_name, password, profile_picture, role, updated_on, username) VALUES
//(BIN(1) ,'BULGARIA',NOW(),'pencho_shusha@abv.bg', 'Pencho',true, 'Wouf', '1234', null, 'USER', NOW(), 'pencho1234' );

