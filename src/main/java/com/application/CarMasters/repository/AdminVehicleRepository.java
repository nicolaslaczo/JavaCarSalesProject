package com.application.CarMasters.repository;

import com.application.CarMasters.entity.Vehicle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminVehicleRepository extends JpaRepository<Vehicle,Integer>, JpaSpecificationExecutor<Vehicle> {

    Vehicle findByVin(String vin);

    List<Vehicle> findByMaker(String maker);

    List<Vehicle> findAll(Specification<Vehicle> specification);


}
