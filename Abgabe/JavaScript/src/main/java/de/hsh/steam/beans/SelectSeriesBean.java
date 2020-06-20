/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsh.steam.beans;

import de.hsh.steam.application.Series;
import de.hsh.steam.application.Score;
import de.hsh.steam.application.Rating;
import de.hsh.steam.application.Steamservices;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Kai
 */
@Named(value = "selectSeriesBean")
@RequestScoped
public class SelectSeriesBean {

    private Series ser;

    public void setSer(Series ser) {
        this.ser = ser;
    }

    public Series getSer() {
        return ser;
    }
    
    public Score GetRating(String user)
    {
        if(ser != null)
        {
            if(Steamservices.singleton().getRating(ser.getTitle(), user) != null)
            {
                return Steamservices.singleton().getRating(ser.getTitle(), user).getScore();
            }
        }
        return null;
    }
    
    public String GetComment(String user)
    {
        if(ser != null)
        {
            if(Steamservices.singleton().getRating(ser.getTitle(), user) != null)
            {
                return Steamservices.singleton().getRating(ser.getTitle(), user).getRemark();
            }
        }
        return null;
    }
    
    /**
     * Creates a new instance of SelectSeriesBean
     */
    public SelectSeriesBean() {
    }
    
    public String SelectSeries(Series se)
    {
        ser = se;
        return "SerieDetail";
    }
}
