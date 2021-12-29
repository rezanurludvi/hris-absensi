package com.hris.absen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "attendance")
@Setter
@Getter
@NoArgsConstructor
public class Attendance extends BaseEntity<Attendance>{


    private static final long serialVersionUID = 583148930261526653L;

    @Column(name = "note")
    private String note;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "end_time", columnDefinition = "TIME")
    private Time endTime;

    @Column(name = "attendance_date", columnDefinition = "DATE")
    private Date attendanceDate;

    @Column(name = "rest_end_time", columnDefinition = "TIME")
    private Time restEndTime;

    @Column(name = "rest_start_time", columnDefinition = "TIME")
    private Time restStartTime;

    @Column(name = "start_time", columnDefinition = "TIME")
    private Time startTime;

//    public void setAttendanceDate(java.util.Date date) {
//    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
