package com.restauracja.repos;


import com.restauracja.models.ZamowioneProdukty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZamowioneProduktyRepo extends JpaRepository<ZamowioneProdukty,Integer> {
    //ZamowioneProdukty(String str);
}
