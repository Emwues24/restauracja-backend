package com.restauracja.services;

import com.restauracja.models.Zamowienie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZamowienieService {

    public List<Zamowienie> getZamowienieData();

    public void deleteById(String id);

    public void updateById(String id);

    public void createNew(String str);
}
