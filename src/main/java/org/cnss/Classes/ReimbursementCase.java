package org.cnss.Classes;

import java.util.List;

public class ReimbursementCase {
    private List<Document> documents;

    public ReimbursementCase(List<Document> documents) {
        this.documents = documents;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

}
