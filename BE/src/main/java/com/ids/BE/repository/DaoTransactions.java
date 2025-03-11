package com.ids.BE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids.BE.entitiy.Transaction;

public interface DaoTransactions extends JpaRepository<Transaction, String> {

}
