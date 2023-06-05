package com.icarus.adaicarus;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    private static final Logger logger = LoggerFactory.getLogger(Log.class);

    
    public String getLoogger() {
        logger.info("Essa é minha primeira log");
        logger.info("O Spring Boot está sem erros");

          return "essas são as logs";
    
}}