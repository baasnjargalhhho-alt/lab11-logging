package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Customer {
    private static final Logger logger = LogManager.getLogger(Customer.class);
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getDomain() {
        logger.trace("Entering getDomain() for customer: {}", name);
        try {
            // DEBUG: Имэйл утгыг шалгах
            logger.debug("Attempting to extract domain from email: {}", email);
            
            if (email == null) {
                logger.warn("Email is null for customer: {}. Potential NullPointerException averted.", name);
                return "UNKNOWN";
            }

            String domain = email.substring(email.indexOf("@") + 1).toUpperCase();
            logger.debug("Successfully extracted domain: {}", domain);
            return domain;
            
        } catch (Exception e) {
            logger.error("Error in getDomain() for customer {}: {}", name, e.getMessage());
            return "ERROR";
        } finally {
            logger.trace("Exiting getDomain()");
        }
    }
}