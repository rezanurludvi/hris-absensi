package com.hris.absen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
@Setter
@Getter
@NoArgsConstructor
public class Employee extends BaseEntity<Employee>{


    private static final long serialVersionUID = -2410232014340204706L;

    public enum StatusEmployee{
        PRESENT,
        UNPRESENT
    }

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "nip", columnDefinition = "VARCHAR(255)")
    private String nip;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

//    @Column(name = "employee_date")
//    @Temporal(TemporalType.DATE)
//    private Date employeeDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEmployee status = StatusEmployee.UNPRESENT;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
