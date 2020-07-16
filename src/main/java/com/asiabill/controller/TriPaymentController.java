package com.asiabill.controller;

import com.alibaba.fastjson.JSONObject;
import com.asiabill.common.bean.ConstantsBean;
import com.asiabill.common.bean.ReturnTokenBean;
import com.asiabill.common.utils.*;
import com.asiabill.form.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * @author: Xiongyancong
 * @create: 2020-06-24 16:35
 */

@Slf4j
@Controller
@RequestMapping("/payment")
public class TriPaymentController {
    /**------信用卡------**/
    private final String PAYMENTMETHOD_CREDITCARD = "credit card";

    @RequestMapping(value = "/creditcard")
    public void toCreditCard(TriPaymentForm tpForm, HttpServletRequest request, HttpServletResponse response) {
        log.info("进入支付前置 -- PAYMENTMETHOD_CREDITCARD");

        if (tpForm == null) {
            log.error("支付前置接收请求参数异常");
            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }

        //支付方式为credit card必传参数
        if (StringUtils.isBlank(tpForm.getCustomerBillingCity())) {
            log.error("支付前接收请求参数异常，x_customer_billing_city不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }
        if (StringUtils.isBlank(tpForm.getCustomerBillingAddress1())) {
            log.error("支付前接收请求参数异常，x_customer_billing_address不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }
        if (StringUtils.isBlank(tpForm.getCustomerBillingCountry())) {
            log.error("支付前接收请求参数异常，x_customer_billing_country不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }
        if (StringUtils.isBlank(tpForm.getCustomerBillingZip())) {
            log.error("支付前接收请求参数异常，x_customer_billing_zip不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }

        this.redirectPayment(PAYMENTMETHOD_CREDITCARD, tpForm, request, response);

        return ;
    }

    /** 重定向支付页面
     * @param tpForm
     * @param request
     * @param response
     */
    private void redirectPayment(String paymentMethod, TriPaymentForm tpForm, HttpServletRequest request, HttpServletResponse response) {
        Long startTime = System.currentTimeMillis();
        //1.接收参数
        if (tpForm == null) {
            log.error("支付前置接收请求参数异常");
            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }

        //2.获取来源客户端信息
        String userAgent = request.getHeader("User-Agent");
        String refererUrl = request.getHeader("Referer");
        String ip = RequestUtils.getIpRealAddr(request);
        String isMobile = BrowserUtil.isMobile(userAgent);

        //3.参数校验
        //订单参数
        if (StringUtils.isBlank(tpForm.getAccountId())) {
            log.error("支付前接收请求参数异常，x_account_id不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }
        if (StringUtils.isBlank(tpForm.getReference())) {
            log.error("支付前接收请求参数异常，x_reference不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }
        if (StringUtils.isBlank(tpForm.getAmount())) {
            log.error("支付前接收请求参数异常，x_amount不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }
        if (StringUtils.isBlank(tpForm.getCurrency())) {
            log.error("支付前接收请求参数异常，x_currency不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }
        if (StringUtils.isBlank(tpForm.getCustomerFirstName())) {
            log.error("支付前接收请求参数异常，x_customer_firstName不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }
        if (StringUtils.isBlank(tpForm.getCustomerLastName())) {
            log.error("支付前接收请求参数异常，x_customer_lastName不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }
        if (StringUtils.isBlank(tpForm.getCustomerEmail())) {
            log.error("支付前接收请求参数异常，x_customer_Email不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }
        if (StringUtils.isBlank(tpForm.getCustomerPhone())) {
            log.error("支付前接收请求参数异常，x_customer_phone不能为空。");

            RedirectUtil.redirectError("NC001", "Incorrect parameter transmission",request,response);
            return;
        }

        //4.组装请求参数
        AsiabillPaymentForm abForm = new AsiabillPaymentForm();
        ObjectUtil.conversionToFrom(tpForm,abForm);
        abForm.setMerNo(ConstantsBean.MER_NO);
        abForm.setIsMobile(tpForm.getIsMobile());
        abForm.setIp(ip);
        abForm.setMerWebsite(refererUrl);
        //设置支付方式 固定为credit_card
        abForm.setPaymentMethod(PAYMENTMETHOD_CREDITCARD);

        //5.处理推送地址
        ReturnTokenBean returnTokenBean = new ReturnTokenBean();
        returnTokenBean.setAccountId(tpForm.getAccountId());
        returnTokenBean.setReference(tpForm.getReference());
        returnTokenBean.setTest(tpForm.getTest());
        String returnTokenSr = JSONObject.toJSONString(returnTokenBean);
        log.info("returnTokenSr = {}",returnTokenSr);
        String resToken = SecUtil.encrypt(returnTokenSr.trim());
        log.info("resToken = {}", resToken);

        abForm.setReturnUrl(ConstantsBean.RETURN_URL + "?resToken=" + resToken);
        abForm.setCallbackUrl(ConstantsBean.CALLBACK_URL + "?resToken=" + resToken);

        //6.计算并设置签名信息
        String signInfo = ParamUtil.getSignInfo(abForm, ConstantsBean.SIGN_KEY);
        log.info("signInfo = {}",signInfo);
        abForm.setSignInfo(signInfo);

        //7.生成交易地址 版本为V2
        String url = ConstantsBean.REQUEST_URL;
        //返回页面参数
        LinkedHashMap<String, String> params = ObjectUtil.toLinkedHashMap(abForm);

        request.setAttribute("transUrl", url);
        request.setAttribute("abfrom", abForm);
        request.setAttribute("abfromMap", params);

        log.info("transUrl = {}", url);
        log.info("params = {}", params.toString());
        //8.跳转支付
        RedirectUtil.redirectPayment(url,params,request,response);

        log.info("支付前置处理成功[统计耗时：{}ms]",  (System.currentTimeMillis() - startTime));
    }

    @RequestMapping(value = "/result")
    public void result(AsiabillResponseForm abForm, HttpServletRequest request, HttpServletResponse response) {
        log.info("进入跳转前置");
        long startTime = System.currentTimeMillis();

        if (abForm == null) {
            log.error("跳转前置接收支付网关返回参数异常");

            RedirectUtil.redirectError("NC992", "An error occurred, please confirm later", request, response);
            return ;
        }

        //结果参数校验
        if (StringUtils.isBlank(abForm.getMerNo())) {
            log.error("跳转前置接收支付网关返回参数异常, merNo 不能为空");

            RedirectUtil.redirectError("NC992", "An error occurred, please confirm later", request, response);
            return;
        }

        if (StringUtils.isBlank(abForm.getGatewayNo())) {
            log.error("跳转前置接收支付网关返回参数异常, gatewayNo 不能为空");

            RedirectUtil.redirectError("NC992", "An error occurred, please confirm later", request, response);
            return;
        }
        if(StringUtils.isBlank(abForm.getOrderNo())) {
            log.error("跳转前置接收支付网关返回参数异常, orderNo 不能为空");

            RedirectUtil.redirectError("NC992", "An error occurred, please confirm later", request, response);
            return ;
        }
        if(StringUtils.isBlank(abForm.getOrderStatus())) {
            log.error("跳转前置接收支付网关返回参数异常, orderStatus 不能为空");

            RedirectUtil.redirectError("NC992", "An error occurred, please confirm later", request, response);
            return ;
        }
        if(StringUtils.isBlank(abForm.getSignInfo())) {
            log.error("跳转前置接收支付网关返回参数异常, signInfo 不能为空");

            RedirectUtil.redirectError("NC992", "An error occurred, please confirm later", request, response);
            return ;
        }

        //检验签名
        String checkSign = ParamUtil.getSignInfo(abForm, ConstantsBean.SIGN_KEY);
        log.info("checkSign = {}",checkSign);
        if (StringUtils.isBlank(checkSign)) {
            log.error("跳转前置异常，生成网关签名异常[gatewayNo = {}, orderNo = {}]", abForm.getGatewayNo(), abForm.getOrderNo());

            RedirectUtil.redirectError("NC992", "An error occurred, please confirm later", request, response);
            return;
        }
        if (!checkSign.equalsIgnoreCase(abForm.getSignInfo())) {
            log.error("跳转前置异常， 检验网关签名错误[signInfo = {}, checkSign = {}]",abForm.getSignInfo(), checkSign);

            RedirectUtil.redirectError("NC992", "An error occurred, please confirm later", request, response);
            return;
        }


        //获取推送参数
        ReturnTokenBean returnTokenBean = null;
        if (StringUtils.isNotBlank(abForm.getResToken())) {
            log.info("resToken = {}", abForm.getResToken());
            String resUrlStr = SecUtil.decrypt(abForm.getResToken());
            log.info("resTokenStr = {}", resUrlStr);
            returnTokenBean = JSONObject.parseObject(resUrlStr, ReturnTokenBean.class);
        }

        //组装报文参数
        TriResponseForm trForm = new TriResponseForm();
        trForm.setAccountId(abForm.getGatewayNo());
        trForm.setReference(abForm.getOrderNo());
        trForm.setCurrency(abForm.getOrderCurrency());
        trForm.setTest(returnTokenBean.getTest());
        trForm.setAmount(abForm.getOrderAmount());
        trForm.setGatewayReference(abForm.getTradeNo());
        trForm.setTimestamp(DateUtil.getCurrentDateString());
        //返回数字：-1/0/1
        //-1: 待处理  0: 失败  1: 成功
        trForm.setResult("1".equals(abForm.getOrderStatus()) ? "成功" :
                "0".equals(abForm.getOrderStatus()) ? "失败" : "待处理");
        trForm.setMessage(abForm.getOrderInfo());

        trForm.setSignature(checkSign);

        //跳转地址
        request.getSession().setAttribute("trForm",trForm);
        try {
            request.getRequestDispatcher("/result.jsp").forward(request, response);
            log.info("跳转前置处理成功[统计耗时：{}ms][{}]",  (System.currentTimeMillis() - startTime), ConstantsBean.RETURN_URL);
            return ;
        } catch (ServletException e) {
            log.error(StringHandleUtils.getExceptionInfo(e));
        } catch (IOException e) {
            log.error(StringHandleUtils.getExceptionInfo(e));
        }
    }

    @RequestMapping("/callBack")
    public void callBack(AsiabillCallbackForm callbackForm, HttpServletRequest request, HttpServletResponse response){
        log.info("进入线下推送前置");
        long startTime = System.currentTimeMillis();
        log.info("abCallbackForm = {}", callbackForm.toString());

        //参数校验
        if(StringUtils.isBlank(callbackForm.getResToken())) {
            log.error("线下推送前置接收请求参数异常, resToken 不能为空");
            return ;
        }

        if(StringUtils.isBlank(callbackForm.getNotifyType())) {
            log.error("线下推送前置接收请求参数异常, notifyType 不能为空");
            return ;
        }

        if(StringUtils.isBlank(callbackForm.getMerNo())) {
            log.error("线下推送前置接收请求参数异常, merNo 不能为空");
            return ;
        }

        if(StringUtils.isBlank(callbackForm.getGatewayNo())) {
            log.error("线下推送前置接收请求参数异常, gatewayNo 不能为空");
            return ;
        }

        if(StringUtils.isBlank(callbackForm.getOrderNo())) {
            log.error("线下推送前置接收请求参数异常, orderNo 不能为空");
            return ;
        }

        if(StringUtils.isBlank(callbackForm.getSignInfo())) {
            log.error("线下推送前置接收请求参数异常, signInfo 不能为空");
            return ;
        }

        //获取返回推送地址
        ReturnTokenBean returnTokenBean = null;
        if(StringUtils.isNotBlank(callbackForm.getResToken())) {
            log.info("resToken = {}", callbackForm.getResToken());
            String resUrlStr = SecUtil.decrypt(callbackForm.getResToken());
            log.info("resTokenStr = {}", resUrlStr);
            returnTokenBean = JSONObject.parseObject(resUrlStr, ReturnTokenBean.class);
        }

        //判断推送交易类型  PaymentResult支付通知、Refund退款、 Capture 预授权完成通知、Void 预授权撤销通知
        if ("PaymentResult".equals(callbackForm.getNotifyType()) || "OrderStatusChanged".equals(callbackForm.getNotifyType())) {
            log.info("进入支付结果线下推送。 [notifyType = {}]", callbackForm.getNotifyType());

            //检验支付签名
            //获取本地签名
            String checkSign = ParamUtil.getSignInfo(callbackForm, ConstantsBean.SIGN_KEY);
            log.info("checkSign = {}",checkSign);
            if (StringUtils.isBlank(checkSign)) {
                log.error("线下推送前置异常，支付结果线下推送生成网关签名异常[gatewayNo = {}, orderNo = {}]", callbackForm.getGatewayNo(), callbackForm.getOrderNo());

                return;
            }
            if (!checkSign.equalsIgnoreCase(callbackForm.getSignInfo())) {
                log.error("线下推送前置异常，支付结果线下推送检验网关签名错误[signInfo = {}, checkSign = {}]",callbackForm.getSignInfo(), checkSign);

                return;
            }

            //组装报文参数
            TriResponseForm trForm = new TriResponseForm();
            trForm.setAccountId(callbackForm.getGatewayNo());
            trForm.setReference(callbackForm.getOrderNo());
            trForm.setCurrency(callbackForm.getOrderCurrency());
            trForm.setTest(returnTokenBean.getTest());
            trForm.setAmount(callbackForm.getOrderAmount());
            trForm.setGatewayReference(callbackForm.getTradeNo());
            trForm.setTimestamp(DateUtil.getCurrentDateString());
            trForm.setResult(callbackForm.getOrderStatus());
            trForm.setMessage(callbackForm.getOrderInfo());

            trForm.setSignature(checkSign);

            log.info("处理相应业务");
            log.info("线下推送前置-支付结果线下推送成功[统计耗时：{}ms] [SUCCESS]", (System.currentTimeMillis() - startTime));
            try {
                response.getWriter().print("SUCCESS");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ;
        }
    }
}
