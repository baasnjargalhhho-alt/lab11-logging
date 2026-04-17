package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount {
    // Алхам 2: Encapsulation - private static final Logger
    private static final Logger logger = LogManager.getLogger(BankAccount.class);
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        logger.trace("Entering deposit() with amount={}", amount); // TRACE - Орох
        if (amount <= 0) {
            logger.warn("Invalid input: amount {} is negative or zero", amount); // WARN - Буруу оролт
            return;
        }
        logger.debug("Balance before deposit: {}", balance); // DEBUG - Өмнөх үлдэгдэл
        balance += amount;
        logger.info("Deposited {}. New balance={}", amount, balance); // INFO - Амжилттай
        logger.trace("Exiting deposit()"); // TRACE - Гарах
    }

    public void withdraw(double amount) {
        logger.trace("Entering withdraw() with amount={}", amount);
        
        if (amount <= 0) {
            logger.warn("Invalid withdrawal amount: {}", amount);
        } else if (amount > balance) {
            // ERROR — Үлдэгдэлээс их мөнгө авах гэж оролдох
            logger.error("ERROR: Insufficient funds! Current balance: {}, Attempted: {}", balance, amount);
        } else {
            logger.debug("Balance before withdraw: {}", balance);
            balance -= amount;
            logger.info("Successfully withdrew {}. New balance: {}", amount, balance);
        }
        
        logger.trace("Exiting withdraw()");
    }

    public double getBalance() {
        logger.trace("Entering getBalance()");
        logger.debug("Current balance requested: {}", balance);
        return balance;
    }

    public void simulateFatalError() {
        // FATAL — Системийн критик нөхцөл (жишээ)
        logger.fatal("FATAL ERROR: System configuration file is corrupted or missing!");
    }
}