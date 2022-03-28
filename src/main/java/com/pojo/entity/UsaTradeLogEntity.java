package com.pojo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usa_trade_log")
public class UsaTradeLogEntity {
    private int id;
    private String tradeDate;
    private String stockId;
    private int quantity;
    private double amount;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "trade_date")
    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    @Basic
    @Column(name = "stock_id")
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsaTradeLogEntity that = (UsaTradeLogEntity) o;
        return id == that.id && quantity == that.quantity && Double.compare(that.amount, amount) == 0 && Objects.equals(tradeDate, that.tradeDate) && Objects.equals(stockId, that.stockId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tradeDate, stockId, quantity, amount);
    }
}
