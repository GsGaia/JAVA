package br.com.fiap.Gs.Gaia.Repository;

import br.com.fiap.Gs.Gaia.Models.Requestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestionRepository extends JpaRepository<Requestion, Long> {
}
