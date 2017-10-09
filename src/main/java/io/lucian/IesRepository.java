package io.lucian;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by lucian on 07/10/2017.
 */
@RepositoryRestResource(path = "ies")
public interface IesRepository extends MongoRepository<IES, String> {
    List<IES> findAllByNome(@Param("nome") String nome);

    List<IES> findAllByNomeContains(@Param("nome") String nome);

}
