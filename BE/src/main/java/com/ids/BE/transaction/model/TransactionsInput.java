package com.ids.BE.transaction.model;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsInput {

    private String id;
    private String productId;
    private String productName;
    private String amount;
    private String customerName;
    private Integer status;
    private LocalDateTime transactionDate;
    private String createBy;

}
