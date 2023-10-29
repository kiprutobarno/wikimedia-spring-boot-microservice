package com.tuts.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuts.db.model.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}
