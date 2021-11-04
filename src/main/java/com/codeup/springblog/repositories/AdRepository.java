package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {

    List<Ad> findByTitle(String title); // select * from ads where title = :title
    Ad findByDescription(String desc);

    @Query(
            nativeQuery = true,
            value="select * from ads where title like :term%"
    )
    List<Ad> findByTitleLike(@Param("term")String term);

}
