package com.pcww.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DocController {
    @RequestMapping(value = "/docs", method = RequestMethod.GET)
    public String getDoc() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:http://localhost:8080/docs";
    }
}
