package com.service.stock;

import com.dao.TwNameMappingRepository;
import com.dao.TwTradeLogRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pojo.dto.DatabaseApiResponseBean;
import com.pojo.entity.TwNameMappingEntity;
import com.pojo.entity.TwTradeLogEntity;
import com.tool.ObjectTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class TwStockService {

    private final Gson gson = new Gson();
    @Autowired
    private ObjectTool objectTool;
    @Autowired
    private TwTradeLogRepository twTradeLogRepository;
    @Autowired
    private TwNameMappingRepository twNameMappingRepository;

    public DatabaseApiResponseBean readTwNameMapping() {
        DatabaseApiResponseBean responseBean = objectTool.getErrorRep();
        try {
            List<TwNameMappingEntity> list = twNameMappingRepository.findAll();
            responseBean = objectTool.getSuccessRep();
            responseBean.setResult(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBean;
    }

    public DatabaseApiResponseBean updateTwNameMapping(Object parameter) {
        DatabaseApiResponseBean responseBean = objectTool.getErrorRep();
        try {
            twNameMappingRepository.truncateTwNameMapping();
            Type type = new TypeToken<List<TwNameMappingEntity>>() {}.getType();
            List<TwNameMappingEntity> list = gson.fromJson(gson.toJson(parameter), type);
            twNameMappingRepository.saveAll(list);
            responseBean = objectTool.getSuccessRep();
            responseBean.setResult(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBean;
    }

    public DatabaseApiResponseBean createTwTradeLog(Object parameter) {
        DatabaseApiResponseBean responseBean = objectTool.getErrorRep();
        try {
            Type type = new TypeToken<ArrayList<TwTradeLogEntity>>() {
            }.getType();
            List<TwTradeLogEntity> list = gson.fromJson(gson.toJson(parameter), type);
            twTradeLogRepository.saveAll(list);
            responseBean = objectTool.getSuccessRep();
            responseBean.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBean;
    }

}
