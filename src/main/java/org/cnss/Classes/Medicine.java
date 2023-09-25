package org.cnss.Classes;

public class Medicine extends Document{
    private static String codeBarre;
    private static String name;

    public static String getCodeBarre() {
        return codeBarre;
    }

    public static void setCodeBarre(String codeBarre) {
        Medicine.codeBarre = codeBarre;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Medicine.name = name;
    }

    public static String getFactory() {
        return factory;
    }

    public static void setFactory(String factory) {
        Medicine.factory = factory;
    }

    private static String factory;

    public Medicine(int id , String code, String payedAmount, String reimbursementRate) {
        super(id, code, payedAmount, reimbursementRate);
    }


}
