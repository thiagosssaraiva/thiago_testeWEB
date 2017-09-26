/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.WEB.dao;

import com.teste.WEB.entities.Driver;
import com.teste.WEB.factory.contextDB;
import com.teste.WEB.entities.Passenger;
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
public class PassengerDAO {

    public void Add(Passenger passenger) throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO passenger (nm_name, cpf, "
                + "dt_nas, status_driver, sexo) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = contextDB.createConnection();
            stmt = conn.prepareStatement(sql);

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, passenger.getNome());
            stmt.setString(2, passenger.getCPF());
            stmt.setString(3, passenger.getData_nascimento());
            stmt.setBoolean(4, passenger.isStatus());
            stmt.setString(5, passenger.getSexo());

            stmt.execute();

        } catch (Exception ex) {

        }
    }

    public List<Driver> listAll() throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "SELECT nm_name, cpf, dt_nas FROM passenger";

        List<Driver> lista = new ArrayList<Driver>();
        try {

            conn = contextDB.createConnection();
            stmt = conn.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Driver contato = new Driver();
                contato.setNome(resultSet.getString("nm_name"));
                contato.setCPF(resultSet.getString("cpf"));
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
