package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int time;

    public Ticket() {
    }

    public Ticket(int id, int price, String airportFrom, String airportTo, int time) {
        this.id = id;
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public int getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                price == ticket.price &&
                Objects.equals(airportFrom, ticket.airportFrom) &&
                Objects.equals(airportTo, ticket.airportTo) &&
                time == ticket.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, airportFrom, airportTo, time);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", airportFrom='" + airportFrom + '\'' +
                ", airportTo='" + airportTo + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public int compareTo(Ticket o) {
        int diff = this.price - o.price;
        if (diff == 0) {
            return 0;
        } else if (diff < 0) {
            return -1;
        } else {
            return 1;
        }

    }
}
