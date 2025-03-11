package com.ids.BE.transaction.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ids.BE.entitiy.Transaction;
import com.ids.BE.repository.DaoTransactions;
import com.ids.BE.transaction.model.TransactionsInput;
import com.ids.BE.transaction.model.TransactionsOutput;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransactionsService {

    @Autowired
    private DaoTransactions daoTransactions;

    public List<Transaction> list() {
        return daoTransactions.findAll();
    }

    public TransactionsOutput detail(TransactionsInput input) throws Exception {
        Optional<Transaction> transactionOption = daoTransactions.findById(input.getId());

        Transaction transaction = transactionOption.orElseThrow(() -> new Exception("Transaction not found"));

        TransactionsOutput output = new TransactionsOutput();
        output.setId(transaction.getId());
        output.setProductId(transaction.getProductId());
        output.setProductName(transaction.getProductName());
        output.setAmount(transaction.getAmount());
        output.setCustomerName(transaction.getCustomerName());
        output.setStatus(transaction.getStatus());
        output.setTransactionDate(transaction.getTransactionDate());
        output.setCreateBy(transaction.getCreateBy());
        output.setCreateOn(transaction.getCreateOn());

        return output;
    }

    @Transactional
    public TransactionsOutput insert(TransactionsInput input) throws Exception {
        log.debug("insert [{}]", input);

        Random r = new Random();
        String randomNumber = String.format("%04d", r.nextInt(1001));

        Transaction transaction = new Transaction();
        transaction.setId(randomNumber);
        transaction.setProductId(input.getProductId());
        transaction.setProductName(input.getProductName());
        transaction.setAmount(input.getAmount());
        transaction.setCustomerName(input.getCustomerName());
        transaction.setStatus(input.getStatus());
        transaction.setTransactionDate(input.getTransactionDate());
        transaction.setCreateBy(input.getCreateBy());
        transaction.setCreateOn(LocalDateTime.now());

        daoTransactions.save(transaction);

        TransactionsOutput output = new TransactionsOutput();
        output.setId(transaction.getId());
        output.setProductId(transaction.getProductId());
        output.setProductName(transaction.getProductName());
        output.setAmount(transaction.getAmount());
        output.setCustomerName(transaction.getCustomerName());
        output.setStatus(transaction.getStatus());
        output.setTransactionDate(transaction.getTransactionDate());
        output.setCreateBy(transaction.getCreateBy());
        output.setCreateOn(transaction.getCreateOn());

        return output;

    }

    @Transactional
    public TransactionsOutput update(TransactionsInput input) throws Exception {
        log.debug("update [{}]", input);

        Transaction transaction = new Transaction();
        transaction.setProductId(input.getProductId());
        transaction.setProductName(input.getProductName());
        transaction.setAmount(input.getAmount());
        transaction.setCustomerName(input.getCustomerName());
        transaction.setStatus(input.getStatus());
        transaction.setTransactionDate(input.getTransactionDate());
        transaction.setCreateBy(input.getCreateBy());
        transaction.setCreateOn(LocalDateTime.now());

        daoTransactions.save(transaction);

        TransactionsOutput output = new TransactionsOutput();
        output.setId(transaction.getId());
        output.setProductId(transaction.getProductId());
        output.setProductName(transaction.getProductName());
        output.setAmount(transaction.getAmount());
        output.setCustomerName(transaction.getCustomerName());
        output.setStatus(transaction.getStatus());
        output.setTransactionDate(transaction.getTransactionDate());
        output.setCreateBy(transaction.getCreateBy());
        output.setCreateOn(transaction.getCreateOn());

        return output;

    }
    
}
