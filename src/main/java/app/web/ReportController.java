package app.web;

import app.subscription.model.SubscriptionPeriod;
import app.subscription.model.SubscriptionType;
import app.subscription.service.SubscriptionService;
import app.transaction.service.TransactionService;
import app.user.service.UserService;
import app.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.Map;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final UserService userService;
    private final WalletService walletService;
    private final TransactionService transactionService;
    private final SubscriptionService subscriptionService;

    @Autowired
    public ReportController(UserService userService, WalletService walletService, TransactionService transactionService, SubscriptionService subscriptionService) {
        this.userService = userService;
        this.walletService = walletService;
        this.transactionService = transactionService;
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public ModelAndView getReports() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("reports");

        mav.addObject("totalUsers", userService.totalUsers());
        mav.addObject("activeUsers", userService.totalActiveUsers());
        mav.addObject("inactiveUsers", userService.totalInactiveUsers());
        mav.addObject("totalAdmins", userService.totalAdmins());
        mav.addObject("nonAdminUsers", userService.totalNonAdminUsers());

        Map<Integer, Double> percentages = walletService.walletsPerUserPercentages();
        mav.addObject("totalWallets", walletService.walletCount());
        mav.addObject("totalWalletAmount", String.format("%.2f", walletService.totalWalletAmount()));
        mav.addObject("usersWith1Wallet", String.format("%.2f", percentages.get(1)));
        mav.addObject("usersWith2Wallets", String.format("%.2f", percentages.get(2)));
        mav.addObject("usersWith3Wallets", String.format("%.2f", percentages.get(3)));

        mav.addObject("totalTransactions", transactionService.totaTransactions());
        mav.addObject("totalTransactionAmount", String.format("%.2f" ,transactionService.totalTransactionsAmount()));
        mav.addObject("totalWithdrawals", transactionService.totalWithdrawals());
        mav.addObject("totalDeposits", transactionService.totalDeposits());
        mav.addObject("succeededTransactions", transactionService.totalSucceededTransactions());
        mav.addObject("failedTransactions", transactionService.totalFailedTransactions());

        mav.addObject("totalDefaultSubscriptions", subscriptionService.totalSubscriptionsByType(SubscriptionType.DEFAULT));
        mav.addObject("totalPremiumSubscriptions", subscriptionService.totalSubscriptionsByType(SubscriptionType.PREMIUM));
        mav.addObject("totalUltimateSubscriptions", subscriptionService.totalSubscriptionsByType(SubscriptionType.ULTIMATE));
        mav.addObject("totalMonthlySubscriptions", subscriptionService.totalSubscriptionsByPeriod(SubscriptionPeriod.MONTHLY));
        mav.addObject("totalYearlySubscriptions", subscriptionService.totalSubscriptionsByPeriod(SubscriptionPeriod.YEARLY));
        return mav;
    }
}
