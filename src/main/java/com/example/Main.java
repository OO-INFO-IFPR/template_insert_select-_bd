package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.controllers.FabricaConexoes;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = FabricaConexoes.getInstance().getConnection();
        System.out.println("Conexão aberta!");
        String sql = "SELECT * FROM empregado";

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("nome"));
        }

        statement.close();
        // String sql = "INSERT INTO empregado (nome) VALUES (?)";
        // PreparedStatement statement = connection.prepareStatement(sql);
        // statement.setString(1, "Prof Luiz Efigenio ");

        // statement.execute();
        // statement.close();
        connection.close();
    }
}