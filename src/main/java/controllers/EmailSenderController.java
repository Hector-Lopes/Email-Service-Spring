package controllers;

import application.EmailSenderService;
import core.EmailRequest;
import core.execepitions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired//Constructor
    public  EmailSenderController (EmailSenderService emailSenderService){
        this.emailSenderService= emailSenderService;

    }

@PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try{
            this.emailSenderService.sendEmail(request.to(),request.subject(), request.body());// chamando o metodo e passando os valores como se fosse um função
            return ResponseEntity.ok("Email send successfully");
        }catch (EmailServiceException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }

}

}
