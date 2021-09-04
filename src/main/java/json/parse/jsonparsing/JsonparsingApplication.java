package json.parse.jsonparsing;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.parse.jsonparsing.model.MessageObject;
import json.parse.jsonparsing.service.MessageObjectServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JsonparsingApplication {
    public static void main(String[] args) {
        SpringApplication.run(JsonparsingApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(MessageObjectServiceImpl messageObjectService){
        return args -> {
            //read json and write to db
            ObjectMapper mapper = new ObjectMapper();
             TypeReference<Map<String,List<String>>> typeReference = new TypeReference<Map<String,List<String>>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/messages.json");
            try {
                System.out.println("Inside try-catch");
                Map<String,List<String>> messages = mapper.readValue(inputStream, typeReference);
                MessageObject messageObject=new MessageObject();
                messageObject.setMessage(messages);
                messageObject.setStatus("success");
                messageObjectService.addMessageObject(messageObject);
            }catch (Exception e){
                System.out.println("Unable to save users "+e.getMessage());
            }
        };
    }
}
