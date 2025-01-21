package application;

import adapters.EmailSenderGateway;
import core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

private final EmailSenderGateway emailSenderGateway; //Aqui eu importo a interface EmailSenderGateway para a metodo emailSenderGateway

  @Autowired//Constructor
    public EmailSenderService(EmailSenderGateway emailGateway){ //aqui eu crio metodo construtor q vai receber o valor na variavel emailGateway e seto ela  no metodo q eu importei
    this.emailSenderGateway = emailGateway;
  }


    @Override
    public void sendEmail(String to, String subject, String body) {
    this.emailSenderGateway.sendEmail(to,subject,body);
    }
}
