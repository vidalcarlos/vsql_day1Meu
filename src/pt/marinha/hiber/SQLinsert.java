/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.marinha.hiber;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
            LOG.log(Level.SEVERE, null, ex);
        }

        //criar obj formando
        Formando f1 = new Formando();
        f1.nome = "Antoniod";
        f1.apelido = "Carlos";
        f1.nii = "126322";
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-mm-dd");
        try {
            f1.dataNascimento = sdf.parse("1970-09-01");
        } catch (ParseException ex) {
            LOG.warning("Problemas na criação da data ");
        }
        String q = "INSERT INTO formando (NOME, APELIDO, NII, DATANASCIMENTO) VALUES(?,?,?,?)";
        try{
            p = c.prepareStatement(q);
        p.setString(1, f1.nome);
        p.setString(2, f1.apelido);
        p.setString(3, f1.nii);
        p.setDate(4, new Date(f1.dataNascimento.getTime()));

        p.executeUpdate();
        LOG.info("Registo na base de dados OK");
        }
        catch (SQLException ex){
            LOG.severe(ex.toString());
        }
    }

}
