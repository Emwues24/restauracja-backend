package com.restauracja;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="zamowione_produkty")
public class ZamowioneProdukty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numer_zamowienia;
    private int produkt_id;
    private String produkt;
    private int ilosc;
    private int cena;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumer_zamowienia() {
        return numer_zamowienia;
    }

    public void setNumer_zamowienia(int numer_zamowienia) {
        this.numer_zamowienia = numer_zamowienia;
    }

    public int getProdukt_id() {
        return produkt_id;
    }

    public void setProdukt_id(int produkt_id) {
        this.produkt_id = produkt_id;
    }

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public ZamowioneProdukty(int numer_zamowienia, int produkt_id, String produkt, int ilosc, int cena) {
        this.numer_zamowienia = numer_zamowienia;
        this.produkt_id = produkt_id;
        this.produkt = produkt;
        this.ilosc = ilosc;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "ZamowioneProdukty{" +
                "numer_zamowienia=" + numer_zamowienia +
                ", produkt='" + produkt + '\'' +
                ", ilosc=" + ilosc +
                ", cena=" + cena +
                '}';
    }
}
