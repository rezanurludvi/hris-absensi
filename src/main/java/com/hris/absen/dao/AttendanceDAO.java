package com.hris.absen.dao;

import com.hris.absen.entity.Attendance;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Repository
public class AttendanceDAO extends BaseDAO<Attendance> {

    @Override
    public List<Predicate> predicates(Attendance param, CriteriaBuilder builder, Root<Attendance> root, boolean isCount) {
        List<Predicate> predicates = super.predicates(param, builder, root, isCount);


//        if (param != null){
//            if (param.getStartTime() != null){
//                predicates.add(builder.equal(root.get("status"), param.getStartTime()));
//            }
//        }

//        if (param != null){
//            if (param.getProjectName() != null){
//                predicates.add(builder.equal(root.get("projectName"), param.getProjectName()));
//            }
//        }

        if (param != null){
            if (param.getAttendanceDate() != null){
                predicates.add(builder.equal(root.get("attendanceDate"), param.getAttendanceDate()));
            }
        }

//        if (param != null){
//            if (param.getEmployee().getStatus() != null) {
//                if (param.getStartTime() != null) {
//                    predicates.add(builder.equal(root.get("status"), param.getEmployee().getStatus()));
//                }
//            }
//        }

        if (!isCount){
            root.fetch("employee", JoinType.INNER);
       }
        return predicates;
    }


    public List<Attendance> findByTime(Attendance param, Date startTime, Date endTime) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Attendance> query = builder.createQuery(Attendance.class);

        Root<Attendance> root = query.from(Attendance.class);

        if (param != null){
            if (param.getEmployee() != null){
                query.where(builder.equal(root.get("employee").get("id"), param.getEmployee().getId()));
            }
        }

        query.where(builder.between(root.get("attendanceDate"), startTime, endTime));

        query.orderBy(builder.asc(root.get("id")));

        root.fetch("employee", JoinType.INNER);
        root.fetch("user", JoinType.INNER);

        TypedQuery<Attendance> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }
}
