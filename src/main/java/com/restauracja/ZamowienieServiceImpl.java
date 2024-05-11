package com.restauracja;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONFilter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.restauracja.RestauracjaApplication.nextID;

@Service
public class ZamowienieServiceImpl implements ZamowienieService {
    @Autowired
    static List<Zamowienie> listaZamowien = new ArrayList<>();

    Connection connection;

    public ZamowienieServiceImpl() throws SQLException {
        connection=DBUtil.getConnection();
    }

    @Override
    public void deleteById(String id){
        try {
            PreparedStatement stmt = connection.prepareStatement(String.format("Delete from zamowienie where numer_zamowienia='%s';",id));
            stmt.executeUpdate();
            stmt = connection.prepareStatement(String.format("Delete from zamowione_produkty where numer_zamowienia='%s';",id));
            stmt.executeUpdate();
        }catch(SQLException e){e.printStackTrace();}
    }

    @Override
    public void updateById(String id){
        try {
            PreparedStatement stmt = connection.prepareStatement(String.format("select * from zamowienie where numer_zamowienia='%s';",id));
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int opl = rs.getInt(3);
            if (opl==1) opl=0;
            else opl=1;
            stmt = connection.prepareStatement(String.format("update zamowienie set oplacone=%d where numer_zamowienia='%s';",opl,id));
            stmt.executeUpdate();
        }catch(SQLException e){e.printStackTrace();}
    }

    @Override
    public void createNew(String str){
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = " +
                    "\"Restauracja\" AND TABLE_NAME = \"zamowienie\"");
            ResultSet rs= stmt.executeQuery();
            rs.next();
            nextID=rs.getInt(1);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(str);
            int stolik = jsonNode.get("stolik").asInt();
            int oplacone = jsonNode.get("oplacone").asInt();
            stmt = connection.prepareStatement(String.format("insert into zamowienie VALUES(NULL, %d, %d)",stolik,oplacone));
            stmt.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }

    @Override
    public List<Zamowienie> getZamowienieData(){

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ZAMOWIENIE");
            ResultSet rs = stmt.executeQuery();
            listaZamowien.clear();
            while(rs.next()){
                Zamowienie zam = new Zamowienie();
                zam.setNumerZamowienia(rs.getInt(1));
                zam.setNumerStolika(rs.getInt(2));
                zam.setOplacone(rs.getInt(3));
                listaZamowien.add(zam);
            }
        }catch(SQLException e){e.printStackTrace();}
        return listaZamowien;
    }
}
