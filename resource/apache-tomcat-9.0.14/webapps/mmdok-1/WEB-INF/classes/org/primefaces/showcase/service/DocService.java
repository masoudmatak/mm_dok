
package org.primefaces.showcase.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
//import org.primefaces.showcase.domain.Doc;

import dbutil.dbutil.model.Doc;
import com.dok.insert.ReadMetaData;

import dbutil.dbutil.model.MetaData;

@ManagedBean(name = "docService")
@ApplicationScoped
public class DocService {
    
    private final static String[] colors;
	
	private final static String[] doktypes;
    
    static {
		colors = new String[10];
		colors[0] = "Black";
		colors[1] = "White";
		colors[2] = "Green";
		colors[3] = "Red";
		colors[4] = "Blue";
		colors[5] = "Orange";
		colors[6] = "Silver";
		colors[7] = "Yellow";
		colors[8] = "Brown";
		colors[9] = "Maroon";
		
		doktypes = new String[11];
		doktypes[0] = "CLAIM";
		doktypes[1] = "CORRESPODENT";
		doktypes[2] = "FAKTURA";
		doktypes[3] = "FORSAKRING";
		doktypes[4] = "HANDLING";
		doktypes[5] = "INDIVIDUELL";
		doktypes[6] = "KOLLEKTIV";
		doktypes[7] = "POLICY";
		doktypes[8] = "POLISANMALAN";
		doktypes[9] = "SKADEANMALAN";
		doktypes[10] = "SPARANDE";
		
	}
    
    public List<Doc> createDocs(int size) {
    
       
		ReadMetaData testmetadata=new ReadMetaData();
		 List<Doc> listan=testmetadata.getDocdata();
		 System.out.println("size of metadata is: "+listan.size());
        return listan;
    }
    
    public List<String> getColors() {
        return Arrays.asList(colors);
    }
    
    public List<String> getDoktypes() {
        return Arrays.asList(doktypes);
    }
}
