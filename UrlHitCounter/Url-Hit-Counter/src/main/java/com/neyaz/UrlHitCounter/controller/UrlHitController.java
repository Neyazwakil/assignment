package com.neyaz.UrlHitCounter.controller;


import com.neyaz.UrlHitCounter.controller.UrlHitController;
import com.neyaz.UrlHitCounter.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController

public class UrlHitController {
    private final UrlHitService urlHitService;

    public UrlHitController(UrlHitService urlHitService) {
        this.urlHitService = urlHitService;
    }

    @GetMapping("count")
    public int getHitCount() {
        return urlHitService.incrementHitCount();
    }

    @GetMapping("username/{username}/count")
    public String getUserHitCount(@PathVariable String username) {
        Integer temp = urlHitService.getUserHitCounter(username);

        String s = username+" " + "HitCount"+":"+ temp;
        return "{Username"+":"+s+"}" ;
    }
}


