package com.asiabill.controller;

import com.asiabill.common.bean.ConstantsBean;
import com.asiabill.common.bean.ResultBean;
import com.asiabill.common.utils.*;
import com.asiabill.form.AsiabillQueryOrderForm;
import com.asiabill.form.QueryOrderResultForm;
import com.asiabill.form.TriQueryOrderForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Xiongyancong
 * @create: 2020-07-02 16:53
 *
 * 查询订单接口
 */

@Slf4j
@Controller
@RequestMapping("/query")
public class TriQueryOrderController {
    /**
     * 查询订单信息
     * @param triQueryOrderForm
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping("/queryOrder")
    public ResultBean<?> queryOrder(TriQueryOrderForm triQueryOrderForm, HttpServletRequest request, HttpServletResponse response) {
        log.info("进入查询订单前置");

        if (triQueryOrderForm == null) {
            log.error("查询订单前置接收请求参数异常");

            return ResultBean.fail(100,"Incorrect parameter transmission");
        }
        if (StringUtils.isBlank(triQueryOrderForm.getAccountId())) {
            log.error("查询订单前置接收请求参数异常, accountId不能为空");

            return ResultBean.fail(100,"Incorrect parameter transmission");
        }
        if (StringUtils.isBlank(triQueryOrderForm.getReference())) {
            log.error("查询订单前置接收请求参数异常，reference不能为空");

            return ResultBean.fail(100,"Incorrect parameter transmission");
        }

        //组装请求参数
        AsiabillQueryOrderForm asiabillQueryOrderForm = new AsiabillQueryOrderForm();

        asiabillQueryOrderForm.setMerNo(ConstantsBean.MER_NO);
        asiabillQueryOrderForm.setGatewayNo(triQueryOrderForm.getAccountId());
        asiabillQueryOrderForm.setOrderNo(triQueryOrderForm.getReference());

        //生成签名信息 明文加密结构：merNo + gatewayNo + signkey
        String signInfo = ParamUtil.getSignInfo(asiabillQueryOrderForm, ConstantsBean.SIGN_KEY);
        asiabillQueryOrderForm.setSignInfo(signInfo);
        LinkedHashMap<String, String> params = ObjectUtil.toLinkedHashMap(asiabillQueryOrderForm);

        //请求接口地址
        String url = ConstantsBean.QUERY_ORDER_URL;

        String result = "";
        //组装请求
        try {
            result = HttpClientUtil.post(url,params);
            log.info("请求返回结果{}",result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Object> orderList = null;
        try {
            orderList =  XmlUtil.parseResultXml(QueryOrderResultForm.class,result,"tradeinfo");
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return ResultBean.success(orderList);
    }
}
