package com.reinaldompadua.myAWSapp.controllers;

import com.reinaldompadua.myAWSapp.entities.Music;
import com.reinaldompadua.myAWSapp.entities.Style;
import com.reinaldompadua.myAWSapp.entities.Version;
import com.reinaldompadua.myAWSapp.repositories.MusicRepository;
import com.reinaldompadua.myAWSapp.repositories.StyleRepository;
import com.reinaldompadua.myAWSapp.repositories.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MusicRestController {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private VersionRepository versionRepository;

    @Autowired
    private StyleRepository styleRepository;

    @GetMapping("/musics")
    public List<Music> getMusics() {
        return musicRepository.findAll();
    }

    @GetMapping("/musics/{id}")
    public Music getMusicById(@PathVariable("id") Long id) {
        return musicRepository.findById(id);
    }

    @PostMapping("/musics")
    public void createMusic(@RequestBody Music music,@RequestParam Long styleId){
        music.setStyle(styleRepository.findById(styleId));
        musicRepository.save(music);
    }


    @PostMapping("/musics/{id}/versions")
    public void getMusicVersionById(@PathVariable("id") Long id,@RequestBody Version version) {
        version.setMusic(musicRepository.findById(id));
        versionRepository.save(version);
    }

    @GetMapping("/styles")
    public Iterable<Style> getStyles() {
        return styleRepository.findAll();
    }

}
