package app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WalletController {

    @GetMapping("/wallets")
    public ModelAndView wallets() {
        return new ModelAndView("wallets");
    }
}
