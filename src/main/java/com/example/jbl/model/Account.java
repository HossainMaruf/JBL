package com.example.jbl.model;

public class Account {
   private Long id; 
   private String name;
   private double balance;

   public Account() {}
   public Account(Long id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
   }
   // Getters
   public Long getId() {
    return id;
   }
   public String getName() {
    return name;
   }
   public double getBalance() {
    return balance;
   }
   // Setters
   public void setId(long id) {
    this.id = id;
   }
   public void setName(String name) {
    this.name = name;
   }
   public void setBalance(double balance) {
    this.balance = balance;
   }
}
