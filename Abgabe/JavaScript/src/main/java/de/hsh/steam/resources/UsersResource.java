package de.hsh.steam.resources;

import de.hsh.steam.application.Steamservices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Api
public class UsersResource {
        
    @POST
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(
            @ApiParam(value = "The username", required = true) @PathParam("username") String username, 
            @ApiParam(value = "Further user data", required = true) UserData createUser){
        
        
        if (Steamservices.singleton().newUser(username, createUser.password))
        {
            return Response
                .ok()
                .build();
        }
        
        return Response
                .status(Response.Status.CONFLICT)
                .build();
    }
    
    @POST
    @Path("/{username}/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(
            @ApiParam(value = "The username", required = true) @PathParam("username") String username, 
            @ApiParam(value = "Further user data", required = true) UserData createUser){
        
        System.out.println(String.format("Login as %1$s with password %2$s", username, createUser.password));
        if (Steamservices.singleton().login(username, createUser.password))
        {
            return Response
                .ok()
                .build();
        }
        
        return Response
                .status(Response.Status.FORBIDDEN)
                .build();
    }
}
