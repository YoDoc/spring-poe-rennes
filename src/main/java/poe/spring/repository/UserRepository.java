package poe.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poe.spring.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByLogin(String login);
}
