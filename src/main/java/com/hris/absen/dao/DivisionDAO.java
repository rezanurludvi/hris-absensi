package com.hris.absen.dao;

import com.hris.absen.entity.Division;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DivisionDAO extends BaseDAO<Division> {
    @Override
    public List<Predicate> predicates(Division param, CriteriaBuilder builder, Root<Division> root, boolean isCount) {
        List<Predicate> predicates = super.predicates(param, builder, root, isCount);

//        pencarian berdasarkan parameter name
        if (param != null){
            if (param.getName() != null){
                predicates.add(builder.like(root.get("name"), "%" + param.getName() + "%"));
            }
        }

        return predicates;
    }
}
