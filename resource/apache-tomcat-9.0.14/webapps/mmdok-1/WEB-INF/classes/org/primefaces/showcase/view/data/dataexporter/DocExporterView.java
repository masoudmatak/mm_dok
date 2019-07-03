
package org.primefaces.showcase.view.data.dataexporter;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.primefaces.showcase.service.MetadataService;
import dbutil.dbutil.model.MetaData;

@ManagedBean
public class DocExporterView implements Serializable {

	private List<MetaData> metadatas;
	private MetaData selectedMetadata;

	@ManagedProperty("#{metadataService}")
	private MetadataService service;

	@PostConstruct
	public void init() {
		metadatas = service.createMetadata(100);
	}

	public List<MetaData> getMetadatas() {
		return metadatas;
	}

	public void setService(MetadataService service) {
		this.service = service;
	}

	public MetaData getSelectedMetadata() {
		return selectedMetadata;
	}

	public void setSelectedMetadata(MetaData selectedMetadata) {
		this.selectedMetadata = selectedMetadata;
	}
}
