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
package com.minio.dokapi;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.xmlpull.v1.XmlPullParserException;

import io.minio.errors.MinioException;

@Path("/dokapi")
public class PhotoService {
    // Initialize new album service.
    AlbumDao albumDao = new AlbumDao();

    // Define GET method and resource.
    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Folksam> listAlbums() throws InvalidKeyException,
            NoSuchAlgorithmException, IOException,
            XmlPullParserException, MinioException {

        // Return list of albums.
        return albumDao.listAlbums();
    }
}