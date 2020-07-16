package com.asiabill.form;

/**
 * @author: Xiongyancong
 * @create: 2020-07-02 16:50
 *
 * 请求Asiabill查询订单接口实体类
 */
public class AsiabillQueryOrderForm {
    private String merNo;
    private String gatewayNo;
    private String orderNo;
    private String signInfo;

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

    public String getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(String signInfo) {
        this.signInfo = signInfo;
    }

    @Override
    public String toString() {
        return "AsiabillQueryOrderForm{" +
                "merNo='" + merNo + '\'' +
                ", gatewayNo='" + gatewayNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", signInfo='" + signInfo + '\'' +
                '}';
    }
}
