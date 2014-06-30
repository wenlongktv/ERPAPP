package com.xwl.emmobile.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gift")
public class GiftController
{
	private Logger  logger = Logger.getLogger(this.getClass());
	
	@RequestMapping
    public String index()
    {
        this.logger.info("Gift index");
        return "giftMgt/giftMgt";
    }
	
	@RequestMapping("/adder")
    public String giftRole()
    {
        this.logger.info("Gift Role");
        return "giftMgt/addGiftRole";
    }
}
