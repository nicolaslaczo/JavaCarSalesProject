package com.application.CarMasters.config;

import com.application.CarMasters.entity.Vehicle;
import io.micrometer.common.util.StringUtils;
import org.modelmapper.internal.bytebuddy.dynamic.scaffold.MethodRegistry;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class VehicleSpecification {

    public static Specification<Vehicle> filterVehicle(String maker, String model, Integer sellPrice) {
        return (root, query, criteriaBuilder) -> {
            Predicate makerPredicate = StringUtils.isBlank(maker) ? criteriaBuilder.conjunction() :
                    criteriaBuilder.like(root.get("maker"), likePattern(maker));

            Predicate modelPredicate = StringUtils.isBlank(model) ? criteriaBuilder.conjunction() :
                    criteriaBuilder.like(root.get("model"), likePattern(model));

            Predicate sellPricePredicate = sellPrice == null ? criteriaBuilder.conjunction() :
                    criteriaBuilder.equal(root.get("sellPrice"), sellPrice);

            return criteriaBuilder.and(makerPredicate, modelPredicate, sellPricePredicate);
        };
    }

    public static Specification<Vehicle> searchVehicle(String search) {
        return (root, query, criteriaBuilder) -> {
            Predicate makerPredicate = criteriaBuilder.like(root.get("maker"), likePattern(search));
            Predicate modelPredicate = criteriaBuilder.like(root.get("model"), likePattern(search));
            return criteriaBuilder.or(makerPredicate, modelPredicate);
        };
    }






    private static String likePattern(String value) {
        return "%" + value + "%";
    }
}
