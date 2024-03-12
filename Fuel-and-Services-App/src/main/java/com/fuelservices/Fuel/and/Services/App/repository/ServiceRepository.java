package com.fuelservices.Fuel.and.Services.App.repository;

import com.fuelservices.Fuel.and.Services.App.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository  extends JpaRepository<ServiceEntity, Long> {
}
