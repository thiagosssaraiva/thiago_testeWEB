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
public class DriverDao {

    public void Add(Driver contato) throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        

        String sql = " INSERT INTO driver (nm_name, cpf, ";
               sql+= " model_Car, dt_nas, status_driver, sexo) ";
               sql+= " VALUES (?, ?, ?, ?, ?, ?)";
               
               System.out.println(sql);

        try {
            conn = contextDB.createConnection();
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
        
        String sql = "SELECT nm_name, cpf, model_Car, dt_nas FROM driver";
        
        List<Driver> lista = new ArrayList<Driver>();
        try {

            conn = contextDB.createConnection();  
            stmt = conn.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Driver contato = new Driver();
                contato.setNome(resultSet.getString("nm_name"));
                contato.setCPF(resultSet.getString("cpf"));
                contato.setModelCar(resultSet.getString("model_Car"));
                contato.setData_nascimento(resultSet.getString("dt_nas"));

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
