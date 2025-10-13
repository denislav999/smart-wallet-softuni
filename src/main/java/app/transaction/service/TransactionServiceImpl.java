package app.transaction.service;

import app.transaction.model.Transaction;
import app.transaction.model.TransactionStatus;
import app.transaction.model.TransactionType;
import app.transaction.repository.TransactionRepository;
import app.user.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createNewTransaction(User owner, String smartWalletPlatform, String receiver, BigDecimal topUpAmount, BigDecimal balance, Currency currency, TransactionType deposit, TransactionStatus failed, String transactionDescription, String inactiveWallet) {
        Transaction transaction = Transaction.builder()
                .owner(owner)
                .sender(smartWalletPlatform)
                .receiver(receiver)
                .amount(topUpAmount)
                .balanceLeft(balance)
                .currency(currency)
                .type(deposit)
                .status(failed)
                .description(transactionDescription)
                .failedReason(inactiveWallet)
                .createdOn(LocalDateTime.now())
                .build();
        return transactionRepository.save(transaction);
    }
}
