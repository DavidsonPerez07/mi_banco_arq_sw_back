package com.udea.mibanco.controller;

import com.udea.mibanco.DTO.TransactionDTO;
import com.udea.mibanco.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(value = "http://localhost:5173")
public class TransactionController {
    private final TransactionService transactionFacade;

    public TransactionController(TransactionService transactionFacade) {
        this.transactionFacade = transactionFacade;
    }

    //Realizar una transferencia
    @PostMapping
    public ResponseEntity<TransactionDTO> transferMoney (@RequestBody TransactionDTO transactionDTO) {
        if(transactionDTO.getSenderAccountNumber() == null){
            throw new IllegalArgumentException("Sender account cannot be null");
        }
        else if(transactionDTO.getReceiverAccountNumber() == null){
            throw new IllegalArgumentException("Receiver account cannot be null");
        }
        else if(transactionDTO.getAmount() == null){
            throw new IllegalArgumentException("Amount cannot be null");
        }
        else if(transactionDTO.getTimestamp() == null){
            throw new IllegalArgumentException("Timestamp cannot be null");
        }

        return ResponseEntity.ok(transactionFacade.transferMoney(transactionDTO));
    }

    //Obtener el historial de transacciones de una cuenta
    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<TransactionDTO>> getTransactionHistoryByAccountNumber (
            @PathVariable String accountNumber ) {
        return ResponseEntity.ok(transactionFacade.getTransactionsForAccount(accountNumber));
    }
}
