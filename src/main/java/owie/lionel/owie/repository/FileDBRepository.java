package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import owie.lionel.owie.domain.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
