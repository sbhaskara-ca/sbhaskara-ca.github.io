package com.connectall.adapter.zabbix.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.connectall.adapter.zabbix.bean.ZabbixEvent;

@RestController
@RequestMapping(value = "/zabbix")
public class ZabbixController {
	private Logger log = LogManager.getLogger(ZabbixController.class);
	
	
	@RequestMapping(value = "/postevent", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> greetingText(@RequestBody ZabbixEvent event) {
		log.info("Event received"+event);
		triggerCAEvent(event);
		return new ResponseEntity<>("Event captured, and sent to ConnectALL", HttpStatus.OK);
    }


	private void triggerCAEvent(ZabbixEvent event) {
		
		
	}

}
