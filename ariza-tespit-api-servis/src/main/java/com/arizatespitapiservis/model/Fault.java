package com.arizatespitapiservis.model;

import com.arizatespitapiservis.enums.EnumFaults;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Data
@Table(name = "fault")
public class Fault extends BaseModel {

    @Column(name = "fault_name")
    @Enumerated(EnumType.STRING)
    private EnumFaults fault;

    @OneToOne
    @Column(name = "fault_owner")
    private HomeOwner faultOwner;

    @Column(name = "last_fixed_date")
    private Date lastFixedDate;

    @Column(name = "description")
    private String description;

    @OneToOne
    @Column(name = "fault_images")
    private FaultImages faultImages;

    @Column(name = "Operative_responsible")
    @OneToOne
    private Opertaive responsible;


}
