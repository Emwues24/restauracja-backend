package com.restauracja.controllers;

import com.restauracja.models.Zamowienie;
import com.restauracja.services.ZamowienieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ZamowienieController {

    @Autowired
    private ZamowienieService zamService;

    @GetMapping("/zamowienia")
    public List<Zamowienie> getZamowienie(){
     return this.zamService.getZamowienieData();
    }

    @DeleteMapping("/zamowienia/delete/{id}")
    public void deleteZamowienie(@PathVariable("id") String id) {
        zamService.deleteById(id);
    }
    @DeleteMapping("/zamowienia/update/{id}")
    public void updateOplacone(@PathVariable("id") String id){
        zamService.updateById(id);
    }
    @PostMapping("/zamowienia/create")
    public void createZamowienie(@RequestBody String str){zamService.createNew(str);}
}
