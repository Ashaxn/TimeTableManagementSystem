/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem;

/**
 *
 * @author ashan
 */
public class URoomCannotModel {
    
    private int id;
    private String roomName;
    private String roomday;
    private String start_time;
    private String end_time; 
    
public URoomCannotModel (int id, String roomName, String roomday, String start_time, String end_time){

        this.id = id;
        this.roomName = roomName; 
        this.roomday = roomday;
        this.start_time = start_time;
        this.end_time = end_time;
        
    }       

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomday() {
        return roomday;
    }

    public void setRoomday(String roomday) {
        this.roomday = roomday;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }  
    
    
}
