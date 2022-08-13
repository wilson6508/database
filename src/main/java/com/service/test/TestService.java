package com.service.test;

import com.dao.UsaPriceLogRepository;
import com.google.gson.Gson;
import com.mapper.Count;
import com.mapper.UsaPriceLogMapper;
import com.pojo.entity.UsaPriceLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestService {

    private final Gson gson = new Gson();

    @Autowired
    UsaPriceLogRepository usaPriceLogRepository;
    @Autowired
    UsaPriceLogMapper usaPriceLogMapper;

    public void demo1() {
        UsaPriceLogEntity entity = usaPriceLogMapper.getEntityById(1);
        System.out.println(gson.toJson(entity));
    }

    public void demo2() {
        List<UsaPriceLogEntity> list = usaPriceLogMapper.getEntityListByStockId("SPY");
        System.out.println(list.size());
    }

    public void demo3() {
        List<Count> countList = usaPriceLogMapper.getCountList();
        System.out.println(gson.toJson(countList));
    }

    public void test() {

        int page = 35;
        int size = 10;

//        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<UsaPriceLogEntity> pageResult = usaPriceLogRepository.findAll(pageRequest);

        System.out.println(pageResult.getNumberOfElements());   // 本頁筆數
        System.out.println(pageResult.getSize());               // 每頁筆數
        System.out.println(pageResult.getTotalElements());      // 全部筆數
        System.out.println(pageResult.getTotalPages());         // 全部頁數

        List<UsaPriceLogEntity> messageList =  pageResult.getContent();
        System.out.println(gson.toJson(messageList.get(0)));
        System.out.println(gson.toJson(messageList.get(1)));
        // https://www.gss.com.tw/blog/spring-data-jpa-1
        // https://www.gss.com.tw/blog/heroku-java-free-space
    }

}
