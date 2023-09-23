package org.cnss.Classes;

public class Analysis extends Document{
    private static int id;
    private static String laboratory;
    private static String description;

    public Analysis(String code, int payedAmount, int reimbursementRate) {
        super(code, payedAmount, reimbursementRate);
    }
}
