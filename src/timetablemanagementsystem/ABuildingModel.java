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
public class ABuildingModel {
    
    private String buildingNumber;
    private String buildingName;
    private int noOfRooms;
    
    public ABuildingModel( String buildingNumber, String buildingName, int noOfRooms) {

        this.buildingNumber = buildingNumber;
        this.buildingName = buildingName;
        this.noOfRooms = noOfRooms;
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

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }
}
