package com.example.virtualgarden3.dao;

import com.example.virtualgarden3.db.DbUtil;
import com.example.virtualgarden3.model.AfricanViolet;
import com.example.virtualgarden3.model.Plant;
import com.example.virtualgarden3.model.SoilType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlantDAO {
    public static int addPlant(Plant plant, int userId) throws SQLException {
        String sql = "INSERT INTO plant (userId, type, waterLevel) VALUES (?, ?, ?)";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, userId);
            stmt.setString(2, plant.getName());
            stmt.setInt(3, plant.getWaterLevel());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating plant failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the generated plantId
                } else {
                    throw new SQLException("Creating plant failed, no ID obtained.");
                }
            }
        }
    }

    public static void updatePlant(Plant plant) throws SQLException {
        String sql = "UPDATE plant SET waterLevel = ? WHERE plantId = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, plant.getWaterLevel());
            stmt.setInt(2, plant.getId());

            stmt.executeUpdate();
        }
    }

    public static List<Plant> getPlantsByUserId(int userId) throws SQLException {
        List<Plant> plants = new ArrayList<>();
        String sql = "SELECT * FROM plant WHERE userId = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Create appropriate plant based on type
                Plant plant;
                String type = rs.getString("type");
                int plantId = rs.getInt("plantId");

                int waterLevel = rs.getInt("waterLevel");

                plant = new AfricanViolet(plantId, type, SoilType.LIGHT_SOIL);


                plant.setWaterLevel(waterLevel);
                plants.add(plant);
            }
        }
        return plants;
    }
}
