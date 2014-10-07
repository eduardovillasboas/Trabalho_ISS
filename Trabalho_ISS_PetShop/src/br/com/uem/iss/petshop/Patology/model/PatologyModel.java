/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Patology.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;

/**
 *
 * @author EDUARDO
 */
public class PatologyModel extends AbstractModel{

    final private PatologyDAO patologyDAO;
    private Patology patology;
    public PatologyModel() {
        patologyDAO = new PatologyDAO();
    }

    @Override
    public void initialize() {
        if (patology == null)
            patology = new Patology();
        
        
        if (patology.getDescription() == null)
            patology.setDescription("");
        if (patology.getName() == null)
            patology.setName("");
                 
    }

    @Override
    public Boolean persist() {
        if (patology.getDescription().isEmpty() ||
            patology.getName().isEmpty()){
            updateErrorMessage("Todos os campos da patologia são obrigatórios");
        }else {
            try {
                patologyDAO.persist(patology);
                updateObservers("Dados gravados com sucesso");
                return true;
            } catch (Exception e) {
                updateErrorMessage("Erro ao gravar os dados no banco de dados"+e.getMessage());
            } finally {
                patologyDAO.close();
            }
        }
        return false;
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        patology = (Patology)entity;
    }

    public String getName() {
        return patology.getName();
    }

    public void setName(String name) {
        patology.setName(name);
    }

    public String getDescription() {
        return patology.getDescription();
    }

    public void setDescription(String description) {
        patology.setDescription(description);
    }
    
    
}
