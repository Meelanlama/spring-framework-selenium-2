package com.milan.model_attribute_method_level;

import org.springframework.stereotype.Component;

@Component
public class Info {
    private String serverIp = "127.0.00.1";

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }
}
