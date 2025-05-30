package br.com.fiap.Gs.Gaia.Repository;

import br.com.fiap.Gs.Gaia.Models.Location;
import br.com.fiap.Gs.Gaia.Models.Requestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestionRepository extends JpaRepository<Requestion, Long> {
    List<Requestion> findByLocation(Location location);

}
