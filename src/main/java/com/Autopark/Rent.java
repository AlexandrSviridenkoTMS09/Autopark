package com.Autopark;

import javax.xml.crypto.Data;
import java.util.Date;

public class Rent {
    Date data;
    double rent;

    public Rent() {
    }

    public Rent(Date data, double rent) {
        this.data = data;
        this.rent = rent;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }
}
