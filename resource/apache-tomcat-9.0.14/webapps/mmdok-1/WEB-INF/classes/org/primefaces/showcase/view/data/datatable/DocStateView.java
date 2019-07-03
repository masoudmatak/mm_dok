
package org.primefaces.showcase.view.data.datatable;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
//import org.primefaces.showcase.domain.Doc;
import dbutil.dbutil.model.Doc;
import org.primefaces.showcase.service.DocService;

@ManagedBean(name="dtDocStateView")
@SessionScoped
public class DocStateView implements Serializable {
    
    private List<Doc> docs;
    
    private List<Doc> filteredDocs;
    
    private Doc selectedDoc;
    
    @ManagedProperty("#{docService}")
    private DocService service;

    @PostConstruct
    public void init() {
        docs = service.createDocs(50);
    }
    
    public List<String> getDoktypes() {
        return service.getDoktypes();
    }
    
    public List<String> getColors() {
        return service.getColors();
    }
    
    public List<Doc> getDocs() {
        return docs;
    }

    public List<Doc> getFilteredDocs() {
        return filteredDocs;
    }

    public Doc getSelectedDoc() {
        return selectedDoc;
    }

    public void setSelectedDoc(Doc selectedDoc) {
        this.selectedDoc = selectedDoc;
    }

    public void setFilteredDocs(List<Doc> filteredDocs) {
        this.filteredDocs = filteredDocs;
    }

    public void setService(DocService service) {
        this.service = service;
    }
}
