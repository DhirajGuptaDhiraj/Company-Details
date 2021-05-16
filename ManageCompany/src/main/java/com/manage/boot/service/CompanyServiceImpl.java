package com.manage.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.boot.model.Company;
import com.manage.boot.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	@Override
	public List<Company> getAllCompany() {

		return companyRepository.findAll();
	}
	@Override
	public void saveCompany(Company company) {
		this.companyRepository.save(company);

	}
	@Override
	public Company getCompanyById(long id) {
		Optional<Company> optional = companyRepository.findById(id);
		Company company = null;
		if(optional.isPresent()) {
			company = optional.get();
		}else {
			throw new RuntimeException("Company details not found for id :: "+id);
		}
		return company;
	}
	@Override
	public void deleteCompanyById(long id) {
		this.companyRepository.deleteById(id);
	}


}


