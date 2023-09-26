package org.cnss.Classes;
import org.cnss.Classes.Category;
public class Consultation extends Document {
    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    private String doctor;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private Category category;

    public Consultation(String code, int payedAmount, int reimbursementRate, Category category) {
        super(code, payedAmount, reimbursementRate);
        this.category = category;
    }
}
