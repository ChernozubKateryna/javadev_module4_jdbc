package com.goit.feature.database;

import com.goit.feature.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) throws IOException, SQLException {
        String initDbFileName = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);

        String sql = String.join(
                "\n",
                Files.readAllLines(Paths.get(initDbFileName))
        );

        Database database = Database.getInstance();

        Statement st = database.getConnection().createStatement();
        st.executeUpdate(sql);
    }
}
