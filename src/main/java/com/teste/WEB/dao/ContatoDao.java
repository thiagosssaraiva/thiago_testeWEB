package com.teste.WEB.dao;

import com.teste.WEB.factory.contextDB;
import com.teste.WEB.entities.Driver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class ContatoDao {

    public void Add(Driver contato) throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO driver (nm_name, cpf, "
                + "model_Car, dt_nas, status_driver, sexo) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = contextDB.createConnection();
            stmt = conn.prepareStatement(sql);

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getCPF());
            stmt.setString(3, contato.getModelCar());
            stmt.setString(4, contato.getData_nascimento());
            stmt.setBoolean(5, contato.isStatus());
            stmt.setString(6, contato.getSexo());

            stmt.execute();

        } catch (Exception ex) {

        }
    }

    public List<Driver> listAll() throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "SELECT NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO FROM TB_CONTATO";
        
        List<Driver> lista = new ArrayList<Driver>();
        try {

            conn = contextDB.createConnection();  
            stmt = conn.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Driver contato = new Driver();
                contato.setNome(resultSet.getString("NM_CONTATO"));
                contato.setData_nascimento(resultSet.getString("DT_NASCIMENTO"));

                lista.add(contato);
            }

        } catch (SQLException e) {
            System.out.println("Não foi possivel executar.");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar stmt.");
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conn.");
                }
            }
        }
        return lista;
    }
}
