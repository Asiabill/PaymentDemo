package com.asiabill.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Xiongyancong
 * @create: 2020-06-24 16:14
 */

public class TriPaymentForm {
    @JsonProperty("authenticity_token")
    private String authenticityToken;

    @JsonProperty("x_account_id")
    private String accountId;

    @JsonProperty("x_amount")
    private String amount;

    @JsonProperty("x_currency")
    private String currency;

    @JsonProperty("x_customer_billing_address1")
    private String customerBillingAddress1;

    @JsonProperty("x_customer_billing_address2")
    private String customerBillingAddress2;

    @JsonProperty("x_customer_billing_city")
    private String customerBillingCity;

    @JsonProperty("x_customer_billing_country")
    private String customerBillingCountry;

    @JsonProperty("x_customer_billing_company")
    private String customerBillingCompany;

    @JsonProperty("x_customer_billing_state")
    private String customerBillingState;

    @JsonProperty("x_customer_billing_phone")
    private String customerBillingPhone;

    @JsonProperty("x_customer_billing_zip")
    private String customerBillingZip;

    @JsonProperty("x_customer_email")
    private String customerEmail;

    @JsonProperty("x_customer_first_name")
    private String customerFirstName;

    @JsonProperty("x_customer_last_name")
    private String customerLastName;

    @JsonProperty("x_customer_phone")
    private String customerPhone;

    @JsonProperty("x_customer_shipping_address1")
    private String customerShippingAddress1;

    @JsonProperty("x_customer_shipping_address2")
    private String customerShippingAddress2;

    @JsonProperty("x_customer_shipping_city")
    private String customerShippingCity;

    @JsonProperty("x_customer_shipping_company")
    private String customerShippingCompany;

    @JsonProperty("x_customer_shipping_country")
    private String customerShippingCountry;

    @JsonProperty("x_customer_shipping_first_name")
    private String customerShippingFirstName;

    @JsonProperty("x_customer_shipping_last_name")
    private String customerShippingLastName;

    @JsonProperty("x_customer_shipping_state")
    private String customerShippingState;

    @JsonProperty("x_customer_shipping_zip")
    private String customerShippingZip;

    @JsonProperty("x_customer_shipping_phone")
    private String customerShippingPhone;

    @JsonProperty("x_description")
    private String description;

    @JsonProperty("x_invoice")
    private String invoice;

    @JsonProperty("x_reference")
    private String reference;

    @JsonProperty("x_shop_country")
    private String shopCountry;

    @JsonProperty("x_shop_name")
    private String shopName;

    @JsonProperty("x_signature")
    private String signature;

    @JsonProperty("x_test")
    private String test;

    @JsonProperty("x_url_callback")
    private String urlCallback;

    @JsonProperty("x_url_cancel")
    private String urlCancel;

    @JsonProperty("x_url_complete")
    private String urlComplete;

    @JsonProperty("x_order_id")
    private String orderId;

    @JsonProperty("x_transaction_type")
    private String transactionType;

    private String isMobile;

    public String getAuthenticityToken() {
        return authenticityToken;
    }

    public void setAuthenticityToken(String authenticityToken) {
        this.authenticityToken = authenticityToken;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public String getCustomerBillingAddress1() {
        return customerBillingAddress1;
    }

    public void setCustomerBillingAddress1(String customerBillingAddress1) {
        this.customerBillingAddress1 = customerBillingAddress1;
    }

    public String getCustomerBillingAddress2() {
        return customerBillingAddress2;
    }

    public void setCustomerBillingAddress2(String customerBillingAddress2) {
        this.customerBillingAddress2 = customerBillingAddress2;
    }

    public String getCustomerBillingCity() {
        return customerBillingCity;
    }

    public void setCustomerBillingCity(String customerBillingCity) {
        this.customerBillingCity = customerBillingCity;
    }

    public String getCustomerBillingCountry() {
        return customerBillingCountry;
    }

    public void setCustomerBillingCountry(String customerBillingCountry) {
        this.customerBillingCountry = customerBillingCountry;
    }

    public String getCustomerBillingCompany() {
        return customerBillingCompany;
    }

    public void setCustomerBillingCompany(String customerBillingCompany) {
        this.customerBillingCompany = customerBillingCompany;
    }

    public String getCustomerBillingState() {
        return customerBillingState;
    }

    public void setCustomerBillingState(String customerBillingState) {
        this.customerBillingState = customerBillingState;
    }

    public String getCustomerBillingPhone() {
        return customerBillingPhone;
    }

    public void setCustomerBillingPhone(String customerBillingPhone) {
        this.customerBillingPhone = customerBillingPhone;
    }

    public String getCustomerBillingZip() {
        return customerBillingZip;
    }

    public void setCustomerBillingZip(String customerBillingZip) {
        this.customerBillingZip = customerBillingZip;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerShippingAddress1() {
        return customerShippingAddress1;
    }

    public void setCustomerShippingAddress1(String customerShippingAddress1) {
        this.customerShippingAddress1 = customerShippingAddress1;
    }

    public String getCustomerShippingAddress2() {
        return customerShippingAddress2;
    }

    public void setCustomerShippingAddress2(String customerShippingAddress2) {
        this.customerShippingAddress2 = customerShippingAddress2;
    }

    public String getCustomerShippingCity() {
        return customerShippingCity;
    }

    public void setCustomerShippingCity(String customerShippingCity) {
        this.customerShippingCity = customerShippingCity;
    }

    public String getCustomerShippingCompany() {
        return customerShippingCompany;
    }

    public void setCustomerShippingCompany(String customerShippingCompany) {
        this.customerShippingCompany = customerShippingCompany;
    }

    public String getCustomerShippingCountry() {
        return customerShippingCountry;
    }

    public void setCustomerShippingCountry(String customerShippingCountry) {
        this.customerShippingCountry = customerShippingCountry;
    }

    public String getCustomerShippingFirstName() {
        return customerShippingFirstName;
    }

    public void setCustomerShippingFirstName(String customerShippingFirstName) {
        this.customerShippingFirstName = customerShippingFirstName;
    }

    public String getCustomerShippingLastName() {
        return customerShippingLastName;
    }

    public void setCustomerShippingLastName(String customerShippingLastName) {
        this.customerShippingLastName = customerShippingLastName;
    }

    public String getCustomerShippingState() {
        return customerShippingState;
    }

    public void setCustomerShippingState(String customerShippingState) {
        this.customerShippingState = customerShippingState;
    }

    public String getCustomerShippingZip() {
        return customerShippingZip;
    }

    public void setCustomerShippingZip(String customerShippingZip) {
        this.customerShippingZip = customerShippingZip;
    }

    public String getCustomerShippingPhone() {
        return customerShippingPhone;
    }

    public void setCustomerShippingPhone(String customerShippingPhone) {
        this.customerShippingPhone = customerShippingPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getShopCountry() {
        return shopCountry;
    }

    public void setShopCountry(String shopCountry) {
        this.shopCountry = shopCountry;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getUrlCallback() {
        return urlCallback;
    }

    public void setUrlCallback(String urlCallback) {
        this.urlCallback = urlCallback;
    }

    public String getUrlCancel() {
        return urlCancel;
    }

    public void setUrlCancel(String urlCancel) {
        this.urlCancel = urlCancel;
    }

    public String getUrlComplete() {
        return urlComplete;
    }

    public void setUrlComplete(String urlComplete) {
        this.urlComplete = urlComplete;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(String isMobile) {
        this.isMobile = isMobile;
    }
}
