package com.udea.mibanco.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@Setter
@Getter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String senderAccountNumber;
    @Column(nullable = false)
    private String receiverAccountNumber;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private String timestamp;

    public Transaction(Long id, String senderAccountNumber, String receiverAccountNumber, Double amount, String timestamp) {
        this.id = id;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.timestamp = timestamp;
    }
}
