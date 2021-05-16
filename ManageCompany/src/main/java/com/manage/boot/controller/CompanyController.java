package com.manage.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.manage.boot.model.Company;
import com.manage.boot.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	//display list of company
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listCompany",companyService.getAllCompany());
		return "index";
	}
    @GetMapping("/showCompanyForm")
	public String showCompanyForm(Model model) {
    	//create model attribute to bind form data
    	Company company = new Company();
    	model.addAttribute("company",company);
    	return "new_company";
		
	}
    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
    	//save company to database
    	companyService.saveCompany(company);
    	return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get company from the service
    	Company company = companyService.getCompanyById(id);

        // set company as a model attribute to pre-populate the form
        model.addAttribute("company", company);
        return "update_company";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.companyService.deleteCompanyById(id);
        return "redirect:/";
    }
}
