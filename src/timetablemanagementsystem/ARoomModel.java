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
public class ARoomModel {
    
    private String buildingNumber;
    private String buildingName;
    private String roomNumber;
    private String roomName;
    private String roomType;      
    private String roomCapacity;
    
    public ARoomModel (String buildingNumber, String buildingName, String roomNumber, String roomName, String roomType, String roomCapacity){

        this.buildingNumber = buildingNumber;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber; 
        this.roomName = roomName;  
        this.roomType = roomType;  
        this.roomCapacity = roomCapacity;  
        
    }
    

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(String roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    
}
