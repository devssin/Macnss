package org.cnss.Classes;

import java.util.List;

public class ReimbursementCase {
    private List<Document> documents;

    // Constructor, getter, and setter for documents

    public ReimbursementCase(List<Document> documents) {
        this.documents = documents;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    // Other methods for ReimbursementCase class
}
