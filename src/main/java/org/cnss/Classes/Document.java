package org.cnss.Classes;

public abstract class Document {


    private int id;
    private String code;
    private String payedAmount;
    private String reimbursementRate;

    public Document(int id, String code, String payedAmount, String reimbursementRate) {
        this.id = id;
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

    public String getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(String payedAmount) {
        this.payedAmount = payedAmount;
    }

    public String getReimbursementRate() {
        return reimbursementRate;
    }

    public void setReimbursementRate(String reimbursementRate) {
        this.reimbursementRate = reimbursementRate;
    }


}
