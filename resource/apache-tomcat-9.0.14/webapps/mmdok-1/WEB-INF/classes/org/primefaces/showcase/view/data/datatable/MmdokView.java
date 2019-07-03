
package org.primefaces.showcase.view.data.datatable;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.showcase.service.MetadataService;

import dbutil.dbutil.model.MetaData;

@ManagedBean(name="dtMmdokView")
@ViewScoped
public class MmdokView implements Serializable {
    
    private List<MetaData> metadatas;
    
    private List<MetaData> filteredMetadatas;
    
    @ManagedProperty("#{metadataService}")
    private MetadataService service;

    @PostConstruct
    public void init() {
    	metadatas = service.createMetadata(10);
    }
    
  /*  public boolean filterById(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
        
        if(value == null) {
            return false;
        }
        
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }*/
    
    public List<String> getPersonnummers() {
        return service.getPersonnummers();
    }
    
    public List<String> getCustomerid() {
        return service.getCustomerid();
    }
    
    public List<String> getDocumentClass() {
        return service.getDocumentClass();
    }
    
    public List<MetaData> getMetadatas() {
        return metadatas;
    }

    public void  setMetadatas(List<MetaData> metadatas ) {
         this.metadatas=metadatas;
    }
    
    public List<MetaData> getFilteredMetadatas() {
        return filteredMetadatas;
    }

    public void setFilteredMatadatas(List<MetaData> filteredMetadatas) {
        this.filteredMetadatas=filteredMetadatas;
    }

    public void setService(MetadataService service) {
        this.service = service;
    }
}
