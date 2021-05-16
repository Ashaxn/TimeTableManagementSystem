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
public class ARoomLecturerModel {
    
    private int id;
    private String lecturer_name;
    private String lecturerTag;
    private String lecturerSubject;
    private String lecturerBuilding;
    private String lecturerRoom; 

public ARoomLecturerModel (int id, String lecturer_name, String lecturerTag, String lecturerSubject, String lecturerBuilding, String lecturerRoom){

        this.id = id;
        this.lecturer_name = lecturer_name;
        this.lecturerTag = lecturerTag; 
        this.lecturerSubject = lecturerSubject;  
        this.lecturerBuilding = lecturerBuilding;  
        this.lecturerRoom = lecturerRoom;  
        
    }     
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLecturer_name() {
        return lecturer_name;
    }

    public void setLecturer_name(String lecturer_name) {
        this.lecturer_name = lecturer_name;
    }

    public String getLecturerTag() {
        return lecturerTag;
    }

    public void setLecturerTag(String lecturerTag) {
        this.lecturerTag = lecturerTag;
    }

    public String getLecturerSubject() {
        return lecturerSubject;
    }

    public void setLecturerSubject(String lecturerSubject) {
        this.lecturerSubject = lecturerSubject;
    }

    public String getLecturerBuilding() {
        return lecturerBuilding;
    }

    public void setLecturerBuilding(String lecturerBuilding) {
        this.lecturerBuilding = lecturerBuilding;
    }

    public String getLecturerRoom() {
        return lecturerRoom;
    }

    public void setLecturerRoom(String lecturerRoom) {
        this.lecturerRoom = lecturerRoom;
    }
      
    
}
