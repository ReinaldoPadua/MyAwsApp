package com.reinaldompadua.myAWSapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.reinaldompadua.myAWSapp.entities.abstractEntities.GenericEntitie;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Version extends GenericEntitie {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "music_id", nullable = false)
    @JsonBackReference
    private Music music;

    private String label;
}
