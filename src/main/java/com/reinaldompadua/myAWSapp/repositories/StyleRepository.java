package com.reinaldompadua.myAWSapp.repositories;

import com.reinaldompadua.myAWSapp.entities.Music;
import com.reinaldompadua.myAWSapp.entities.Style;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends CrudRepository<Style, String> {

    public Style findById(Long id);

}
