package app.transaction.repository;

import app.transaction.model.Transaction;
import app.transaction.model.TransactionStatus;
import app.transaction.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t")
    double totalTransactionsAmount();

    long countByType(TransactionType type);

    long countByStatus(TransactionStatus status);

}
