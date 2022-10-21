package Backup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import Conexion.Conexion;
import java.sql.SQLException;

public class Backup {

//        public static void main(String[]args) throws InstantiationException, SQLException, IllegalAccessException{
        
    public boolean Copiaseguridad() {
        try {

            Process p = Runtime
                    .getRuntime()
                    .exec("C:/xampp/mysql/bin/mysqldump -u root lossocios");
            
            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\Downloads\\Backup.sql");

            byte[] buffer = new byte[1000];

            int leido = is.read(buffer);

            while (leido > 0) {
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);

            }

            fos.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return true;
    }

}
