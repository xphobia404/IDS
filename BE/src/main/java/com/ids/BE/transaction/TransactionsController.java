package com.ids.BE.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ids.BE.entitiy.Transaction;
import com.ids.BE.transaction.model.TransactionsInput;
import com.ids.BE.transaction.model.TransactionsOutput;
import com.ids.BE.transaction.service.TransactionsService;

@RequestMapping("/transactions")
@RestController
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping(value = "/list")
    public List<Transaction> list() throws Exception {
        return transactionsService.list();
    }

    @PostMapping(value = "/detail")
    public TransactionsOutput detail(@RequestBody TransactionsInput input) throws Exception{
        return transactionsService.detail(input);
    }

    @PostMapping(value = "/insert")
    public TransactionsOutput insert(@RequestBody TransactionsInput input) throws Exception{
        return transactionsService.insert(input);
    }

    @PostMapping(value = "/update")
    public TransactionsOutput update(@RequestBody TransactionsInput input) throws Exception{
        return transactionsService.update(input);
    }

}