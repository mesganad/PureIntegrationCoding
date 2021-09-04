package json.parse.jsonparsing.service;
import json.parse.jsonparsing.model.MessageObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageObjectServiceImpl implements MessageObjectService {
    MessageObject msgObject=new MessageObject();
    @Override
    public MessageObject addMessageObject(MessageObject messageObject){
        log.info("Inside addMessageObject() of MessageObjectServiceImpl");
        this.msgObject=messageObject;
        return messageObject;
    }
    @Override
    public MessageObject getMessageObject(){
        log.info("Inside getMessageObject() of MessageObjectServiceImpl");
        return msgObject;
    }
}
