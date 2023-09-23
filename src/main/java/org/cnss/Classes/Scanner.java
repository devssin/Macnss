package org.cnss.Classes;

public class Scanner extends Document{
    private static int id;
    private static String laboratory;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Scanner.id = id;
    }

    public static String getLaboratory() {
        return laboratory;
    }

    public static void setLaboratory(String laboratory) {
        Scanner.laboratory = laboratory;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Scanner.description = description;
    }

    private static String description;

    public Scanner(String code, int payedAmount, int reimbursementRate) {
        super(code, payedAmount, reimbursementRate);
    }

    @Override
    public int reimbursement_total(int payedAmount, int reimbursementRate) {
        return 0;
    }
}
