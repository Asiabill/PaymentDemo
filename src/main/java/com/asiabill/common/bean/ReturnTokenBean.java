package com.asiabill.common.bean;

import java.io.Serializable;

/**
 * @author: Xiongyancong
 * @create: 2020-07-01 10:18
 */
public class ReturnTokenBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accountId;

    private String test;

    private String reference;

    private String urlCallback;

    private String urlCancel;

    private String urlComplete;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    @Override
    public String toString() {
        return "ReturnTokenBean{" +
                "accountId='" + accountId + '\'' +
                ", test='" + test + '\'' +
                ", reference='" + reference + '\'' +
                ", urlCallback='" + urlCallback + '\'' +
                ", urlCancel='" + urlCancel + '\'' +
                ", urlComplete='" + urlComplete + '\'' +
                '}';
    }
}
