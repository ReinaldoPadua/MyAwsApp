package com.reinaldompadua.myAWSapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class MusicController {

    @GetMapping("/musics/")
    public String musics() {

        return "music/music_view";
    }

    @GetMapping("/musics/{musicId}")
    public String musicDetail() {

        return "music/music_detail_view";
    }

}
