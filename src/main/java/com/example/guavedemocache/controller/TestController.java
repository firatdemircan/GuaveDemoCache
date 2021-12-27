package com.example.guavedemocache.controller;

import com.example.guavedemocache.util.SharedService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/test")
public class TestController {

    private final SharedService sharedService;

    public TestController(SharedService sharedService) {
        this.sharedService = sharedService;
    }

    @PostMapping("create")
    public UUID test(){

        UUID uuid = sharedService.generateCache();

        return uuid ;
    }

    @GetMapping("/bring/{uuid}")
    public String getCache(@PathVariable UUID uuid){
        String cache = sharedService.getCache(uuid);
        return cache;
    }


}
