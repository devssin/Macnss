package org.cnss.Classes;

public class Radio extends Document{
    private static int id;
    private static String radiologist;
    private static String description;

    public Radio(String code, int payedAmount, int reimbursementRate) {
        super(code, payedAmount, reimbursementRate);
    }

    @Override
    public int reimbursement_total(int payedAmount, int reimbursementRate) {
        return 0;
    }
}
