/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Login.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Utils.DateUtil;
import java.util.List;

/**
 *
 * @author Ricardo Andrade
 */
public class LoginModel extends AbstractModel{

    final private LoginDAO loginDAO;
    private Login login;

    public void setCustomer(List<Customer> customer) {
        login.setCustomer(customer);
    }

    public String getName() {
        return login.getName();
    }

    public void setName(String name) {
        login.setName(name);
    }

    public String getLogin() {
        return login.getLogin();
    }

    public void setLogin(String login) {
        this.login.setLogin(login);
    }

    public String getSenha() {
        return login.getSenha();
    }

    public void setSenha(String senha) {
        login.setSenha(senha);
    }

    public LoginModel() {
        super();
        login = new Login();
        loginDAO = new LoginDAO();
    }

    
    @Override
    public void initialize() {
        DateUtil dateUtil = new DateUtil();
        if (login == null)
            login = new Login();
        if (login.getName() == null)
            login.setName("");
        if (login.getLogin() == null)
            login.setLogin("");
        if (login.getSenha() == null)
            login.setSenha("");
    }

    @Override
    public void persist() {
        try {
            loginDAO.persist(login);
            updateObservers("Dados gravados com sucesso");
        } catch (Exception e) {
            updateErrorMessage("Erro ao gravar os dados no banco de dados"+e.getMessage());
        }
        
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        login = (Login)entity;
    }
    
}
