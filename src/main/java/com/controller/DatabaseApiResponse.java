package com.controller;

import com.pojo.dto.DatabaseApiResponseBean;
import com.tool.ObjectTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DatabaseApiResponse {

    @Autowired
    private ObjectTool objectTool;

    @RequestMapping(value = "/databaseApiResponse", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<Object> crawlerApiResponse(HttpServletRequest request) {
        DatabaseApiResponseBean responseDTO = (DatabaseApiResponseBean) request.getAttribute("response");
        if (responseDTO == null) {
            responseDTO = objectTool.getErrorRep();
        }
        long beginTime = (long) request.getAttribute("beginTime");
        float queryTime = (float)(System.currentTimeMillis() - beginTime) / 1000;
        responseDTO.setQueryTime(queryTime);
        return ResponseEntity.ok(responseDTO);
    }

}
