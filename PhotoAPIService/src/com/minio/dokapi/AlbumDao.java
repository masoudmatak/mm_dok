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

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;

import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import io.minio.errors.MinioException;

public class AlbumDao {
    public List<Folksam> listAlbums() throws NoSuchAlgorithmException,
            IOException, InvalidKeyException, XmlPullParserException, MinioException {

        List<Folksam> list = new ArrayList<Folksam>();
       // final String minioBucket = "kundhandlingar";
        final String minioBucket = "miniobukett";
        // Initialize minio client object.
        MinioClient minioClient = new MinioClient("http://13.53.172.37:9000",
                                                  "admin",
                                                  "dokmasoud");

        // List all objects.
        Iterable<Result<Item>> myObjects = minioClient.listObjects(minioBucket);

        // Iterate over each elements and set album url.
        for (Result<Item> result : myObjects) {
            Item item = result.get();
            System.out.println(item.lastModified() + ", " + item.size() + ", " + item.objectName());
             
            // Create a new Album Object
            Folksam album = new Folksam();
            
            // Set the presigned URL in the album object
            album.setUrl(minioClient.presignedGetObject(minioBucket, item.objectName(), 60 * 60 * 24));
            
          
            list.add(album);
            
        }
       // ConnectionDok connector=new ConnectionDok();
       // connector.sqlDriver();
        // Return list of albums.
        return list;
    }
}