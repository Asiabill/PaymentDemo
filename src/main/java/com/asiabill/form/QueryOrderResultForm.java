package com.asiabill.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author: Xiongyancong
 * @create: 2020-07-03 09:12
 * 查询订单返回结果类
 */

public class QueryOrderResultForm implements Serializable {
    private String merNo;
    private String gatewayNo;
    private String orderNo;
    private String tradeNo;
    private String tradeDate;
    private String tradeAmount;
    private String tradeCurrency;
    private String authStatus;
    private String sourceWebSite;
    private String queryResult;
    private String barcode;
    private String paytime;
    private String clearStatus;

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo;
    }

    public String getGatewayNo() {
        return gatewayNo;
    }

    public void setGatewayNo(String gatewayNo) {
        this.gatewayNo = gatewayNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(String tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public String getSourceWebSite() {
        return sourceWebSite;
    }

    public void setSourceWebSite(String sourceWebSite) {
        this.sourceWebSite = sourceWebSite;
    }

    public String getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(String queryResult) {
        this.queryResult = queryResult;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getClearStatus() {
        return clearStatus;
    }

    public void setClearStatus(String clearStatus) {
        this.clearStatus = clearStatus;
    }

    @Override
    public String toString() {
        return "QueryOrderResultForm{" +
                "merNo='" + merNo + '\'' +
                ", gatewayNo='" + gatewayNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", tradeAmount='" + tradeAmount + '\'' +
                ", tradeCurrency='" + tradeCurrency + '\'' +
                ", authStatus='" + authStatus + '\'' +
                ", sourceWebSite='" + sourceWebSite + '\'' +
                ", queryResult='" + queryResult + '\'' +
                ", barcode='" + barcode + '\'' +
                ", paytime='" + paytime + '\'' +
                ", clearStatus='" + clearStatus + '\'' +
                '}';
    }
}
