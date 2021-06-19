package com.dailycodebuffer.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
//  kafka msg is string by default
    KafkaTemplate<String,String> kafkaTemplate;
    private static final String TOPIC="NewTopic";
    @GetMapping("/publish/{msg}")
    public String publishMsg(@PathVariable("msg") final String msg){
        kafkaTemplate.send(TOPIC,msg);
        return "Published Successfully";
    }
}
