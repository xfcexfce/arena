package com.example.arena.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//typ obiektu przechowywanego w bazie, typ klucza glownego
public interface CreatureRepository extends CrudRepository<CreatureEntity, Integer> {
}

