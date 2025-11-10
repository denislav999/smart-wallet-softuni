package app.web;

import app.transaction.model.Transaction;
import app.user.model.User;
import app.user.service.UserService;
import app.wallet.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;


@Controller
public class IndexController {

    private final UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @GetMapping("/home")
    public ModelAndView home() {
        User user = userService.getByUsername("pencho1234");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("user", user);

        modelAndView.addObject("lastSubscription", user.getSubscriptions()
                .stream()
                .findFirst()
                .orElse(null));

        modelAndView.addObject("lastTransaction", user.getTransactions()
                .stream()
                .sorted(Comparator.comparing(Transaction::getCreatedOn))
                .findFirst()
                .orElse(null));

        modelAndView.addObject("homeWallet", user.getWallets()
                .stream()
                .sorted(Comparator.comparing(Wallet::getUpdatedOn))
                .findFirst()
                .orElse(null));

        return modelAndView;
    }

}
