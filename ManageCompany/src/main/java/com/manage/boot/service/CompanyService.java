package com.manage.boot.service;

import java.util.List;

import com.manage.boot.model.Company;

public interface CompanyService {
	List<Company> getAllCompany();
	void saveCompany(Company company);
	Company getCompanyById(long id);
	void deleteCompanyById(long id);
 
}
