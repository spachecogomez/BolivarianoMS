/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.modval.bolivarianoms.message.processing;

import co.edu.javeriana.aes.modval.bolivarianoms.model.MensajeBolivariano;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author sebastianpacheco
 */
@Component
public class BolivarianoProcessor {
    
    private Logger log = LogManager.getLogger(MessageListener.class);
    
    PrintWriter pw;
    
    FileOutputStream fos;
    
    @Value("${bolivariano.file.base.name}")
    private String fileBaseName;
    
    private final String FILE_EXTENSION = ".csv";
    
    public void processBolivarianoRow(MensajeBolivariano mensajeBolivariano){
        try {
            log.info("Processing a new bolivariano ticket");
            File outputRow = new File(fileBaseName.concat(mensajeBolivariano.getOrderId()).concat(FILE_EXTENSION));
            fos = new FileOutputStream(outputRow);
            pw = new PrintWriter(fos);
            String message = String.format("%s,%s,%s,%s,%s,", 
                    mensajeBolivariano.getApellido()
                    ,mensajeBolivariano.getNombre()
                    ,mensajeBolivariano.getFechaSalida()
                    ,mensajeBolivariano.getNumViaje()
                    ,mensajeBolivariano.getNumSilla());
            pw.write(message);
            pw.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            log.error("Couldn't create the file for the message.",ex);
        } catch (IOException ex) {
            log.error("Couldn't write to the file.",ex);
        }
    }
    
}
