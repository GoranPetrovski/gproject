package com.gproject.demo.repository.specification;

import com.gproject.demo.domain.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification implements Specification<Product> {
    private ProductSearchCriteria criteria;

    public ProductSpecification(ProductSearchCriteria searchCriteria) {
        criteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query,
                                 CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList();

        ingredient(root, query, builder, predicates);
        return builder.and(predicates.toArray(new Predicate[0]));
    }



    private void ingredient(Root<Product> root, CriteriaQuery<?> query,
                         CriteriaBuilder builder, List<Predicate> predicates) {
        if (criteria.ingredientName != null)
            predicates.add(builder.equal(root.join("ingredients").get("name"),
                    criteria.ingredientName));
    }

}