package com.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseApiResponseBean {
    private Boolean success;
    private Double errorCode;
    private String errorMessage;
    private Float queryTime;
    private Object result;
    private Object extraInfo;
}
