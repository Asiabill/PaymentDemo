package com.asiabill.form;

/**
 * @author: Xiongyancong
 * @create: 2020-07-01 16:53
 */
public class AsiabillCallbackForm {
    //前置推送地址固定参数
    private String resToken;

    //推送交易类型：PaymentResult支付通知、Refund退款、 Capture 预授权完成通知、Void 预授权撤销通知
    private String notifyType;

    private String merNo;
    private String gatewayNo;
    private String tradeNo;
    private String orderNo;
    private String orderCurrency;
    private String orderAmount;
    private String orderStatus;
    private String orderInfo;
    private String signInfo;
    private String riskInfo;
    private String remark;

    private String isPush;
    private String cardNo;
    private String authTypeStatus;

    //退款字段
    private String batchNo;
    private String reason;
    private String merTrackNo;
    private String status;
    private String amount;
    private String currency;
    private String cpdDate;
    private String tradeDate;
    private String replyDeadline;

    //预授权字段
    private String operationResult;

    public String getResToken() {
        return resToken;
    }

    public void setResToken(String resToken) {
        this.resToken = resToken;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(String signInfo) {
        this.signInfo = signInfo;
    }

    public String getRiskInfo() {
        return riskInfo;
    }

    public void setRiskInfo(String riskInfo) {
        this.riskInfo = riskInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsPush() {
        return isPush;
    }

    public void setIsPush(String isPush) {
        this.isPush = isPush;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAuthTypeStatus() {
        return authTypeStatus;
    }

    public void setAuthTypeStatus(String authTypeStatus) {
        this.authTypeStatus = authTypeStatus;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMerTrackNo() {
        return merTrackNo;
    }

    public void setMerTrackNo(String merTrackNo) {
        this.merTrackNo = merTrackNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCpdDate() {
        return cpdDate;
    }

    public void setCpdDate(String cpdDate) {
        this.cpdDate = cpdDate;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getReplyDeadline() {
        return replyDeadline;
    }

    public void setReplyDeadline(String replyDeadline) {
        this.replyDeadline = replyDeadline;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    @Override
    public String toString() {
        return "AsiabillCallbackForm{" +
                "resToken='" + resToken + '\'' +
                ", notifyType='" + notifyType + '\'' +
                ", merNo='" + merNo + '\'' +
                ", gatewayNo='" + gatewayNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderCurrency='" + orderCurrency + '\'' +
                ", orderAmount='" + orderAmount + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderInfo='" + orderInfo + '\'' +
                ", signInfo='" + signInfo + '\'' +
                ", riskInfo='" + riskInfo + '\'' +
                ", remark='" + remark + '\'' +
                ", isPush='" + isPush + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", authTypeStatus='" + authTypeStatus + '\'' +
                ", batchNo='" + batchNo + '\'' +
                ", reason='" + reason + '\'' +
                ", merTrackNo='" + merTrackNo + '\'' +
                ", status='" + status + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", cpdDate='" + cpdDate + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", replyDeadline='" + replyDeadline + '\'' +
                ", operationResult='" + operationResult + '\'' +
                '}';
    }
}
