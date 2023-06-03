package com.arizatespitapiservis.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.util.Collection;


@Data
@Entity
@Table(name = "fault_images")
public class FaultImages extends BaseModel {

    @OneToOne(mappedBy = "fault")
    private Fault fault;

    @Lob
    @Column(name = "fault_images")
    private Collection<Blob> detailImages;

}
