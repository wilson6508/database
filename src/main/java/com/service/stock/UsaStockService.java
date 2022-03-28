package com.service.stock;

import com.dao.UsaPriceLogRepository;
import com.dao.UsaTradeLogRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pojo.dto.DatabaseApiResponseBean;
import com.pojo.entity.UsaPriceLogEntity;
import com.pojo.entity.UsaTradeLogEntity;
import com.tool.ObjectTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsaStockService {

    private final Gson gson = new Gson();
    @Autowired
    private ObjectTool objectTool;
    @Autowired
    private UsaPriceLogRepository usaPriceLogRepository;
    @Autowired
    private UsaTradeLogRepository usaTradeLogRepository;

    public DatabaseApiResponseBean createUsaPriceLog(Object parameter) {
        DatabaseApiResponseBean responseBean = objectTool.getErrorRep();
        Type type = new TypeToken<ArrayList<UsaPriceLogEntity>>() {}.getType();
        try {
            List<UsaPriceLogEntity> list = gson.fromJson(gson.toJson(parameter), type);
            usaPriceLogRepository.saveAll(list);
            responseBean = objectTool.getSuccessRep();
            responseBean.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBean;
    }

    public DatabaseApiResponseBean readUsaPriceLog() {
        DatabaseApiResponseBean responseBean = objectTool.getErrorRep();
        try {
            List<UsaPriceLogEntity> list = usaPriceLogRepository.findAll();
            responseBean = objectTool.getSuccessRep();
            responseBean.setResult(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBean;
    }

    public DatabaseApiResponseBean createUsaTradeLog(Object parameter) {
        DatabaseApiResponseBean responseBean = objectTool.getErrorRep();
        try {
            Type type = new TypeToken<ArrayList<UsaTradeLogEntity>>() {}.getType();
            List<UsaTradeLogEntity> list = gson.fromJson(gson.toJson(parameter), type);
            usaTradeLogRepository.saveAll(list);
            responseBean = objectTool.getSuccessRep();
            responseBean.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBean;
    }

}
