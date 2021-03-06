package org.aditi.restwebservices.messenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.aditi.restwebservices.messenger.model.ErrorMessage;

//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> 
{
	public Response toResponse(Throwable ex) 
	{
		ErrorMessage error = new ErrorMessage(ex.getMessage(), 500, "http://javabrains.koushik.org");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
	}

}
