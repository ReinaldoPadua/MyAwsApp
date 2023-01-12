package com.reinaldompadua.myAWSapp.repositories;

import com.reinaldompadua.myAWSapp.entities.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MusicRepository extends CrudRepository<Music, String> {
    public Music findById(Long id);
    public List<Music> findAll();
}
