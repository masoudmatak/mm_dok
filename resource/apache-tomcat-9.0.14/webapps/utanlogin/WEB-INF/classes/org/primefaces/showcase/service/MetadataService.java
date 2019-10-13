/*
Owner and programmer: Masoud Mohammadi 2019
Copywrite is limited and it is only the owner of the program code
can allow the use of it in a system if legal overcoming occurs. 
All rights are reserved for the owner of the code.
This is part of a system design and implementation of this 
Document Management System is based on a particular application area. 
This implementation is based on observation of the use in certain industries. 
In the case of copyright infringement, the owner is entitled to legal 
action and will require legal action through court.
*/
package org.primefaces.showcase.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.showcase.domain.Car;

import com.dok.insert.ReadMetaData;

import dbutil.dbutil.model.MetaData;
import dbutil.dbutil.model.Doc;

@ManagedBean(name = "metadataService")
@ApplicationScoped
public class MetadataService {

	public List<Doc> createMetadata(int size) {
		System.out.println("Meta data Anropad size ar:  " + size);
		/*
		 * List<Car> list = new ArrayList<Car>(); for (int i = 0; i < size; i++) {
		 * list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(),
		 * getRandomColor(), getRandomPrice(), getRandomSoldState())); }
		 */

		ReadMetaData testmetadata = new ReadMetaData();
		List<Doc> listan = testmetadata.getMetadata();
		// List<MetaData> listan = testmetadata.getMetadata2("MNAS33");
		System.out.println("storleken av metadata listan:  " + listan.size());

		return listan;
		
	}

	public List<String> getPersonnummers() {
		String[] listaofpersonnr = { "195904112819", "197106286627", "197505106677", "198303255302" };

		return Arrays.asList(listaofpersonnr);
	}

	public List<String> getDocumentClass() {
		String[] doc_class = { "CLAIM", "CORRESPODENT", "FAKTURA", "FORSAKRING", "HANDLING", "INDIVIDUELL", "KOLLEKTIV",
				"POLICY", "POLISANMALAN", "SKADEANMALAN", "SPARANDE" };
		return Arrays.asList(doc_class);
	}

	public List<String> getCustomerid() {
		String[] customerids = { "CUS-2683272HS", "CUS-5344615HS", "CUS-1247816HS", "CUS-1889649HS" };
		return Arrays.asList(customerids);
	}

}
