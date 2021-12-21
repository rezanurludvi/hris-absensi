package com.hris.absen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "postiton")
@Setter
@Getter
@NoArgsConstructor
public class Position extends BaseEntity<Position> {

    private static final long serialVersionUID = 3318010391634048323L;

    @Column(name = "name")
    private String name;

    @Column(name = "note")
    private String note;
}
