package com.asiabill.form;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: Xiongyancong
 * @create: 2020-06-28 15:00
 */
public class AsiabillPaymentForm {

    private String merNo;

    @JsonProperty("x_account_id")
    private String gatewayNo;

    @JsonProperty("x_reference")
    private String orderNo;

    @JsonProperty("x_currency")
    private String orderCurrency;

    @JsonProperty("x_amount")
    private String orderAmount;

    @JsonProperty("x_customer_first_name")
    private String firstName;

    @JsonProperty("x_customer_last_name")
    private String lastName;

    @JsonProperty("x_customer_email")
    private String email;

    @JsonProperty("x_customer_phone")
    private String phone;

    /**
     * 固定值 credit card
     */
    private String paymentMethod;

    //固定值 boleto
    private String ebanxTypeCode;

    @JsonProperty("x_customer_shipping_first_name")
    private String shipFirstName;

    @JsonProperty("x_customer_shipping_last_name")
    private String shipLastName;

    @JsonProperty("x_customer_shipping_phone")
    private String shipPhone;

    @JsonProperty("x_customer_shipping_country")
    private String shipCountry;

    @JsonProperty("x_customer_shipping_state")
    private String shipState;

    @JsonProperty("x_customer_shipping_city")
    private String shipCity;

    //x_customer_shipping_address1, x_customer_shipping_address2
    @JsonProperty("x_customer_shipping_address1")
    private String shipAddress;

    @JsonProperty("x_customer_shipping_zip")
    private String shipZip;

    @JsonProperty("x_url_complete")
    private String returnUrl;

    @JsonProperty("x_url_callback")
    private String callbackUrl;

    private String remark;

    private String signInfo;

    @JsonProperty("x_customer_billing_country")
    private String country;

    @JsonProperty("x_customer_billing_state")
    private String state;

    @JsonProperty("x_customer_billing_city")
    private String city;

    //x_customer_billing_address1, x_customer_billing_address1
    @JsonProperty("x_customer_billing_address1")
    private String address;

    @JsonProperty("x_customer_billing_zip")
    private String zip;

    @JsonProperty("x_description")
    private String productDesc;

    private String orderStatus;

    //根据客户端来源信息  0：PC端 1：移动端
    private String isMobile;

    //客户端来源IP
    private String ip;

    //客户端来源网址
    private String merWebsite;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getEbanxTypeCode() {
        return ebanxTypeCode;
    }

    public void setEbanxTypeCode(String ebanxTypeCode) {
        this.ebanxTypeCode = ebanxTypeCode;
    }

    public String getShipFirstName() {
        return shipFirstName;
    }

    public void setShipFirstName(String shipFirstName) {
        this.shipFirstName = shipFirstName;
    }

    public String getShipLastName() {
        return shipLastName;
    }

    public void setShipLastName(String shipLastName) {
        this.shipLastName = shipLastName;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public String getShipState() {
        return shipState;
    }

    public void setShipState(String shipState) {
        this.shipState = shipState;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipZip() {
        return shipZip;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(String signInfo) {
        this.signInfo = signInfo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(String isMobile) {
        this.isMobile = isMobile;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMerWebsite() {
        return merWebsite;
    }

    public void setMerWebsite(String merWebsite) {
        this.merWebsite = merWebsite;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "AsiabillPaymentForm{" +
                "merNo='" + merNo + '\'' +
                ", gatewayNo='" + gatewayNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderCurrency='" + orderCurrency + '\'' +
                ", orderAmount='" + orderAmount + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", ebanxTypeCode='" + ebanxTypeCode + '\'' +
                ", shipFirstName='" + shipFirstName + '\'' +
                ", shipLastName='" + shipLastName + '\'' +
                ", shipPhone='" + shipPhone + '\'' +
                ", shipCountry='" + shipCountry + '\'' +
                ", shipState='" + shipState + '\'' +
                ", shipCity='" + shipCity + '\'' +
                ", shipAddress='" + shipAddress + '\'' +
                ", shipZip='" + shipZip + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", remark='" + remark + '\'' +
                ", signInfo='" + signInfo + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", isMobile='" + isMobile + '\'' +
                ", ip='" + ip + '\'' +
                ", merWebsite='" + merWebsite + '\'' +
                '}';
    }
}
