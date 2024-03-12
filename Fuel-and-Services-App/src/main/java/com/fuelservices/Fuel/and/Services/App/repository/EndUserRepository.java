package com.fuelservices.Fuel.and.Services.App.repository;


import com.fuelservices.Fuel.and.Services.App.entity.EndUserEntity;
import com.fuelservices.Fuel.and.Services.App.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndUserRepository extends JpaRepository<EndUserEntity, Long> {

    //@Query("SELECT a from #{#entityName} a WHERE userEntity = :userId")
    EndUserEntity findByUserEntity(UserEntity userId);
}
