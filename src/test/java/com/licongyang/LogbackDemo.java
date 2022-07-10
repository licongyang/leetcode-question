package com.licongyang;


import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Slf4j
public class LogbackDemo {

//    private static Logger logger = LoggerFactory.getLogger(LogbackDemo.class);


    public static void main(String[] args) {
//        logger.trace("====== trace");
//        logger.debug("====== debug");
//        logger.info("====== info");
//        logger.warn("====== warn");
//        logger.error("====== error");
        log.trace("====== trace");
        log.debug("====== debug");
        log.info("====== info");
        log.warn("====== warn");
        log.error("====== error");

    }
}