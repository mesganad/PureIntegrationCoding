package json.parse.jsonparsing;

import json.parse.jsonparsing.model.MessageObject;
import json.parse.jsonparsing.service.MessageObjectServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class JsonparsingApplicationTests {
    @Autowired
    private MessageObjectServiceImpl messageService;

    @Test
    public void getMessagesTest(){
        MessageObject messageObject=messageService.getMessageObject();
        assertNotNull(messageObject);
    }

}
