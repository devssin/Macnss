package org.cnss.Classes;

public abstract class Document {
    private int id;
    private String code;
    private int payedAmount;
    private int reimbursementRate;

    public Document(String code, int payedAmount, int reimbursementRate) {
        this.code = code;
        this.payedAmount = payedAmount;
        this.reimbursementRate = reimbursementRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(int payedAmount) {
        this.payedAmount = payedAmount;
    }

    public int getReimbursementRate() {
        return reimbursementRate;
    }

    public void setReimbursementRate(int reimbursementRate) {
        this.reimbursementRate = reimbursementRate;
    }


}
