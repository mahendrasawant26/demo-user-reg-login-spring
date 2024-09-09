package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.UserAuth;

@Repository
@Transactional("mysqlTransactionManager")
public interface UserAuthRepository extends JpaRepository<UserAuth, String>{
	@Modifying
	@Query("UPDATE UserAuth auth SET auth.expiredTime = :expiredTime WHERE auth.email = :email")
	public int updateByExpiredDate(@Param("email")String email,@Param("expiredTime")Date expiredTime);

	public UserAuth findByTokenId(String tokenId);

}
