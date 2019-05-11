package com.food.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**微信Account配置
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-09 11:50
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {


    /**
     * 公众号授权 appid
     */
    private String mpAppId;
    /**
     * 公众号授权appSecret
     */

    private String mpAppSecret;
    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户密钥
     */
    private String mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;

    /**
     * 微信支付异步通知地址
     */
    private String notifyUrl;
}
