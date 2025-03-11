package com.ids.BE.entitiy;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "product_id", nullable = false, length = 255)
    private String productId;

    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;

    @Column(name = "amount", nullable = false, length = 255)
    private String amount;

    @Column(name = "customer_name", nullable = false, length = 255)
    private String customerName;

    @Column(name = "status", nullable = false, length = 255)
    private Integer status;

    @CreatedDate
    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "create_by", nullable = false, length = 255)
    private String createBy;

    @CreatedDate
    @Column(name = "create_on")
    private LocalDateTime createOn;
    
}
