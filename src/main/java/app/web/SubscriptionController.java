package app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubscriptionController {

    @GetMapping("/subscriptions")
    public ModelAndView subscriptions() {
        return new ModelAndView("upgrade");
    }
    @GetMapping("/subscriptions/history")
    public ModelAndView subscriptionHistory() {
        return new ModelAndView("subscription-history");
    }
}
