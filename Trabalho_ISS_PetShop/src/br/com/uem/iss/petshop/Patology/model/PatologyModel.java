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
        
        Byte values[] = new Byte[] {32};
        
        if (patology.getDescription() == null)
            patology.setDescription(values);
        if (patology.getName() == null)
            patology.setName("");
                 
    }

    @Override
    public void persist() {
        try {
            patologyDAO.persist(patology);
            updateObservers("Dados gravados com sucesso");
        } catch (Exception e) {
            updateErrorMessage("Erro ao gravar os dados no banco de dados"+e.getMessage());
        }
        
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

    public Byte[] getDescription() {
        return patology.getDescription();
    }

    public void setDescription(Byte description[]) {
        patology.setDescription(description);
    }
    
    
}
