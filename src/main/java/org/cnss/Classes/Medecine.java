package org.cnss.Classes;

public class Medecine extends Document{
    private static int id;
    private static String codeBarre;
    private static String name;
    private static String factory;

    public Medecine(String code, int payedAmount, int reimbursementRate) {
        super(code, payedAmount, reimbursementRate);
    }
}
