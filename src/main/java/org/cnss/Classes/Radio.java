package org.cnss.Classes;

public class Radio extends Document{
    private static int id;
    private static String radiologist;
    private static String description;

    public Radio(String code, int payedAmount, int reimbursementRate) {
        super(code, payedAmount, reimbursementRate);
    }
}
