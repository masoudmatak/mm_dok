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
package com.dokapi.autorize;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.xmlpull.v1.XmlPullParserException;

import dbutil.dbutil.model.Doc;

@Path("/autorize")
public class AutorizationService {
    // Initialize new album service.
    MetadataDao metadataDao = new  MetadataDao();
  
  
    @Produces({MediaType.APPLICATION_JSON})   
    @GET
	@Path("/{param}")
    public List<Doc> listMetadata(@PathParam("param") String personnummer) throws InvalidKeyException,
            NoSuchAlgorithmException, IOException,
            XmlPullParserException {

        // Return list of albums.
        return metadataDao.listMetadata(personnummer);
    }
}