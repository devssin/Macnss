package org.cnss.Classes;

public class Medicine extends Document {
    private String codeBarre;
    private String name;
    private String factory;

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public Medicine(String code, String codeBarre, String name, int payedAmount, int reimbursementRate) {
        super(code, payedAmount, reimbursementRate);
        this.codeBarre = codeBarre;
        this.name = name;
    }

}

