package owie.lionel.owie.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.Model.StoryTable;

public interface StorytableRepository extends JpaRepository <StoryTable, Long> {
}
