package db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB {
    private static Connection conn = null;

    public static Connection dbConnect() {

        if (conn == null) {
            Properties prop = dbProperties();
            String url = prop.getProperty("dburl");

            try {
                conn = DriverManager.getConnection(url, prop);
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static Properties dbProperties() {
        try (FileInputStream fs = new FileInputStream("sistema_rh\\main\\src\\db\\db.properties")) {
            Properties prop = new Properties();
            prop.load(fs);
            return prop;
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }

    }

    public static void dbClose() {
        try {
            conn.close();
        } catch (Exception e) {
            throw new DbException(e.getMessage());    
        }
    }

}
