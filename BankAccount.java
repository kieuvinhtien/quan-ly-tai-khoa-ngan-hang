package bankapp_project.src.model;

import java.time.LocalDate;

public class BankAccount {
    private String accountNumber;
    private Customer owner;
    private double balance;
    private LocalDate openedDate;
    private boolean active;

    public BankAccount(String accountNumber, Customer owner, double balance){
        this.accountNumber=accountNumber;
        this.owner=owner;
        this.balance=balance;
        this.openedDate=LocalDate.now();
        this.active=true;
    }
    public String getAccountNumber(){return accountNumber;}
    public Customer getOwner(){return owner;}
    public double getBalance(){return balance;}
    public LocalDate getOpenedDate(){return openedDate;}
    public boolean isActive(){return active;}

    public void setBalance(double b){balance=b;}
    public void setOpenedDate(LocalDate d){openedDate=d;}
    public void setActive(boolean a){active=a;}
}