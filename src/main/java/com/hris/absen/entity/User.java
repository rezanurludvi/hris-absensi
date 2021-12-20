package com.hris.absen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity<User>{

    private static final long serialVersionUID = 5595258507442529383L;

    public enum Role{
        ROLE_USER,
        ROLE_ADMIN
    }

//  Tabel Delete
//  Tabel Active

    @Column(name = "role", columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    @Column(name = "date_of_birth", columnDefinition = "DATETIME", nullable = false)
    private String dateOfBirth;

    @Column(name = "domicile_address", columnDefinition = "VARCHAR(255)", nullable = false)
    private String domicileAddress;

    @Column(name = "pendidikan_terakhir", columnDefinition = "VARCHAR(255)", nullable = false)
    private String pendidikanTerakhir;

    @Column(name = "marital_status", columnDefinition = "VARCHAR(255)", nullable = false)
    private String maritaStatus;

    @Column(name = "nama_ibu", columnDefinition = "VARCHAR(255)", nullable = false)
    private String namaIbu;

    @Column(name = "nick_name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String nickName;

    @Column(name = "pendidikan_terakhir", columnDefinition = "VARCHAR(255)", nullable = false)
    private String PendidikanTerakhir;

    @Column(name = "no_bpjs_ketenagakerjaan", columnDefinition = "VARCHAR(255)", nullable = false)
    private String noBpjsketenagakerjaan;

    @Column(name = "no_bpjs_kesehatan", columnDefinition = "VARCHAR(255)", nullable = false)
    private String noBpjsKesehatan;

    @Column(name = "no_ktp", columnDefinition = "VARCHAR(255)", nullable = false)
    private String noKtp;

    @Column(name = "npwp", columnDefinition = "VARCHAR(255)", nullable = false)
    private String npwp;

    @Column(name = "no_rekening", columnDefinition = "VARCHAR(255)")
    private String noRekening;

    @Column(name = "phone", columnDefinition = "VARCHAR(255)", nullable = false)
    private String phone;

    @Column(name = "place_of_birth", columnDefinition = "VARCHAR(255)", nullable = false)
    private String placeOfBirth;

    @Column(name = "profile_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String profileName;

    @Column(name = "religion", columnDefinition = "VARCHAR(255)", nullable = false)
    private String religion;

    @Column(name = "residence_address", columnDefinition = "VARCHAR(255)", nullable = false)
    private String residenceAddress;

    @Column(name = "username", columnDefinition = "VARCHAR(50)", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;


}