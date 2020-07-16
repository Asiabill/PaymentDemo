package com.asiabill.common.utils;

import com.asiabill.form.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author: Xiongyancong
 * @create: 2020-06-29 09:26
 * 对支付接口参数的处理
 */

@Slf4j
public class ParamUtil {

    private static String[] illegalParam = { "&", "<", ">", "\"", "'" };
    private static String[] macroParam = { "&amp;", "&lt;", "&gt;", "&quot;","" };
    private static Map<String, String> exchangeParamMap = new HashMap<>();
    static {
        exchangeParamMap.put("&", "&amp;");
        exchangeParamMap.put("<", "&lt;");
        exchangeParamMap.put(">", "&gt;");
        exchangeParamMap.put("\"", "&quot;");
        exchangeParamMap.put("'", "");
    }
    /**
     *将信息字段之中的  &、<、>、“、‘  进行html转码
     * @param param
     * @return
     */
    public static String exchangeParam(String param) {
        for (int i = 0; i < illegalParam.length; i++) {
            int flag = param.indexOf(illegalParam[i]);
            if (flag != -1) {
                String legalString = exchangeParamMap.get(illegalParam[i]);
                param = param.replaceAll(illegalParam[i], legalString);
            }
        }
        return param;
    }

    /**
     * 生成支付签名信息 明文加密结构：merNo + gatewayNo + orderNo + orderCurrency+ orderAmount + returnUrl + signkey
     * @param abForm
     * @return
     */
    public static String getSignInfo(AsiabillPaymentForm abForm, String signKey) {
        if (abForm == null || signKey == null) {
            return "";
        }
        StringBuilder message = new StringBuilder();
        message.append(abForm.getMerNo());
        message.append(abForm.getGatewayNo());
        message.append(abForm.getOrderNo());
        message.append(abForm.getOrderCurrency());
        message.append(abForm.getOrderAmount());
        message.append(abForm.getReturnUrl());
        message.append(signKey);

        String signInfo = new EncryptUtil().getSHA256Encrypt(exchangeParam(message.toString().trim())).toUpperCase();
        return signInfo;
    }

    /**
     * 生成支付结果检验签名信息
     * @param abForm
     * @return
     */
    public static String getSignInfo(AsiabillResponseForm abForm, String signKey) {
        if (abForm == null || signKey == null) {
            return "";
        }
        StringBuilder message = new StringBuilder();
        message.append(abForm.getMerNo());
        message.append(abForm.getGatewayNo());
        message.append(abForm.getTradeNo());
        message.append(abForm.getOrderNo());
        message.append(abForm.getOrderCurrency());
        message.append(abForm.getOrderAmount());
        message.append(abForm.getOrderStatus());
        message.append(abForm.getOrderInfo());
        message.append(signKey);

        String signInfo = new EncryptUtil().getSHA256Encrypt(message.toString().trim()).toUpperCase();
        return signInfo;
    }

    /**
     * 生成线下推送检验签名信息
     * @param callbackForm
     * @return
     */
    public static String getSignInfo(AsiabillCallbackForm callbackForm, String signKey) {
        if (callbackForm == null || StringUtils.isBlank(signKey)) {
            return "";
        }
        StringBuilder message = new StringBuilder();
        message.append(callbackForm.getMerNo());
        message.append(callbackForm.getGatewayNo());
        message.append(callbackForm.getTradeNo());
        message.append(callbackForm.getOrderNo());
        message.append(callbackForm.getOrderCurrency());
        message.append(callbackForm.getOrderAmount());
        message.append(callbackForm.getOrderStatus());
        message.append(callbackForm.getOrderInfo());
        message.append(signKey);

        String signInfo = new EncryptUtil().getSHA256Encrypt(message.toString().trim()).toUpperCase();
        return signInfo;
    }

    /**
     * 生成查询订单签名信息 明文加密结构：merNo + gatewayNo + signkey
     * @param queryOrderForm
     * @param signKey
     * @return
     */
    public static String getSignInfo(AsiabillQueryOrderForm queryOrderForm, String signKey) {
        if (queryOrderForm == null || signKey == null) {
            log.error("生成签名参数为空.[queryOrderForm = {}, signKey = {} ]", queryOrderForm, signKey);
            return "";
        }

        String message = queryOrderForm.getMerNo() + queryOrderForm.getGatewayNo() + signKey;
        String signInfo = new EncryptUtil().getSHA256Encrypt(message.trim()).toLowerCase();

        return signInfo;
    }

}
