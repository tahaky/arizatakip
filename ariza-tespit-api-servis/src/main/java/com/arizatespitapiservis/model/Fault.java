package com.arizatespitapiservis.model;

import com.arizatespitapiservis.enums.EnumFaults;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "fault")
public class Fault extends BaseModel {

    @Column(name = "fault_name", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private EnumFaults fault;

    @Column(name = "last_fixed_date", nullable = false)
    private Date lastFixedDate;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @OneToOne
    @JoinColumn(name = "home_owner_id", referencedColumnName = "id")
    private HomeOwner faultOwner;

    @Lob
    @Column(name = "fault_image")
    private byte[] detailImages1;
    @Lob
    @Column(name = "fault_image2")
    private byte[] detailImages2;
    @Lob
    @Column(name = "fault_image3")
    private byte[] detailImages3;





}
