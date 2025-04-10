package com.cv.s0101notificationservice.repository;

import com.cv.s0101notificationservice.entity.GeneralNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralNotificationRepository extends JpaRepository<GeneralNotification,String>,JpaSpecificationExecutor<GeneralNotification>{
}


