package com.tool;

import com.pojo.dto.DatabaseApiResponseBean;
import org.springframework.stereotype.Service;

@Service
public class ObjectTool {

    public DatabaseApiResponseBean getErrorRep() {
        DatabaseApiResponseBean responseBean = new DatabaseApiResponseBean();
        responseBean.setSuccess(false);
        responseBean.setErrorCode(7.0);
        responseBean.setErrorMessage("error");
        return responseBean;
    }

    public DatabaseApiResponseBean getSuccessRep() {
        DatabaseApiResponseBean responseBean = new DatabaseApiResponseBean();
        responseBean.setSuccess(true);
        responseBean.setErrorCode(0.0);
        responseBean.setErrorMessage("success");
        return responseBean;
    }

}
