package com.example.data1700oblig3v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private OrderRepository rep;

    public final List<String> filmRegister = List.of("Barbie", "Oppenheimer", "Gutten og hegren", "Aftersun");

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return rep.hentAlleOrders();
    }

    @GetMapping("/hentFilmer")
    public List<String> hentFilmer () {
        return filmRegister;
    }

    @PostMapping("/orders")
    public void addOrder(@RequestBody Order order) {
        System.out.println("addOrder called");
        System.out.println(order);
        rep.lagreOrder(order);
    }

    @DeleteMapping("/orders")
    public void deleteOrders() {
        rep.slettAlleOrders();
    }
}