/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem;

/**
 *
 * @author user
 */
public class GenerateTimeModel {
    
    private String timeslot;
    private String day;
    private String sessiondetils;
    
    
    public String gettimeslot() {
        return timeslot;
    }

    public void settimeslot(String timeslot) {
        this.timeslot = timeslot;
    }
    
    public String getday() {
        return day;
    }

    public void setday(String day) {
        this.day = day;
    }
    
    public String getsessiondetils() {
        return sessiondetils;
    }

    public void setsessiondetils(String sessiondetils) {
        this.sessiondetils = sessiondetils;
    }
       
}
