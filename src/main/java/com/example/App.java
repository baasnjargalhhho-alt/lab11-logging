package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Програм эхэллээ...");

        // --- 5-р алхам: Мэдээллийг маскалах жишээ ---
        String sensitiveData = "card-1234-5678";
        logger.info("Хэрэглэгч системд нэвтэрлээ. ID: {}", mask(sensitiveData));

        // --- Алхам 2 & 2.1: BankAccount туршилт ---
        BankAccount myAccount = new BankAccount(1000.0);
        
        myAccount.deposit(500.0);    // INFO, DEBUG, TRACE түвшний лог гарна
        myAccount.deposit(-10.0);    // WARN түвшний лог гарна
        myAccount.withdraw(2000.0);  // ERROR түвшний лог гарна (үлдэгдэл хүрэхгүй)
        myAccount.simulateFatalError(); // FATAL түвшний лог гарна

        // --- Алхам 3: Customer Debug (NullPointerException-ийг шалгах) ---
        // Имэйл нь null байх үед алдааг хэрхэн барьж буйг шалгана
        Customer c1 = new Customer("Bat", null); 
        logger.info("Customer-ийн домэйн: {}", c1.getDomain());

        logger.info("Програм амжилттай ажиллаж дууслаа.");
    }

    // Алхам 5: Нууц мэдээллийг маскалах функц
    private static String mask(String s) {
        if (s == null || s.length() < 4) return "***";
        return s.substring(0, 2) + "***" + s.substring(s.length() - 2);
    }
}