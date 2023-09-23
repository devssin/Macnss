package org.cnss.Classes;

public class Radio extends Document{
    private static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Radio.id = id;
    }

    public static String getRadiologist() {
        return radiologist;
    }

    public static void setRadiologist(String radiologist) {
        Radio.radiologist = radiologist;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Radio.description = description;
    }

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
