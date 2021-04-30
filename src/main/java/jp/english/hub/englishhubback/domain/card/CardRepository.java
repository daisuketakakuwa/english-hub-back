package jp.english.hub.englishhubback.domain.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, String>, JpaSpecificationExecutor<CardEntity> {

    @Modifying
    @Query(value = "UPDATE CardEntity card " + "SET " + "  card.title = :title ," + "  card.content = :content "
            + "WHERE " + "  card.id = :id ")
    public void updateCardById(@Param("id") String id, @Param("title") String title, @Param("content") String content);

}
