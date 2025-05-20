package net.modi.journalApp.service;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    @Disabled
    void testSendMail()
    {
        emailService.sendMail("suyashmodi1000@gmail.com","Hello","Aap Kaise hoo");
    }
}
