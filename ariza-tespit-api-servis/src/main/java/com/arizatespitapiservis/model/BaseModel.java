package com.arizatespitapiservis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = -6618481323090767038L;

    @Id
    @GeneratedValue
    @Column(name = "id",insertable = false)
    private UUID id;

    @CreatedBy
    @Column(name = "created_by",nullable = false,length = 50,updatable = false)
    @JsonIgnore
    private String createdBy;

    @CreatedDate
    @Column(name = "create_date",updatable = false)
    @JsonIgnore
    private String creteDate;

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    @JsonIgnore
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    private Instant lastModifiedDate = Instant.now();

    @Transient
    private Kullanici createUser;

    @Transient
    private Kullanici changeUser;


}
