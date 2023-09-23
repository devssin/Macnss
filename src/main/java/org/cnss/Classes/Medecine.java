package org.cnss.Classes;

public class Medecine extends Document{
    private static int id;
    private static String codeBarre;
    private static String name;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Medecine.id = id;
    }

    public static String getCodeBarre() {
        return codeBarre;
    }

    public static void setCodeBarre(String codeBarre) {
        Medecine.codeBarre = codeBarre;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Medecine.name = name;
    }

    public static String getFactory() {
        return factory;
    }

    public static void setFactory(String factory) {
        Medecine.factory = factory;
    }

    private static String factory;

    public Medecine(String code, int payedAmount, int reimbursementRate) {
        super(code, payedAmount, reimbursementRate);
    }

    @Override
    public int reimbursement_total(int payedAmount, int reimbursementRate) {
        return 0;
    }
}
