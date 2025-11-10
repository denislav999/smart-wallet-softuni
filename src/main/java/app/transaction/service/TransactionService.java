package app.transaction.service;

import app.transaction.model.Transaction;
import app.transaction.model.TransactionStatus;
import app.transaction.model.TransactionType;
import app.user.model.User;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public interface TransactionService {
      Transaction createNewTransaction(User owner, String smartWalletPlatform, String receiver, BigDecimal topUpAmount, BigDecimal balance, Currency currency, TransactionType deposit, TransactionStatus failed, String transactionDescription, String inactiveWallet);

    long totaTransactions();

    double totalTransactionsAmount();

    long totalWithdrawals();

    long totalDeposits();

    long totalSucceededTransactions();

    long totalFailedTransactions();
}
