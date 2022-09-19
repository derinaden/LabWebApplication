package com.ozguryazilim.labwebapplication.repository;

import com.ozguryazilim.labwebapplication.entity.Rapor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RaporRepository extends JpaRepository<Rapor,Long> {

    List<Rapor> findByOrderByTarihDesc();
    List<Rapor> findByOrderByTarihAsc();

    @Query("SELECT r FROM Rapor r WHERE lower(r.hastaAdi) like lower(concat('%',:ara,'%')) "
            + "or lower(r.hastaSoyadi) like lower(concat('%',:ara,'%')) "+
            "or lower(r.hastaKimlikNo) like lower(concat('%',:ara,'%')) ")
    List<Rapor> findByHastaAdiContainingOrHastaSoyadiContainingOrHastaKimlikNoContaining(@Param("ara") String ara);
}
