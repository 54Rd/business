package org.business.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wangz on 2016/12/17.
 */
@ConfigurationProperties(prefix = "secret",locations = "classpath:key.properties")
public class SecretKeySettings {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
