/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Company.model;
import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Interfaces.ObserverModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class CompanyModel extends AbstractModel {

    private Company company;
    private final CompanyDAO companyDAO;

    private final ArrayList<ObserverModel> updateObservers;
    private final ArrayList<ObserverModel> errorMessageObservers;

    /**
     *
     */
    public CompanyModel() {
        updateObservers = new ArrayList<>();
        errorMessageObservers = new ArrayList<>();
        company = new Company();
        companyDAO = new CompanyDAO();
    }

    @Override
    public void initialize() {
        if (company == null) {
            company = new Company();
        }

        if (company.getNome() == null) {
            company.setNome("");
        }                
        if (company.getTelefone() == null) {
            company.setTelefone("");
        }
        if (company.getEmail() == null) {
            company.setEmail("");
        }
        if (company.getEndereco() == null) {
            company.setEndereco("");
        }
        if (company.getCidade() == null) {
            company.setCidade("");
        }
        if (company.getEstado() == null) {
            company.setEstado("");
        }
        if (company.getCep() == null) {
            company.setCep("");
        } 
        updateObservers(null);
    }

    @Override
    public Boolean persist() {
        try {
            if ( company.getNome().isEmpty() || company.getTelefone().isEmpty() || company.getEmail().isEmpty() || company.getEndereco().isEmpty() || company.getCidade().isEmpty() || company.getEstado().isEmpty() || company.getCep().isEmpty() ) {
                throw new Exception( "Algum campo obrigatório não está preenchido!" );
            }
            companyDAO.persist(company);
            updateObservers("Dados gravados com sucesso.o Código da empresa é: " + company.getID());
            return true;
        } catch (Exception e) {
            updateErrorMessage("Erro ao gravar os dados no banco de dados. " + e.getMessage());
            return false;
        }
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        company = (Company) entity;
    }

    public String getNome() {
        return company.getNome();
    }

    public void setNome(String nome) {
        company.setNome(nome);
    }

    public String getTelefone() {
        return company.getTelefone();
    }

    public void setTelefone(String telefone) {
        company.setTelefone(telefone);
    }
    
    public String getEmail() {
        return company.getEmail();
    }

    public void setEmail(String email) {
        company.setEmail(email);
    }
    
    public String getEndereco() {
        return company.getEndereco();
    }

    public void setEndereco(String endereco) {
        company.setEndereco(endereco);
    }
    
    public String getCidade() {
        return company.getCidade();
    }

    public void setCidade(String cidade) {
        company.setCidade(cidade);
    }
    
    public String getEstado() {
        return company.getEstado();
    }

    public void setEstado(String estado) {
        company.setEstado(estado);
    }
    
    public String getCep() {
        return company.getCep();
    }

    public void setCep(String cep) {
        company.setCep(cep);
    }  
    
    public Company getCompany() {
        return company;
    }

    public void setCompany() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
