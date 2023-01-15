package com.mypet.MyPet.repositories;

import com.mypet.MyPet.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {
    @Query("SELECT p FROM PetEntity p WHERE p.person.id = :userId")
    List<PetEntity> findAllByUserId(@Param("userId") Long userId);
}
