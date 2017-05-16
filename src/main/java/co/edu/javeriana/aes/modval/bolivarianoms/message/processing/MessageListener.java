package co.edu.javeriana.aes.modval.bolivarianoms.message.processing;

import co.edu.javeriana.aes.modval.bolivarianoms.model.MensajeBolivariano;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    
    private Logger log = LogManager.getLogger(MessageListener.class);
    
    @Value("${bolivariano.write.queue}")
    private String destinationQueue;
    
    @Autowired
    private BolivarianoProcessor processor;
    
    @Autowired
    RabbitMessagingTemplate rabbitMessagingTemplate;
    
    @RabbitListener(queues = "#{'${bolivariano.read.queue}'}")
    public void processMessage(Message content) {
        String message = new String(content.getBody());
        log.debug(String.format("Received the message [%s]", message));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Gson gson = new Gson();
        processor.processBolivarianoRow(gson.fromJson(message, MensajeBolivariano.class));
        rabbitMessagingTemplate.convertAndSend(destinationQueue, 
                "this is a test"+sdf.format(new Date()));
    }

}