package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.User;

@Repository
@Transactional("mysqlTransactionManager")
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmailAndPassword(String email, String password);

	@Query("select us.email from User us where us.id = :userId")
	public Object getUserEmailById(@Param("userId") Long userId);

	User findByEmail(String email);

}
