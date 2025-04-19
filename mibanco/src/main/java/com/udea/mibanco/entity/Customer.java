package com.udea.mibanco.entity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Setter
@Getter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String accountNumber;
    @Column(unique = true, length = 50)
    private String firstName;
    @Column(unique = true, length = 50)
    private String lastName;
    @Column(nullable = false)
    private Double balance;

    @JsonCreator
    public Customer(@JsonProperty("id") Long id,
                    @JsonProperty("accountNumber") String accountNumber,
                    @JsonProperty("firstName") String firstName,
                    @JsonProperty("lastName") String lastName,
                    @JsonProperty("balance") Double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }
}
