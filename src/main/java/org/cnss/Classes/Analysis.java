package org.cnss.Classes;

public class Analysis extends Document{
    private static int id;
    private static String laboratory;
    private static String description;
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Analysis.id = id;
    }

    public static String getLaboratory() {
        return laboratory;
    }

    public static void setLaboratory(String laboratory) {
        Analysis.laboratory = laboratory;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Analysis.description = description;
    }

    public Analysis(String code, int payedAmount, int reimbursementRate) {
        super(code, payedAmount, reimbursementRate);
    }
    @Override
    public int reimbursement_total(int payedAmount, int reimbursementRate) {
        return 0;
    }
}
