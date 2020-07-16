package com.asiabill.common.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Xiongyancong
 * @create: 2020-06-29 10:21
 */
@Component
public class ConstantsBean {
    public static String SIGN_KEY;
    public static String RETURN_URL;
    public static String CALLBACK_URL;
    public static String REQUEST_URL;
    public static String QUERY_ORDER_URL;
    public static String MER_NO;

    @Value("${signKey}")
    public void setSignKey(String signKey) {
        ConstantsBean.SIGN_KEY = signKey;
    }

    @Value("${returnUrl}")
    public void setReturnUrl(String returnUrl) {
        ConstantsBean.RETURN_URL = returnUrl;
    }

    @Value("${callbackUrl}")
    public void setCallbackUrl(String callbackUrl) {
        ConstantsBean.CALLBACK_URL = callbackUrl;
    }

    @Value("${requestUrl}")
    public void setRequestUrl(String requestUrl) {
        ConstantsBean.REQUEST_URL = requestUrl;
    }

    @Value("${queryOrderUrl}")
    public void setQueryOrderUrl(String queryOrderUrl) {
        ConstantsBean.QUERY_ORDER_URL = queryOrderUrl;
    }

    @Value("${merNo}")
    public void setMerNo(String merNo) {
        ConstantsBean.MER_NO = merNo;
    }
}
