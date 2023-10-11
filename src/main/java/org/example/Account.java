package org.example;

import java.time.LocalDate;

public class Account {
    long accountNo;
    LocalDate dateOpened;

    double balance;

    Account(){}

    public Account(long accountNo, LocalDate dateOpened, double balance) {
        this.accountNo = accountNo;
        this.dateOpened = dateOpened;
        this.balance = balance;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", dateOpened=" + dateOpened +
                ", balance=" + balance +
                '}';
    }
}
