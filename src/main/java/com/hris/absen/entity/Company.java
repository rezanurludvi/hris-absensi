package com.hris.absen.entity;

import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "company")
@Setter
@Getter
@Embeddable
@NoArgsConstructor
public class Company extends BaseEntity<Company>{

    private static final long serialVersionUID = 3984525037289296179L;

    @Column(name = "address", columnDefinition = "VARCHAR(100)", nullable = false)
    private String address;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(name = "phone", columnDefinition = "VARCHAR(30)")
    private String phone;
}
