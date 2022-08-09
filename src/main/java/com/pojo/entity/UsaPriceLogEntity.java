package com.pojo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usa_price_log")
public class UsaPriceLogEntity {
    private int id;
    private String date;
    private String stockId;
    private double open;
    private double high;
    private double low;
    private double close;
    private String volume;

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
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
    @Column(name = "open")
    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    @Basic
    @Column(name = "high")
    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    @Basic
    @Column(name = "low")
    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    @Basic
    @Column(name = "close")
    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    @Basic
    @Column(name = "volume")
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsaPriceLogEntity that = (UsaPriceLogEntity) o;
        return id == that.id && Double.compare(that.open, open) == 0 && Double.compare(that.high, high) == 0 && Double.compare(that.low, low) == 0 && Double.compare(that.close, close) == 0 && Objects.equals(date, that.date) && Objects.equals(stockId, that.stockId) && Objects.equals(volume, that.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, stockId, open, high, low, close, volume);
    }
}
