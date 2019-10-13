
package org.primefaces.showcase.view.data.datatable;

import java.io.Serializable;
import java.util.ArrayList;
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
    
   

	public DocService getService() {
		//System.out.println("DocStateView.getService()             anropat ==========================");
		return service;
	}

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
    	
    	//Masoud har adderat
    	docs=service.getListan();
    	System.out.println("DocStateView.getDocs()             anropat ========================== storlek "+docs.size());
        return docs;
    }

    public List<Doc> getFilteredDocs() {
    	//System.out.println("DocStateView.getFilteredDocs()             anropat ==========================");
        return filteredDocs;
    }

    public Doc getSelectedDoc() {
        return selectedDoc;
    }

    public void setSelectedDoc(Doc selectedDoc) {
    	//System.out.println("DocStateView.setSelectedDoc()             anropat ==========================");
        this.selectedDoc = selectedDoc;
    }

    public void setFilteredDocs(List<Doc> filteredDocs) {
    	//System.out.println("DocStateView.setFilteredDocs()             anropat ==========================");
        this.filteredDocs = filteredDocs;
    }

    public void setService(DocService service) {
    	//System.out.println("DocStateView.setService()             anropat ==========================");
        this.service = service;
    }
}
