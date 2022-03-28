package com.pojo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tw_name_mapping")
public class TwNameMappingEntity {
    private int id;
    private String stockId;
    private String stockName;
    private double price;

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
    @Column(name = "stock_id")
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "stock_name")
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwNameMappingEntity that = (TwNameMappingEntity) o;
        return id == that.id && Objects.equals(stockId, that.stockId) && Objects.equals(stockName, that.stockName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stockId, stockName);
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
