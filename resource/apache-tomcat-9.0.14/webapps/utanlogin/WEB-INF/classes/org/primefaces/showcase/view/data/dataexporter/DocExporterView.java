
package org.primefaces.showcase.view.data.dataexporter;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.primefaces.showcase.service.MetadataService;
import dbutil.dbutil.model.Doc;

@ManagedBean
public class DocExporterView implements Serializable {

	private List<Doc> metadatas;
	private Doc selectedMetadata;

	@ManagedProperty("#{metadataService}")
	private MetadataService service;

	@PostConstruct
	public void init() {
		metadatas = service.createMetadata(100);
	}

	public List<Doc> getMetadatas() {
		return metadatas;
	}

	public void setService(MetadataService service) {
		this.service = service;
	}

	public Doc getSelectedMetadata() {
		return selectedMetadata;
	}

	public void setSelectedMetadata(Doc selectedMetadata) {
		this.selectedMetadata = selectedMetadata;
	}
}
