package jp.english.hub.englishhubback.domain.card;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, String>, JpaSpecificationExecutor<CardEntity> {

    public List<CardEntity> findAll();

}
