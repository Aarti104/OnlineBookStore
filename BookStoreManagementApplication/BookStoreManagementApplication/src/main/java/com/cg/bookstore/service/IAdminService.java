package com.cg.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Admin;
import com.cg.bookstore.entity.Book;

@Service
public interface IAdminService {
	
	public Admin addAdmin(Admin admin);
	public boolean deleteAdmin(int adminId);
	public List<Admin> getAllAdmin();
	public Admin getAdminById(int adminId);

}
