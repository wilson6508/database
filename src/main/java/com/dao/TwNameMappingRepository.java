package com.dao;

import com.pojo.entity.TwNameMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TwNameMappingRepository extends JpaRepository<TwNameMappingEntity, Integer> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE tw_name_mapping", nativeQuery = true)
    void truncateTwNameMapping();

}
