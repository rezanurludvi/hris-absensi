package com.hris.absen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "attendance")
@Setter
@Getter
@NoArgsConstructor
public class Attendance extends BaseEntity<Attendance>{


    private static final long serialVersionUID = 583148930261526653L;

    @Column(name = "note")
    private String note;

    @Column(name = "project_name", columnDefinition = "VARCHAR(100)")
    private String projectName;

    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(name = "attendance_date")
    @Temporal(TemporalType.DATE)
    private Date attendanceDate;/*utils percobaan*/

    @Column(name = "rest_end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date restEndTime;

    @Column(name = "rest_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date restStartTime;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    public Attendance(String projectName){
        this.projectName = projectName;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
