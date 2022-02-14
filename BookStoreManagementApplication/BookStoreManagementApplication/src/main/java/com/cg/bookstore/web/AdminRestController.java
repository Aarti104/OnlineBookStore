package com.cg.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entity.Admin;
import com.cg.bookstore.service.IAdminService;

@RestController
@RequestMapping
public class AdminRestController {
	
	@Autowired
	IAdminService adminService;
	
	@PostMapping("/admin")
	public boolean addAdmin(@RequestBody Admin a)
	{
		adminService.addAdmin(a);
		return true;
	}
	
	@GetMapping("/admins")
	public List<Admin> listAdmin()
	{
		return adminService.getAllAdmin();
	}
	
	@DeleteMapping("admins/{adminId}")
	public boolean deleteAdmin(@PathVariable int adminId)
	{
		return adminService.deleteAdmin(adminId);
	}
	
	@GetMapping("admin/{adminId}")
	public Admin getAdminId(@PathVariable int adminId)
	{
		return adminService.getAdminById(adminId);
	}

}
