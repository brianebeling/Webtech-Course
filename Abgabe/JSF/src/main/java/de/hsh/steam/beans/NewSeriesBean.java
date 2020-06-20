/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsh.steam.beans;

import com.oracle.tools.packager.Platform;
import de.hsh.steam.application.Genre;
import de.hsh.steam.application.Score;
import de.hsh.steam.application.Series;
import de.hsh.steam.application.Steamservices;
import de.hsh.steam.application.Streamingprovider;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Kai
 */
@Named(value = "newSeriesBean")
@RequestScoped
public class NewSeriesBean {

    private String title;
    private String thumb;
    private int seasons;
    private Genre genre;
    private Streamingprovider platform;
    private Score rating;
    private String comment;

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getThumb() {
        return thumb;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setPlatform(Streamingprovider platform) {
        this.platform = platform;
    }

    public Genre getGenre() {
        return genre;
    }

    public Streamingprovider getPlatform() {
        return platform;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public void setRating(Score rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public int getSeasons() {
        return seasons;
    }

    public Score getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
    /**
     * Creates a new instance of NewSeriesBean
     */
    public NewSeriesBean() {
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
    
    public String Modify(String _title, Genre _genre, Streamingprovider _platform, Score _rating, String _comment)
    {
        title = _title;
        genre = _genre;
        platform = _platform;
        rating = _rating;
        comment = _comment;
        return "NeueSerie";
    }
    
    public String Create(String user)
    {
        Steamservices.singleton().addOrModifySeries(title, seasons, genre, platform, user, rating, comment);
        return "index";
    }
}
