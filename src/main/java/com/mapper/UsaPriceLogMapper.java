package com.mapper;

import com.pojo.entity.UsaPriceLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsaPriceLogMapper {

    @Select("SELECT * FROM usa_price_log WHERE id = #{id}")
    UsaPriceLogEntity getEntityById(Integer id);

    @Select("SELECT * FROM usa_price_log WHERE stock_id = #{stockId}")
    List<UsaPriceLogEntity> getEntityListByStockId(String stockId);

    @Select("SELECT stock_id, COUNT(1) amount FROM usa_price_log GROUP BY stock_id")
    List<Count> getCountList();

//    @Insert("INSERT INTO tw_name_mapping(stock_id, stock_name, price) VALUES(#{stockId}, #{stockName}, #{price})")
//    public void createTwNameMapping(TwNameMapping twNameMapping);
//
//    @Update("UPDATE tw_name_mapping SET stock_id = #{stockId}, stock_name = #{stockName}, price = #{price} WHERE id = #{id}")
//    public void updateTwNameMapping(TwNameMapping twNameMapping);
//
//    @Delete("DELETE FROM tw_name_mapping WHERE id = #{id}")
//    public void deleteTwNameMappingById(Integer id);
}
