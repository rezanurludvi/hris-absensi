package com.hris.absen.dao;

import com.hris.absen.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAO extends BaseDAO<User> {
    @Override
    public List<Predicate> predicates(User param, CriteriaBuilder builder, Root<User> root, boolean isCount) {
        List<Predicate> predicates = super.predicates(param, builder, root, isCount);

        if (param != null){
            if (param.getUsername() != null){
                predicates.add(builder.equal(root.get("username"), param.getUsername()));
            }
        }

        if (!isCount){
            root.fetch("division", JoinType.INNER);
            root.fetch("company", JoinType.INNER);
            root.fetch("position", JoinType.INNER);
            root.fetch("bank", JoinType.INNER);
        }

        return predicates;
    }
}
