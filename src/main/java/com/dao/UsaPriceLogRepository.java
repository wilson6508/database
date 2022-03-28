package com.dao;

import com.pojo.entity.UsaPriceLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsaPriceLogRepository extends JpaRepository<UsaPriceLogEntity, Integer> {

    Optional<UsaPriceLogEntity> findFirstByOrderByDateDesc();

}
