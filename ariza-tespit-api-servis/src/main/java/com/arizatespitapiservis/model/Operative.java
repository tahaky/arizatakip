package com.arizatespitapiservis.model;


import com.arizatespitapiservis.enums.EnumTask;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "operative")
public class Operative extends BaseKisi {

    @Column(name = "task",length = 50)
    @Enumerated(EnumType.STRING)
    private EnumTask enumTask;

    @OneToMany
    @JoinTable(
            name = "operative_faults",
            joinColumns = {@JoinColumn(
                    foreignKey = @ForeignKey(name = "operative_fk2"),
                    name = "operative_id")},
            inverseJoinColumns = {@JoinColumn(foreignKey = @ForeignKey(name = "fault_fk2"), name = "fault_id")}
    )
    private List<Fault> fault;

}
