package org.cnss.Dao;

import org.cnss.Classes.Document;

import java.sql.ResultSet;

public interface DocumentDAO <document extends Document>{
    ResultSet getAllDocuments();
    boolean addDocument(document doc);
    boolean updateDocument(document doc);
}
