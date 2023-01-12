package com.reinaldompadua.myAWSapp.repositories;

import com.reinaldompadua.myAWSapp.entities.Music;
import com.reinaldompadua.myAWSapp.entities.Version;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepository extends CrudRepository<Version, Long> {
}
