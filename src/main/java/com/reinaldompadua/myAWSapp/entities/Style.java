package com.reinaldompadua.myAWSapp.entities;

import com.reinaldompadua.myAWSapp.entities.abstractEntities.GenericEntitie;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Style extends GenericEntitie {

    private String name;

    public Style(){
        super();
    }

    public Style(Long id, String name){
        this.setId(id);
        this.setName(name);
    }
}
