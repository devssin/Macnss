package org.cnss.Classes;

public class Radio extends Document{
    private static String radiologist;
    private static String description;
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

    public Radio(int id ,String code, String payedAmount, String reimbursementRate) {
        super(id, code, payedAmount, reimbursementRate);
    }

}
