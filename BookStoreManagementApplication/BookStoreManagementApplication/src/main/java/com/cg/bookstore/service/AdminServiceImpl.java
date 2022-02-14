package com.cg.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Admin;
import com.cg.bookstore.entity.Book;
import com.cg.bookstore.repository.IAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository adminrepo;
	
	@Override
	public Admin addAdmin(Admin admin) {
		return adminrepo.save(admin);
	}

	@Override
	public boolean deleteAdmin(int adminId) {
		adminrepo.deleteById(adminId);
		return true;
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> list=(List<Admin>) adminrepo.findAll();
		return null;
	}

	
	@Override
	public Admin getAdminById(int adminId) {
		return adminrepo.findById(adminId).get();
	}

	

}
