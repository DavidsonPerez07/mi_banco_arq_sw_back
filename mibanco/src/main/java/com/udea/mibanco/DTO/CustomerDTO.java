package com.udea.mibanco.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    private Long id;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private Double balance;

    public CustomerDTO(Long id, String firstName, String lastName, String accountNumber, Double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }
}
