package com.hris.absen.dao;

import com.hris.absen.entity.Attendance;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AttendanceDAO extends BaseDAO<Attendance> {
    @Override
    public List<Predicate> predicates(Attendance param, CriteriaBuilder builder, Root<Attendance> root, boolean isCount) {
        List<Predicate> predicates = super.predicates(param, builder, root, isCount);
//
//        if (param != null){
//            if (param.getStartTime() != null){
//                predicates.add(builder.equal(root.get("status"), param.getStartTime()));
//            }
//        }
//
        if (!isCount){
            root.fetch("employee", JoinType.INNER);
       }
        return predicates;
    }
}
