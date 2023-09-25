package org.cnss.Classes;

public class Analysis extends Document {
    private static String laboratory;
    private static String description;

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

    public Analysis(int id, String code, String payedAmount, String reimbursementRate) {
        super(id, code, payedAmount, reimbursementRate);
    }
}
