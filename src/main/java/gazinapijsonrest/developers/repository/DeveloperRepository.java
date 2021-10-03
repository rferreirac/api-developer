package gazinapijsonrest.developers.repository;

import gazinapijsonrest.developers.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    @Query(value = "SELECT * FROM developer d WHERE " +
            "(  ?1 IS NOT NULL  AND  d.nome like ?1  ) OR " +
            "(  ?2 IS NOT NULL  AND  d.sexo like ?2  ) OR " +
            "(  ?3 IS NOT NULL  AND  d.idade=?3 ) OR " +
            "(  ?4 IS NOT NULL  AND  d.hobby like ?4 ) OR " +
            "(  ?5 IS NOT NULL  AND  d.datanascimento=?5 )  "
            , nativeQuery = true)
    List<Developer> findBy(String nome, Character sexo, Integer idade, String hobby, Date dataNascimento);


}
