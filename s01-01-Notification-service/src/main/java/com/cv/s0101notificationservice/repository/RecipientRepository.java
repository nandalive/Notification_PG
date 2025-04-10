package com.cv.s0101notificationservice.repository;

import com.cv.s0101notificationservice.entity.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<RecipientEntity,String>, JpaSpecificationExecutor<RecipientEntity> {
}
