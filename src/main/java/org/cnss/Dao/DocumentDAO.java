package org.cnss.Dao;

import com.mysql.cj.protocol.Resultset;
import org.cnss.Classes.Document;
import org.cnss.Classes.User;

import java.sql.ResultSet;

public interface DocumentDAO <document extends Document>{
    ResultSet getAllDocuments();
    boolean addDocument(document doc);
    boolean updateDocument(document doc);
}
