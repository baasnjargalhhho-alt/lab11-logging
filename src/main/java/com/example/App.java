package com.example;

// Хэрэгтэй сангуудыг импортлох
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Log4j 2 ашиглан лог хөтлөх жишээ програм
 */
public class App {
    
    // 1. Logger объектыг үүсгэх (Энэ класс доторх үйл явдлуудыг бүртгэнэ)
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        
        // Програм эхэлж байгааг мэдэгдэх (Info түвшин)
        logger.info("Програм амжилттай ажиллаж эхэллээ.");

        try {
            int result = divide(10, 2);
            // Үр дүнг бүртгэх
            logger.debug("Хуваах үйлдлийн үр дүн: {}", result);
            
            // Алдаа гаргаж турших (0-д хуваах)
            logger.info("Одоо 0-д хуваах үйлдэл хийж алдааг шалгана...");
            divide(10, 0);

        } catch (ArithmeticException e) {
            // 2. Алдаа гарсан үед 'error' түвшний лог хөтлөх
            logger.error("Тоог 0-д хувааж болохгүй: {}", e.getMessage());
        }

        // Програм дуусах хэсэг
        logger.warn("Програмын ажиллагаа дуусаж байна.");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}