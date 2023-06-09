package ru.otus.crm.repository;

import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.otus.crm.model.Manager;
import ru.otus.crm.model.TableWithPk;


public interface TableWithPkRepository extends CrudRepository<TableWithPk, TableWithPk.Pk> {

    List<TableWithPk> findAll();

    @Modifying
    @Query("insert into table_with_pk(id_part1, id_part2, value) VALUES (:#{#tableWithPk.pk.idPart1}, :#{#tableWithPk.pk.idPart2}, :#{#tableWithPk.value})")
    void saveEntry(@Nonnull @Param("tableWithPk") TableWithPk tableWithPk);

    @Override
    @Query("select * from table_with_pk where id_part1 = :#{#pk.idPart1} and id_part2 = :#{#pk.idPart2}")
    Optional<TableWithPk> findById(@Param("pk") TableWithPk.Pk pk);
}
