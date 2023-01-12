package com.reinaldompadua.myAWSapp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reinaldompadua.myAWSapp.entities.abstractEntities.GenericEntitie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter

public class Music extends GenericEntitie {

    public Music(){
        super();
    }
    public Music(String name, String album){
        this.name = name;
        this.album = album;
    }


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    private String album;

   @OneToMany(mappedBy = "music")
   @JsonManagedReference
   private Set<Version> versions;
//
    @ManyToOne
    private Style style;

}
