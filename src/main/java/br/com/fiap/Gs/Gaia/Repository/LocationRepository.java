package br.com.fiap.Gs.Gaia.Repository;

import br.com.fiap.Gs.Gaia.Models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByActiveTrue();

}
