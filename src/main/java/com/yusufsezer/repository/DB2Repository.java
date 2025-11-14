package com.yusufsezer.repository;

import com.yusufsezer.model.Contact;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DB2Repository extends SQLRepository {

    public DB2Repository(Connection connection) {
        super(connection);
    }

    @Override
    protected void createTable() {
        String sql = "CREATE TABLE contacts ("
                + Contact.ID + " INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, "
                + Contact.FIRST_NAME + " VARCHAR(100), "
                + Contact.LAST_NAME + " VARCHAR(100), "
                + Contact.EMAIL + " VARCHAR(100), "
                + Contact.PHONE_NUMBER + " VARCHAR(30), "
                + Contact.ADDRESS + " VARCHAR(255), "
                + Contact.WEB_ADDRESS + " VARCHAR(255), "
                + Contact.NOTES + " VARCHAR(1024))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException exception) {
            logException(exception);
            throw new RuntimeException("Failed to create table.");
        }
    }

}
