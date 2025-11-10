package app.wallet.service;

import app.user.model.User;

import java.util.Map;

public interface WalletService {
    void createDefaultWallet(User user);
    public Map<Integer, Double> walletsPerUserPercentages();
    public int walletCount();
    public double totalWalletAmount();
}
