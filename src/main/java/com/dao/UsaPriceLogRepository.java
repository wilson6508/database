package com.dao;

import com.pojo.entity.UsaPriceLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsaPriceLogRepository extends JpaRepository<UsaPriceLogEntity, Integer> {
    List<UsaPriceLogEntity> findByStockId(String stockId);
    List<UsaPriceLogEntity> findByDateEndsWith(String date);
    List<UsaPriceLogEntity> findByStockIdAndDateEndsWith(String stockId, String date);
}
