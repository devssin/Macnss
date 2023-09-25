package org.cnss.Classes;

import java.util.List;

public class ReimbursementCase {
    private static String status;

    private List<Document> documents;

    public ReimbursementCase(List<Document> documents, String status) {
        this.documents = documents;
        this.status = status;
    }
    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        ReimbursementCase.status = status;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

}
