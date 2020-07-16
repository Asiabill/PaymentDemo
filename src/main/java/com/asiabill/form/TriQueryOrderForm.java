package com.asiabill.form;

/**
 * @author: Xiongyancong
 * @create: 2020-07-02 16:44
 *
 * 商户查询订单实体类
 */
public class TriQueryOrderForm {
    private String accountId;
    private String reference;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "TriQueryOrderForm{" +
                "accountId='" + accountId + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
