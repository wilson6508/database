package com.tool;

import org.springframework.stereotype.Service;

@Service
public class EnumTool {

    public enum ModuleType {

        STOCK_CREATE_USA_PRICE_LOG("stock_create_usa_price_log", "/stock/usaPriceLog/create", true),
        STOCK_READ_USA_PRICE_LOG("stock_read_usa_price_log", "/stock/usaPriceLog/read", true),

        STOCK_CREATE_USA_TRADE_LOG("stock_create_usa_trade_log", "/stock/usaTradeLog/create", true),
        STOCK_READ_USA_TRADE_LOG("stock_read_usa_trade_log", "/stock/usaTradeLog/read", false),

        STOCK_CREATE_TW_TRADE_LOG("stock_create_tw_trade_log", "/stock/twTradeLog/create", false),
        STOCK_READ_TW_TRADE_LOG("stock_read_tw_trade_log", "/stock/twTradeLog/create", false),

        STOCK_READ_TW_NAME_MAPPING("stock_read_tw_name_mapping", "/stock/twNameMapping/read", false),
        STOCK_UPDATE_TW_NAME_MAPPING("stock_update_tw_name_mapping", "/stock/twNameMapping/update", true),

        ;

        private String moduleName;
        private String modulePath;
        private boolean needLog;

        ModuleType(String moduleName, String modulePath, boolean needLog) {
            this.moduleName = moduleName;
            this.modulePath = modulePath;
            this.needLog = needLog;
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public String getModulePath() {
            return modulePath;
        }

        public void setModulePath(String modulePath) {
            this.modulePath = modulePath;
        }

        public boolean isNeedLog() {
            return needLog;
        }

        public void setNeedLog(boolean needLog) {
            this.needLog = needLog;
        }
    }

    public ModuleType findModuleType(String str) {
        for (ModuleType moduleType : ModuleType.values()) {
            if (moduleType.getModuleName().equalsIgnoreCase(str)) {
                return moduleType;
            }
        }
        return null;
    }

}
