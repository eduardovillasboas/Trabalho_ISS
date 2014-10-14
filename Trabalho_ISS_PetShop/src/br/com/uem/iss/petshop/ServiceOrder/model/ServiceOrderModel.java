/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Service.model.Service;
import br.com.uem.iss.petshop.Utils.DateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EDUARDO
 */
public class ServiceOrderModel extends AbstractModel{

    private ServiceOrder serviceOrder;
    final private ServiceOrderDAO serviceOrderDAO;
    private final List<ObserverServiceOrderChangeAnimal> observerChangeAnimal; 
    final private List<ObserverServiceOrderChangeCustomer> observerChangeCustomer;
    final private List<ObserverServiceOrderAdded> observerAddedService;
    final private List<ObserverServiceOrderRemoved> observerRemovedService;
    final private List<ObserverTotalCalculed> observerTotalCalculed;
    
    public void addService(Service s) {
        serviceOrder.add(s);
        serviceWasAdded();
    }

    public AbstractTableModel createServiceModel() {
        return new AbstractTableModel() {

            @Override
            public String getColumnName(int col){
                if (col == 0)
                    return "Codigo do serviço";
                else if (col == 1)
                    return "Descrição do serviço";
                
                return "Preço do serviço";
            }
            
            @Override
            public int getRowCount() {
                return serviceOrder.getServices().size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Service service = serviceOrder.getServices().get(rowIndex);
                if (columnIndex == 0)
                    return service.getID();
                else if (columnIndex == 1)
                    return service.getDescricao();
                
                return service.getPreco();
            }
        };
    }

    public void calculeTotal() {
        BigDecimal total;
        total = new BigDecimal("00000000");
        for (Service service : serviceOrder.getServices()) {
            Double value = Double.parseDouble(Float.toString(service.getPreco()));
            BigDecimal bigValue = BigDecimal.valueOf(value);
            total = total.add(bigValue);
        }
        updateObserversTotalWasCalculed(total);
    }

    public interface ObserverTotalCalculed {
        public void totalWasCalculed(BigDecimal value);
    }
    
    public interface ObserverServiceOrderAdded{
        public void addedService();
    }
    
    public interface ObserverServiceOrderRemoved{
        public void removedService();
    }

    public interface ObserverServiceOrderChangeAnimal{
        void animalChanged();
    } 
    
    public interface ObserverServiceOrderChangeCustomer{
        void customerChanged();
    }
    
    public ServiceOrderModel() {
        serviceOrder = new ServiceOrder();
        serviceOrderDAO = new ServiceOrderDAO();
        observerChangeAnimal = new ArrayList<>();
        observerChangeCustomer = new ArrayList<>();
        observerAddedService = new ArrayList<>();
        observerRemovedService = new ArrayList<>();
        observerTotalCalculed = new ArrayList<>();
    }

    public void register(ObserverTotalCalculed o) {
        observerTotalCalculed.add(o);
    }
    
    public void updateObserversTotalWasCalculed(BigDecimal total) {
        for (ObserverTotalCalculed observer : observerTotalCalculed ) {
            observer.totalWasCalculed(total);
        }
    }
    
    public void register(ObserverServiceOrderRemoved o) {
        observerRemovedService.add(o);
    }
    
    public void serviceWasRemoved() {
        for (ObserverServiceOrderRemoved observerServiceOrderRemoved : observerRemovedService) {
            observerServiceOrderRemoved.removedService();
        }
    }
    
    public void register(ObserverServiceOrderAdded o) {
        observerAddedService.add(o);
    }
    
    public void serviceWasAdded() {
        for (ObserverServiceOrderAdded observerServiceAdded : observerAddedService) {
            observerServiceAdded.addedService();
        }
    }
    
    public void register(ObserverServiceOrderChangeAnimal o){
        observerChangeAnimal.add(o);
    }
    
    public void animalWasChanged(){
        for (ObserverServiceOrderChangeAnimal observerServiceOrderChangeAnimal : observerChangeAnimal) {
            observerServiceOrderChangeAnimal.animalChanged();
        }
    }
    
    public void register(ObserverServiceOrderChangeCustomer o){
        observerChangeCustomer.add(o);
    }
    
    public void customerWasChanged(){
        for (ObserverServiceOrderChangeCustomer observerServiceOrderChangeCustomer : observerChangeCustomer) {
            observerServiceOrderChangeCustomer.customerChanged();
        }
    }
    
    @Override
    public void initialize() {
        initializerEntities();
        //TODO: inicializar serviceOrder
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean persist() {
        if (!Customer.Checker.mandatoryFieldsFilled(serviceOrder.getCustomer())){
            updateErrorMessage("Por favor selecione um cliente!");
        } else if (serviceOrder.getServices().isEmpty()){
            updateErrorMessage("Nenhum servico foi adiconado a ordem de serviço!");
        } else {
            try {
                serviceOrderDAO.persist(serviceOrder);
                updateObservers("Dados gravados com sucesso");
                return true;
            } catch (Exception e) {
                updateErrorMessage("Erro ao gravar os dados no banco de dados "+e.getMessage());
            } finally {
                serviceOrderDAO.close();
            }
            
        }
        
        return false;
    }

    @Override
    public void setEntity(PetshopEntity entity) {
        serviceOrder = (ServiceOrder)entity;
    }

    public Customer getCustomer() {
        return serviceOrder.getCustomer();
    }

    public void setCustomer(Customer customer) {
        serviceOrder.setCustomer(customer);
        customerWasChanged();
    }

    public Animal getAnimal() {
        return serviceOrder.getAnimal();
    }

    public void setAnimal(Animal animal) {
        serviceOrder.setAnimal(animal);
        animalWasChanged();
    }

    private void initializerEntities() {
        serviceOrder = ServiceOrder.ServiceOrderInitializer.initializer(serviceOrder);
    }

    public String getCustomerName() {
        return serviceOrder.getCustomer().getName();
    }

    public String getCustomerLastName() {
        return serviceOrder.getCustomer().getLastName();
    }

    public String getCustomerPhone() {
        return serviceOrder.getCustomer().getPhone();
    }

    public String getCustomerBirth() {
        DateUtil dateUtil = new DateUtil();
        return dateUtil.toString(serviceOrder.getCustomer().getBirth());
    }

    public String getAnimalName() {
        return serviceOrder.getAnimal().getName();
    }

    public String getAnimalBirth() {
        DateUtil dateUtil = new DateUtil();
        return dateUtil.toString(serviceOrder.getAnimal().getBirth());
    }

}
