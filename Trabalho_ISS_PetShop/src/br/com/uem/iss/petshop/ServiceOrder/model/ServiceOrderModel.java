/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.ServiceOrder.model;

import br.com.uem.iss.petshop.Abstract.model.AbstractModel;
import br.com.uem.iss.petshop.Animal.model.Animal;
import br.com.uem.iss.petshop.Customer.model.Customer;
import br.com.uem.iss.petshop.Interfaces.ObserverJInternalFrame;
import br.com.uem.iss.petshop.Interfaces.PetshopEntity;
import br.com.uem.iss.petshop.Service.model.Service;
import br.com.uem.iss.petshop.Utils.DateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
        if (serviceOrder.getServices().contains(s)){
            updateErrorMessage("Serviço ja adicionado para esta ordem de serviço!");
            return;
        }
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
        total = new BigDecimal("0");
        for (Service service : serviceOrder.getServices()) {
            Double value = Double.parseDouble(Float.toString(service.getPreco()));
            BigDecimal bigValue = BigDecimal.valueOf(value);
            total = total.add(bigValue);
        }
        updateObserversTotalWasCalculed(total);
    }

    public void remove(int selected) {
        serviceOrder.getServices().remove(selected);
        serviceWasRemoved();
    }

    public int getStatusIndex() {
        int index = 0; //ServiceOrder.Status.UNDEFINED
        ServiceOrder.Status status = getStatus();
        if (status == ServiceOrder.Status.OPEN)
            index = 1;
        else if (status == ServiceOrder.Status.CLOSE)
            index = 2;
        else if (status == ServiceOrder.Status.WITHDRAW)
            index = 3;
        else if (status == ServiceOrder.Status.DELIVERY)
            index = 4;
        
        return index;
    }
    
    public void setStatuByIndex(int index) {
        if (index == 0)
            setStatus(ServiceOrder.Status.UNDEFINED);
        else if (index == 1)
            setStatus(ServiceOrder.Status.OPEN);
        else if (index == 2)
            setStatus(ServiceOrder.Status.CLOSE);
        else if (index == 3)
            setStatus(ServiceOrder.Status.WITHDRAW);
        else if (index == 4)
            setStatus(ServiceOrder.Status.DELIVERY);
    }
    
    private void setStatus(ServiceOrder.Status status) {
        serviceOrder.setStatus(status);
    }
    
    private ServiceOrder.Status getStatus() {
        return serviceOrder.getStatus();
    }
    
    public int getPaymentIndex() {
        int index = 0;
        ServiceOrder.PaymentType paymentType = getPaymentType();
        if (paymentType == ServiceOrder.PaymentType.CARTAO)
            index = 1;
        else if (paymentType == ServiceOrder.PaymentType.DINHEIRO)
            index = 2;
        return index;
    }
    
    public void setPaymentTypeByIndex(int index) {
        if (index == 0 || index == -1)
            setPayment(ServiceOrder.PaymentType.UNDEFINED);
        else if (index == 1)
            setPayment(ServiceOrder.PaymentType.CARTAO);
        else if (index == 2)
            setPayment(ServiceOrder.PaymentType.DINHEIRO);
    }
    
    private void setPayment(ServiceOrder.PaymentType paymentType) {
        serviceOrder.setPaymentType(paymentType);
    }
    
    public ServiceOrder.PaymentType getPaymentType() {
        return serviceOrder.getPaymentType();
    }
    
    public boolean isClosed() {
        return serviceOrder.getStatus() == ServiceOrder.Status.CLOSE;
    }

    public Date getExecuteDate() {
        return serviceOrder.getExecuteDate();
    }

    public String getEntryValue() {
        Double entryValue = serviceOrder.getEntryValue();
        return entryValue.toString();
    }

    public String getVendor() {
        return serviceOrder.getVendor();
    }

    public String getNote() {
        return serviceOrder.getNote();
    }

    
    public List<Object> getPaymentSituations() {
        return paymentSituations;
    }

    public List<Object> getStausSituation() {
        return statusSituations;
    }

    public void setNote(String text) {
        serviceOrder.setNote(text);
    }

    public void setEntryValue(Double entryValue) {
        serviceOrder.setEntryValue(entryValue);
    }

    public void setVendor(String text) {
        serviceOrder.setVendor(text);
    }

    public void setExecuteDate(Date executeDate) {
        serviceOrder.setExecuteDate(executeDate);
    }

    public List<Service> getServices() {
        return serviceOrder.getServices();
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
    
    private List<Object> paymentSituations;
    private List<Object> statusSituations;
    public ServiceOrderModel() {
        serviceOrder = new ServiceOrder();
        serviceOrderDAO = new ServiceOrderDAO();
        observerChangeAnimal = new ArrayList<>();
        observerChangeCustomer = new ArrayList<>();
        observerAddedService = new ArrayList<>();
        observerRemovedService = new ArrayList<>();
        observerTotalCalculed = new ArrayList<>();
        paymentSituations = new ArrayList<>();
        paymentSituations.add("Selecione o tipo de pagamento");
        paymentSituations.add("CARTÃO");
        paymentSituations.add("DINHEIRO");
        statusSituations = new ArrayList<>();
        statusSituations.add("Selecione a situacao da ordem de serviço");
        statusSituations.add("ABERTA");
        statusSituations.add("FECHADA");
        statusSituations.add("A RETIRAR");
        statusSituations.add("A ENTREGAR");
        
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
        DateUtil dateUtil = new DateUtil();
        if (!Customer.Checker.mandatoryFieldsFilled(serviceOrder.getCustomer())){
            updateErrorMessage("Por favor selecione um cliente!");
        } else if (serviceOrder.getServices().isEmpty()){
            updateErrorMessage("Nenhum servico foi adiconado a ordem de serviço!");
        }else if(!Animal.Checker.mandatoryFieldsFilled(serviceOrder.getAnimal())){
            updateErrorMessage("Selecione um animal!");
        } else if (dateUtil.before(serviceOrder.getExecuteDate(),dateUtil.getCurrentDate())){
            updateErrorMessage("A data de execução não deve ser anterior a data atual.");
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
