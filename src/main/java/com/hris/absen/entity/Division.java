package com.hris.absen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "division")
@Setter
@Getter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE division set deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Division extends BaseEntity<Division>{


    private static final long serialVersionUID = 5241687673548144895L;
    @Column(name = "name")
    private String name;

    @Column(name = "note")
    private String note;
}
