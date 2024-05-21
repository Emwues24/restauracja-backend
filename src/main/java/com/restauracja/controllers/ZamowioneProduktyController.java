package com.restauracja.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restauracja.models.ZamowioneProdukty;
import com.restauracja.repos.ZamowioneProduktyRepo;
import com.restauracja.services.ZamowienieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.restauracja.DBUtil.connection;
import static com.restauracja.RestauracjaApplication.nextID;

@RestController
@CrossOrigin
public class ZamowioneProduktyController {

    static List<ZamowioneProdukty> listazamp = new ArrayList<>();

    @Autowired
    private ZamowioneProduktyRepo zamprepo;

    @Autowired
    private ZamowienieService zs;

    @GetMapping("/zamow")
    public List<ZamowioneProdukty> getProdukty(){
try{
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Zamowione_produkty");
        ResultSet rs = stmt.executeQuery();
        listazamp.clear();
        while(rs.next()){
            ZamowioneProdukty zam = new ZamowioneProdukty();
            zam.setId(rs.getInt(1));
            zam.setNumer_zamowienia(rs.getInt(2));
            zam.setProdukt_id(rs.getInt(3));
            zam.setProdukt(rs.getString(4));
            zam.setIlosc(rs.getInt(5));
            zam.setCena(rs.getInt(6));
            listazamp.add(zam);
        }
    }catch(SQLException e){e.printStackTrace();}
        return listazamp;
    }

    @PostMapping("/zamow/nowe")
    public void createZamowienie(@RequestBody String str)
    {
        try {
            ZamowioneProdukty zamp;
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNodeArray = objectMapper.readTree(str);

            if (jsonNodeArray.isArray()) {
                for (JsonNode jsonNode : jsonNodeArray) {
                    int id = jsonNode.get("id").asInt();
                    int quantity = jsonNode.get("quantity").asInt();

                    PreparedStatement stmt = connection.prepareStatement(String.format("SELECT * FROM produkty WHERE produkt_id = %d",id));
                    ResultSet rs= stmt.executeQuery();
                    rs.next();

                    zamp = new ZamowioneProdukty(nextID,id,rs.getString(2),quantity*rs.getInt(3),quantity*rs.getInt(4));
                    zamprepo.save(zamp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
