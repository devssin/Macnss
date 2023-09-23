package org.cnss.Classes;

public class Scanner extends Document{
    private static int id;
    private static String laboratory;
    private static String description;

    public Scanner(String code, int payedAmount, int reimbursementRate) {
        super(code, payedAmount, reimbursementRate);
    }
}
