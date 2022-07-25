package ifpe.br.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpe.br.model.UserBookStore;

@Repository
public interface UserRepository extends JpaRepository<UserBookStore,Long>{
	Optional<UserBookStore> findByLogin(String login);
}
