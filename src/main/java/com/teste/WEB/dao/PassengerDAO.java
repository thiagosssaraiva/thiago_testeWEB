/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.WEB.dao;

import com.teste.WEB.factory.contextDB;
import com.teste.WEB.entities.Passenger;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
