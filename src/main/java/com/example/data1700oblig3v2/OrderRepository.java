package com.example.data1700oblig3v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreOrder (Order order) {
        String sql = "INSERT INTO Billett (movie, quantity, firstname, surname, email, phone) VALUES(?,?,?,?,?,?)";
        db.update(sql, order.getMovie(), order.getQuantity(), order.getFirstname(), order.getSurname(), order.getEmail(), order.getPhone());
    }

    public List<Order> hentAlleOrders() {
        String sql = "SELECT * FROM Billett ORDER BY surname";
        List<Order> alleOrders = db.query(sql, new BeanPropertyRowMapper<>(Order.class));
        return alleOrders;
    }

    public void slettAlleOrders(){
        String sql = "DELETE FROM Billett";
        db.update(sql);
    }
}