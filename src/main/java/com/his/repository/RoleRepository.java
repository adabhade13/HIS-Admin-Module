package com.his.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.his.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Serializable>{
	
	@Query(value = "select roleName from RoleEntity")
	public List<String> findRoleName();

}
