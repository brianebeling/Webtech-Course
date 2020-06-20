package de.hsh.steam.resources;

import de.hsh.steam.application.Genre;
import de.hsh.steam.application.Rating;
import de.hsh.steam.application.Score;
import de.hsh.steam.application.Series;
import de.hsh.steam.application.Steamservices;
import de.hsh.steam.application.Streamingprovider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

 @Path("/series")
@Api
public class SeriesResource {
        
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrModifySeries(
            @ApiParam(value = "The user to add the series to", required = false) @QueryParam("username") String username,
            @ApiParam(value = "Series specific data", required = true) SeriesData series){
        
        System.out.println("Username " + username);
        System.out.println("Title " + series.title);
        System.out.println("Genre " + series.genre);
        System.out.println("Score " + series.Score);
        Steamservices.singleton().addOrModifySeries(series.title, series.numberOfSeasons, series.genre, series.streamingProvider, username, series.Score, series.Remark);
        
        return Response
            .ok()
            .build();     
    }
    
    @GET
    @Path("/{series}/rating")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRating(
            @ApiParam(value = "The series name", required = true) @PathParam("series") String series,
            @ApiParam(value = "The username", required = true) @QueryParam("username") String username) {
        
        Rating rating = Steamservices.singleton().getRating(series, username);
        
        RatingData ratingData = new RatingData();
        ratingData.score = rating.getScore();
        ratingData.remark = rating.getRemark();
        
        return Response
                .ok()
                .entity(ratingData)
                .build();
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSeries() {
        
        ArrayList<Series> s = Steamservices.singleton().getAllSeries();
        
        // TODO Make individual response object to avoid nulls
        ArrayList<SeriesData> seriesDataList = new ArrayList<>();
        
        s.stream().map((series) -> {
            SeriesData seriesData = new SeriesData();
            seriesData.title = series.getTitle();
            seriesData.genre = series.getGenre();
            seriesData.numberOfSeasons = series.getNumberOfSeasons();
            seriesData.streamingProvider = series.getStreamedBy();
            return seriesData;            
        }).forEachOrdered((seriesData) -> {
            seriesDataList.add(seriesData);
        });
        return Response
                .ok()
                .entity(seriesDataList)
                .build();
    }
    
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(
            @ApiParam(value = "The username. Must be set when searching with Score.", required = false) 
            @QueryParam("username") String username,
            
            @ApiParam(value = "The genre.", required = false)
            @QueryParam("genre") Genre genre,
            
            @ApiParam(value = "The streaming provider.", required = false)
            @QueryParam("streamingProvider") Streamingprovider streamingProvider,
            
            @ApiParam(value = "The score.", required = false)
            @QueryParam("score") Score score) {
        
        ArrayList<Series> s = Steamservices.singleton().search(username, genre, streamingProvider, score);
        
        // TODO Make individual response object to avoid nulls
        ArrayList<SeriesData> seriesDataList = new ArrayList<>();
        
        s.stream().map((series) -> {
            SeriesData seriesData = new SeriesData();
            seriesData.title = series.getTitle();
            seriesData.genre = series.getGenre();
            seriesData.numberOfSeasons = series.getNumberOfSeasons();
            seriesData.streamingProvider = series.getStreamedBy();
            return seriesData;            
        }).forEachOrdered((seriesData) -> {
            seriesDataList.add(seriesData);
        });
        return Response
                .ok()
                .entity(seriesDataList)
                .build();
    }
    
    @GET
    @Path("/byTitle/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSeriesWithTitle(
            @ApiParam(value = "The title.", required = true) @PathParam("title") String title) {
        
        ArrayList<Series> s = Steamservices.singleton().getAllSeriesWithTitle(title);
        
        System.out.println("Found " + s.size() + " series with the title " + title);
        // TODO Make individual response object to avoid nulls
        ArrayList<SeriesData> seriesDataList = new ArrayList<>();
        
        s.stream().map((series) -> {
            SeriesData seriesData = new SeriesData();
            seriesData.title = series.getTitle();
            seriesData.genre = series.getGenre();
            seriesData.numberOfSeasons = series.getNumberOfSeasons();
            seriesData.streamingProvider = series.getStreamedBy();
            return seriesData;            
        }).forEachOrdered((seriesData) -> {
            seriesDataList.add(seriesData);
        });
        
        System.out.println(seriesDataList.size());
        
        return Response
                .ok()
                .entity(s)
                .build();
    }
    
    @GET
    @Path("/byUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSeriesOfUser(
            @ApiParam(value = "The user.", required = true) @QueryParam("username") String username) {
        
        ArrayList<Series> s = Steamservices.singleton().getAllSeriesOfUser(username);
        
        // TODO Make individual response object to avoid nulls
        ArrayList<SeriesData> seriesDataList = new ArrayList<>();
        
        s.stream().map((series) -> {
            SeriesData seriesData = new SeriesData();
            seriesData.title = series.getTitle();
            seriesData.genre = series.getGenre();
            seriesData.numberOfSeasons = series.getNumberOfSeasons();
            seriesData.streamingProvider = series.getStreamedBy();
            return seriesData;            
        }).forEachOrdered((seriesData) -> {
            seriesDataList.add(seriesData);
        });
        return Response
                .ok()
                .entity(seriesDataList)
                .build();
    }
}
