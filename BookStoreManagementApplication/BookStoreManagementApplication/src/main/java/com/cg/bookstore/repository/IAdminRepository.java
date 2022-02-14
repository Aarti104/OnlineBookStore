package com.cg.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.bookstore.entity.Admin;


public interface IAdminRepository extends CrudRepository<Admin,Integer>,CustomAdminRepository
{
	

}
