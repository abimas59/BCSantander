package britt.desafio_publicando.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity(name ="tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String number;

    private String agency;
    //precição de 13 99999999 e 2 escalas de casas decimais
    @Column(precision = 13,scale = 2) // quantidade de numeros q gostaria 13 inteiros 2 decimais
    private BigDecimal balance;
    @Column(name = "additional_limit", precision = 13,scale = 2) // quantidade de numeros q gostaria 13 inteiros 2 decimais
    private BigDecimal limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
