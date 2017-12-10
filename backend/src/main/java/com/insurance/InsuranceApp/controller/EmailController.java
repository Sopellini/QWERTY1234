package com.insurance.InsuranceApp.controller;

import com.insurance.InsuranceApp.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
@RequestMapping("/api")
public class EmailController {
    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailSender emailSender, TemplateEngine templateEngine){
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @RequestMapping("/sendEmail")
    public void send() {
        Context context = new Context();
        context.setVariable("header", "Najlepsze życzenia");
        context.setVariable("title", "Wszystkiego najlepszego z okazji urodzin");
        context.setVariable("description", "Jakieś przykładowe życzenia urodzinowe.");

        String body = templateEngine.process("template", context);
        emailSender.sendEmail("ktestowe997@gmail.com", "Życzenia urodzinowe", body);
    }
}
