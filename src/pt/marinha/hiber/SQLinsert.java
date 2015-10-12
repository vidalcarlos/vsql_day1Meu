/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.marinha.hiber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLinsert {
    private static final Logger LOG = Logger.getLogger(SQLinsert.class.getName());

    static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/Formandos";
    static final String USER = "app";
    static final String PASS = "app";

    public static void main(String[] args) {
        LOG.setLevel(Level.ALL); // altera o nivel de log.
        try {
            LOG.log(Level.INFO, "Registo do driver");
            Class.forName(JDBC_DRIVER);
            LOG.log(Level.INFO, "Driver registado OK!");
        } catch (ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        Connection c = null;
        PreparedStatement p = null;
        try {
            LOG.info("Activar conexão");
            c = DriverManager.getConnection(DB_URL, USER, PASS);
//            LOG.fine("Conexão OK");// este log só aparece em debug
            LOG.info("Conexão OK");
        } catch (SQLException ex) {
            Logger.getLogger(SQLinsert.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
