/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.reports.DeliveryReceipt.model;

import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Animal.model.AnimalModel;
import br.com.uem.iss.petshop.Company.model.Company;
import br.com.uem.iss.petshop.Company.model.CompanyListModel;
import br.com.uem.iss.petshop.Company.model.CompanyModel;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Customer.model.CustomerModel;
import br.com.uem.iss.petshop.Utils.DateUtil;
import java.util.Date;
import java.util.List;

/**
 *
 * @author EDUARDO
 */

/*
[RF005] Comprovante de Entrega
Descrição: Deve ser possível imprimir um comprovante de entrega do PET após a execução da Ordem de Serviço. 
Contendo informações da empresa, data e número no topo. 
No corpo devem conter informações do PET e do seu dono. 
Dever ter um pequeno termo de entrega e um local para o dono assinar.
Prioridade: Essencial
Atores: Vendedor
Requisitos Associados: RF004
*/
public class DeliveryReceipt {

    
    private CompanyModel companyModel;
    private AnimalModel animalModel;
    private CustomerModel customerModel;
    
    public DeliveryReceipt() {
        animalModel = new AnimalModel();
        companyModel = new CompanyModel();
        customerModel = new CustomerModel();
        Company company = getCompany();
        if (company != null)
            companyModel.setCompany(company);
    }
    
    private Company getCompany() {
        CompanyListModel companyListModel = new CompanyListModel();
        companyListModel.initialize();
        List<Company> companys = companyListModel.getCompanys();
        if (companys.size() <= 0)
            return null;
        return companys.get(0);
    }
    
    public String getCompanyName() {
        return companyModel.getNome();
    }
    
    public String getCompanyCity() {
        return companyModel.getCidade();
    }
    
    public String getAnimalName() {
        return animalModel.getName();
    }
    
    public String getCustomerName() {
        return customerModel.getName();
    }
    
    public String getCustomerLastName() {
        return customerModel.getLastName();
    }
    
    public String getDate(){
        DateUtil dateUtil = new DateUtil();
        Date currentDate = dateUtil.getCurrentDate();
        String dateString = dateUtil.toString(currentDate);
        return dateString;
    }

    void initialize() {
        animalModel.initialize();
        customerModel.initialize();
        companyModel.initialize();
    }

    void setCustomer(Customer customer) {
        customerModel.setCustomer(customer);
    }

    public Customer getCustomer() {
        return customerModel.getCustomer();
    }

    public void setAnimal(Animal animal) {
        animalModel.setAnimal(animal);
    }

    public Animal getAnimal() {
        return animalModel.getAnimal();
    }
            
}
