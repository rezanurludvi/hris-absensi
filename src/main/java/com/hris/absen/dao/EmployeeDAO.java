package com.hris.absen.dao;

import com.hris.absen.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeDAO extends BaseDAO<Employee> {
    @Override
    public List<Predicate> predicates(Employee param, CriteriaBuilder builder, Root<Employee> root, boolean isCount) {
        List<Predicate> predicates = super.predicates(param, builder, root, isCount);

    if (param != null) {
        if (param.getStatus() != null) {
            predicates.add(builder.equal(root.get("status"), param.getStatus()));
        }
    }

        if (!isCount) {
            root.fetch("user", JoinType.INNER);
        }
            return predicates;
    }

    public List<Employee> findByDate(Employee param, Date startDate, Date endDate){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);

        Root<Employee> root = query.from(Employee.class);

        if (param != null){
            if (param.getUser() != null){
                query.where(builder.equal(root.get("user").get("id"), param.getUser().getId()));
            }
        }

        query.where(builder.between(root.get("employeeDate"), startDate, endDate));/*perbaiki*/

        query.orderBy(builder.asc(root.get("id")));

        root.fetch("user", JoinType.INNER);

        TypedQuery<Employee> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }
}

