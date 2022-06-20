package com.zsl.easyexcelpro.config.format;

import org.springframework.stereotype.Component;

@Component
public class BooleanStrFormat {

    public String toStr(Boolean isDisable) {
        return isDisable ? "Y" : "N";
    }

    public Boolean toBoolean(String str) {
        return str.equals("Y");
    }
}
