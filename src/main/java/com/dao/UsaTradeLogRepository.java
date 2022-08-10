package com.dao;

import com.pojo.entity.UsaTradeLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsaTradeLogRepository extends JpaRepository<UsaTradeLogEntity, Integer> {
    List<UsaTradeLogEntity> findByStockId(String stockId);
}
