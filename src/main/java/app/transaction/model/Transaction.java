package app.transaction.model;

import app.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private User owner;
    @Column(nullable = false)
    private String sender;
    @Column(nullable = false)
    private String receiver;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false, name = "balance_left")
    private BigDecimal balanceLeft;
    @Column(nullable = false)
    private Currency currency;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @Column(nullable = false)
    private TransactionStatus status;
    @Column
    private String description;
    @Column(name = "failed_reason")
    private String failedReason;
    @Column(nullable = false, name = "created_on")
    private LocalDateTime createdOn;
}
