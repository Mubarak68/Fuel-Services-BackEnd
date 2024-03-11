package com.fuelservices.Fuel.and.Services.App.repository;

import com.fuelservices.Fuel.and.Services.App.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {

}
