package org.aditi.restwebservices.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/annotations")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class AnnotationsPractise
{
	@GET
	@Path("/injectDemo")
	public String injectDemo(@MatrixParam("param") String matrixParam, 
							 @HeaderParam("customHeaderValue") String header, 
							 @CookieParam("name") String cookie)
	{
		return "matrix param "+  matrixParam + " customHeaderValue "+ header +" Cookie "+ cookie ;
	}
	
	@GET
	@Path("/context")
	public String getParamUsingContext(@Context UriInfo urlInfo, @Context HttpHeaders headers)
	{
		String path = urlInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Path : "+path+ " Cookies : "+cookies;
	}

}
