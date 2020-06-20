package de.hsh.steam;

import de.hsh.steam.resources.SeriesResource;
import de.hsh.steam.resources.UsersResource;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Configures JAX-RS for the application.
 * @author Juneau
 */
@ApplicationPath("resources")
public class JAXRSConfiguration extends ResourceConfig {
    public JAXRSConfiguration()
    {
        System.out.print("Test");
                
        this.registerEndpoints();
        this.configureSwagger();
        
        this.register(CORSFilter.class);
        this.register(JacksonFeature.class);
    }
    
    private void registerEndpoints() {
        this.register(UsersResource.class);
        this.register(SeriesResource.class);
    }

    private void configureSwagger() {

        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("v1");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/resources");
        beanConfig.setResourcePackage("de.hsh.steam.resources");
        beanConfig.setScan(true);
        // http://localhost:8080/steam/resources/swagger.json
        // http://localhost:8080/Webtech-Course/resources/swagger.json
    }
}
