package com.example.Versi11.With.Validation.model.repository;

import com.example.Versi11.With.Validation.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByName(String name);

    //Menggunakan custome query menggunakan JPAQL
    @Query("SELECT p FROM ProductEntity p WHERE p.name = :name")
     ProductEntity findProductByName(@PathParam("name") String name);// nilai balikannya bukan list khusus mencari uniq

    @Query("SELECT p FROM ProductEntity p WHERE p.name LIKE :name")
     List<ProductEntity> findProductByNameLike(@PathParam("name") String name);
}
