package com.dsw.TrabalhoDSW.repositories;
/**
 * @author Lucas Teixeira
 * @author Eduardo Buzzi
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsw.TrabalhoDSW.entities.Compromisso;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompromissoDAO extends JpaRepository<Compromisso, Integer> {

    @Query("select c from Compromisso c where c.contato.id = :id")
    List<Optional<Compromisso>> findByContatoId(@Param("id") Integer id);


    List<Compromisso> findByDataBetween(Date d1,Date d2);
}
