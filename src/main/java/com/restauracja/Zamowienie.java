package com.restauracja;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Zamowienie {

    @Id
    private int NumerZamowienia;
    private int NumerStolika;
    private int Oplacone;

    public int getNumerZamowienia() {
        return NumerZamowienia;
    }

    public void setNumerZamowienia(int numerZamowienia) {
        NumerZamowienia = numerZamowienia;
    }

    public int getNumerStolika() {
        return NumerStolika;
    }

    public void setNumerStolika(int numerStolika) {
        NumerStolika = numerStolika;
    }

    public int getOplacone() {
        return Oplacone;
    }

    public void setOplacone(int oplacone) {
        Oplacone = oplacone;
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "NumerZamowienia=" + NumerZamowienia +
                ", NumerStolika=" + NumerStolika +
                ", Oplacone=" + Oplacone +
                '}';
    }
}
