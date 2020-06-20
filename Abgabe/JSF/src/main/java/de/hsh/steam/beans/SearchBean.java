/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsh.steam.beans;

import de.hsh.steam.application.Genre;
import de.hsh.steam.application.Score;
import de.hsh.steam.application.Series;
import de.hsh.steam.application.Steamservices;
import de.hsh.steam.application.Streamingprovider;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Kai
 */
@Named(value = "searchBean")
@RequestScoped
public class SearchBean {

    private String searchText;
    
    private Genre genre;
    private Streamingprovider platform;
    private Score rating;

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setPlatform(Streamingprovider platform) {
        this.platform = platform;
    }

    public void setRating(Score rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public Streamingprovider getPlatform() {
        return platform;
    }

    public Score getRating() {
        return rating;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSearchText() {
        return searchText;
    }
    
    public Genre[] GetGenres()
    {
        return Genre.values();
    }
    public Streamingprovider[] GetPlatforms()
    {
        return Streamingprovider.values();
    }
    public Score[] GetRatings()
    {
        return Score.values();
    }
    
    /**
     * Creates a new instance of SearchBean
     */
    public SearchBean() {
    }
    
    public String Search()
    {
        Steamservices.singleton().login("","");
        return "index";
    }
    
    public ArrayList<Series> GetSearchedSeries(String user)
    {
        Steamservices.singleton().login("","");
        ArrayList<Series> ser;
        ser = Steamservices.singleton().search(user,genre,platform,rating);
        System.out.println("Count " + ser.size()+ " g:" +genre);
        //ser = Steamservices.singleton().getAllSeries();
        return ser;
    }
    
}
