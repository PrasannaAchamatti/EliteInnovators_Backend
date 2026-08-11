package com.assistivekart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/orders")
    public List<Map<String, Object>> getAllOrders() {
        String sql = "SELECT o.order_id as id, u.username as customerName, o.created_at as date, " +
                     "o.total_amount as amount, COALESCE(d.tracking_status, o.status) as status " +
                     "FROM orders o " +
                     "JOIN users u ON o.user_id = u.user_id " +
                     "LEFT JOIN order_details d ON o.order_id = d.order_id " +
                     "ORDER BY o.created_at DESC";
        return jdbcTemplate.queryForList(sql);
    }

    @PutMapping("/orders/{id}/status")
    public void updateOrderStatus(@PathVariable String id, @RequestBody Map<String, String> payload) {
        String status = payload.get("status");
        if (status == null) {
            throw new IllegalArgumentException("Invalid status");
        }
        
        String sqlDetails = "UPDATE order_details SET tracking_status = ? WHERE order_id = ?";
        jdbcTemplate.update(sqlDetails, status, id);
        
        String topStatus = "SUCCESS";
        if (status.equals("FAILED") || status.equals("CANCELLED")) topStatus = "FAILED";
        if (status.equals("PENDING") || status.equals("PLACED")) topStatus = "PENDING";
        
        String sqlOrders = "UPDATE orders SET status = ? WHERE order_id = ?";
        jdbcTemplate.update(sqlOrders, topStatus, id);
    }

    @GetMapping("/customers")
    public List<Map<String, Object>> getAllCustomers() {
        String sql = "SELECT u.user_id as id, u.username as name, u.email, " +
                     "(SELECT COUNT(*) FROM orders o WHERE o.user_id = u.user_id) as orders, " +
                     "u.created_at as joined " +
                     "FROM users u WHERE u.role = 'CUSTOMER' " +
                     "ORDER BY u.created_at DESC";
        return jdbcTemplate.queryForList(sql);
    }
}
