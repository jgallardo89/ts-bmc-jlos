package com.bancomer.gis.monitorwebswift.vo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import com.icesoft.faces.context.Resource;

public class ResourceVo implements Resource, Serializable {
    /** Serial */
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	
    private InputStream inputStream;
    
    private final Date lastModified;

    public ResourceVo() {
    	 this.lastModified = new Date();
    }
    
    public ResourceVo(String resourceName, InputStream inputStream) {
        this.resourceName = resourceName;
        this.lastModified = new Date();
        this.inputStream = inputStream;
    }
    
    /**
     * This intermediate step of reading in the files from the JAR, into a
     * byte array, and then serving the Resource from the ByteArrayInputStream,
     * is not strictly necessary, but serves to illustrate that the Resource
     * content need not come from an actual file, but can come from any source,
     * and also be dynamically generated. In most cases, applications need not
     * provide their own concrete implementations of Resource, but can instead
     * simply make use of com.icesoft.faces.context.ByteArrayResource,
     * com.icesoft.faces.context.FileResource, com.icesoft.faces.context.JarResource.
     */
    public InputStream open() throws IOException {
        if (inputStream != null) {
            byte[] byteArray = ResourceVo.toByteArray(inputStream);
            inputStream = new ByteArrayInputStream(byteArray);
        }
        return inputStream;
    }
    
    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buf = new byte[4096];
        int len = 0;
        while ((len = input.read(buf)) > -1) output.write(buf, 0, len);
        return output.toByteArray();
    }
    
    public String calculateDigest() {
        return resourceName;
    }

    public Date lastModified() {
        return lastModified;
    }

    public void withOptions(Options arg0) throws IOException {
    }
}   

