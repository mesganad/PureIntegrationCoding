package json.parse.jsonparsing.controller;

import json.parse.jsonparsing.model.MessageObject;
import json.parse.jsonparsing.service.MessageObjectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageObjectController {
    @Autowired
    private MessageObjectServiceImpl messageObjectService;

    @PostMapping("/messageobjects")
    public ResponseEntity<?> addMessageObject(@RequestBody MessageObject messageObject){
        log.info("Inside addMessageObject() of MessageObjectController");
        MessageObject messageObj=messageObjectService.addMessageObject(messageObject);
        return ResponseEntity.ok(messageObj);
    }

    @GetMapping("//messageobjects")
    public ResponseEntity<?> getAllMessageObjects(){
        log.info("Inside getAllMessageObjects() of MessageObjectController");
        MessageObject obj=messageObjectService.getMessageObject();
        if(obj==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }
}
