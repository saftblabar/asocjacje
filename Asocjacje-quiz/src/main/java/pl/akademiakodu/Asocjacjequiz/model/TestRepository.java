package pl.akademiakodu.Asocjacjequiz.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.Asocjacjequiz.model.Test;

@Repository
//Long - typ idka
    public interface TestRepository extends CrudRepository<Test, Long> {

}
