package com.pskwiercz.ticketmanagement.controller;

import com.pskwiercz.ticketmanagement.service.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class HomeController {

    final SecurityService securityService;

    public HomeController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @ResponseBody
    @GetMapping("/security/generate/token")
    public Map<String, Object> generateToken(@RequestParam(value="subject") String subject){
        String token = securityService.createToken(subject, (2 * 1000 * 60));
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", token);
        return map;
    }

    @ResponseBody
    @GetMapping("/security/get/subject")
    public Map<String, Object> getSubject(@RequestParam(value="token") String token){
        String subject = securityService.getSubject(token);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", subject);
        return map;
    }
}
