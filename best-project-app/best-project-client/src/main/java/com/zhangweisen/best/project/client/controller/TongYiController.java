package com.zhangweisen.best.project.client.controller;

import com.zhangweisen.best.project.integration.tongyi.service.TongYiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tongyi")
public class TongYiController {

    @Autowired
    private TongYiService tongYiService;

    @GetMapping("/simple")
    public String completion(
            @RequestParam(value = "message", defaultValue = "AI时代下Java开发者该何去何从？")
            String message
    ) {
        return tongYiService.completion(message);
    }

    @GetMapping("/image")
    public String image(
            @RequestParam(value = "message", defaultValue = "《we bare bear》")
            String message
    ) {
        return tongYiService.genImg(message).getResult().getOutput().getUrl();
    }
}