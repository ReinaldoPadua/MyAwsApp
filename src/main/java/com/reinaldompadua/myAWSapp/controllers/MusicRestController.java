package com.reinaldompadua.myAWSapp.controllers;

import com.reinaldompadua.myAWSapp.entities.Music;
import com.reinaldompadua.myAWSapp.entities.Style;
import com.reinaldompadua.myAWSapp.entities.Version;
import com.reinaldompadua.myAWSapp.repositories.MusicRepository;
import com.reinaldompadua.myAWSapp.repositories.StyleRepository;
import com.reinaldompadua.myAWSapp.repositories.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/musics/")
public class MusicRestController {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private VersionRepository versionRepository;

    @Autowired
    private StyleRepository styleRepository;

    @GetMapping
    public List<Music> getMusics() throws Exception {
        return musicRepository.findAll();
    }

    @GetMapping("{id}")
    public Music getMusicById(@PathVariable("id") Long id) throws Exception {
        return musicRepository.findById(id);
    }

    @PostMapping
    public void createMusic(@RequestBody Music music,@RequestParam Long styleId) throws Exception{
        music.setStyle(styleRepository.findById(styleId));
        musicRepository.save(music);
    }


    @PostMapping("{id}/versions")
    public void getMusicVersionById(@PathVariable("id") Long id,@RequestBody Version version) throws Exception {
        version.setMusic(musicRepository.findById(id));
        versionRepository.save(version);
    }

    @GetMapping("/styles")
    public Iterable<Style> getStyles() throws Exception {
        return styleRepository.findAll();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNoRecordFoundException(Exception ex)
    {
        //TO DO: logar ex
        ErrorResponse errorResponse = new ErrorResponseException(HttpStatus.NOT_FOUND);
        return errorResponse;
    }

}
