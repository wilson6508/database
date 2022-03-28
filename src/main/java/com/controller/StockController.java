package com.controller;

import com.pojo.dto.DatabaseApiResponseBean;
import com.service.stock.TwStockService;
import com.service.stock.UsaStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private TwStockService twStockService;
    @Autowired
    private UsaStockService usaStockService;

    @RequestMapping(value = "/twNameMapping/{action}", method = {RequestMethod.POST, RequestMethod.GET})
    public String twNameMapping(@PathVariable("action") String action, HttpServletRequest request) {
        Object parameter = request.getAttribute("request");
        DatabaseApiResponseBean responseDTO = null;
        switch (action) {
            case "read": {
                responseDTO = twStockService.readTwNameMapping();
                break;
            }
            case "update": {
                responseDTO = twStockService.updateTwNameMapping(parameter);
                break;
            }
        }
        request.setAttribute("response", responseDTO);
        return "forward:/databaseApiResponse";
    }

//    @RequestMapping(value = "/readTwNameMapping", method = {RequestMethod.POST, RequestMethod.GET})
//    public String readTwNameMapping(HttpServletRequest request) {
//        DatabaseApiResponseBean responseDTO = twStockService.readTwNameMapping();
//        request.setAttribute("response", responseDTO);
//        return "forward:/databaseApiResponse";
//    }

    @RequestMapping(value = "/createTwTradeLog", method = {RequestMethod.POST, RequestMethod.GET})
    public String createTwTradeLog(HttpServletRequest request) {
        Object parameter = request.getAttribute("request");
        DatabaseApiResponseBean responseDTO = twStockService.createTwTradeLog(parameter);
        request.setAttribute("response", responseDTO);
        return "forward:/databaseApiResponse";
    }

    @RequestMapping(value = "/createUsaPriceLog", method = {RequestMethod.POST, RequestMethod.GET})
    public String createUsaPriceLog(HttpServletRequest request) {
        Object parameter = request.getAttribute("request");
        DatabaseApiResponseBean responseDTO = usaStockService.createUsaPriceLog(parameter);
        request.setAttribute("response", responseDTO);
        return "forward:/databaseApiResponse";
    }

    @RequestMapping("readUsaPriceLog")
    public String readUsaPriceLog(HttpServletRequest request) {
        DatabaseApiResponseBean responseDTO = usaStockService.readUsaPriceLog();
        request.setAttribute("response", responseDTO);
        return "forward:/databaseApiResponse";
    }

    @RequestMapping(value = "/createUsaTradeLog", method = {RequestMethod.POST, RequestMethod.GET})
    public String createUsaTradeLog(HttpServletRequest request) {
        Object parameter = request.getAttribute("request");
        DatabaseApiResponseBean responseDTO = usaStockService.createUsaTradeLog(parameter);
        request.setAttribute("response", responseDTO);
        return "forward:/databaseApiResponse";
    }

}
