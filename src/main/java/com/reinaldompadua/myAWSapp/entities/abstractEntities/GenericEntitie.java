package com.reinaldompadua.myAWSapp.entities.abstractEntities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class GenericEntitie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
}
