package com.pingan.demo.controller;

import com.pingan.demo.Demo1Application;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author TANGJIAN
 * @since 2018/5/21
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage){
        return acceptLanguage;
    }

    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue(value = "JSESSIONID",required = false) String jsessionId){
        return jsessionId;
    }

    @ModelAttribute("message")
    public String message(){
        return "Hello,World";
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable) {
        return ResponseEntity.ok(throwable.getMessage());
    }

}
