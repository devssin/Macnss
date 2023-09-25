package org.cnss.Classes;

public class Scanner extends Document{
    private static String laboratory;
    private static String description;
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


    public Scanner(int id ,String code, String payedAmount, String reimbursementRate) {
        super(id, code, payedAmount, reimbursementRate);
    }


}
