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
public class ARoomConsecSessionModel {
    
    private int id;
    private String consecSession_name;
    private String sessionidOne;  
    private String sessionidTwo;  
    private String subject_codeOne;
    private String subject_codeTwo;  
    private String subject_nameOne; 
    private String subject_nameTwo;  
    private String consecSession_tagOne;
    private String consecSession_tagTwo;
    private String consecSessionBuilding;
    private String consecSessionRoom;  
    
public ARoomConsecSessionModel (int id, String consecSession_name, String sessionidOne, String sessionidTwo, String subject_codeOne, String subject_codeTwo, String subject_nameOne, String subject_nameTwo, String consecSession_tagOne, String consecSession_tagTwo, String consecSessionBuilding, String consecSessionRoom){

        this.id = id;
        this.consecSession_name = consecSession_name;
        this.sessionidOne = sessionidOne;
        this.sessionidTwo = sessionidTwo;
        this.subject_codeOne = subject_codeOne;
        this.subject_codeTwo = subject_codeTwo;
        this.subject_nameOne = subject_nameOne;
        this.subject_nameTwo = subject_nameTwo;
        this.consecSession_tagOne = consecSession_tagOne; 
        this.consecSession_tagTwo = consecSession_tagTwo; 
        this.consecSessionBuilding = consecSessionBuilding;  
        this.consecSessionRoom = consecSessionRoom;  
        
    }      
         
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConsecSession_name() {
        return consecSession_name;
    }

    public void setConsecSession_name(String consecSession_name) {
        this.consecSession_name = consecSession_name;
    }

    public String getSessionidOne() {
        return sessionidOne;
    }

    public void setSessionidOne(String sessionidOne) {
        this.sessionidOne = sessionidOne;
    }

    public String getSessionidTwo() {
        return sessionidTwo;
    }

    public void setSessionidTwo(String sessionidTwo) {
        this.sessionidTwo = sessionidTwo;
    }

    public String getSubject_codeOne() {
        return subject_codeOne;
    }

    public void setSubject_codeOne(String subject_codeOne) {
        this.subject_codeOne = subject_codeOne;
    }

    public String getSubject_codeTwo() {
        return subject_codeTwo;
    }

    public void setSubject_codeTwo(String subject_codeTwo) {
        this.subject_codeTwo = subject_codeTwo;
    }

    public String getSubject_nameOne() {
        return subject_nameOne;
    }

    public void setSubject_nameOne(String subject_nameOne) {
        this.subject_nameOne = subject_nameOne;
    }

    public String getSubject_nameTwo() {
        return subject_nameTwo;
    }

    public void setSubject_nameTwo(String subject_nameTwo) {
        this.subject_nameTwo = subject_nameTwo;
    }

    public String getConsecSession_tagOne() {
        return consecSession_tagOne;
    }

    public void setConsecSession_tagOne(String consecSession_tagOne) {
        this.consecSession_tagOne = consecSession_tagOne;
    }

    public String getConsecSession_tagTwo() {
        return consecSession_tagTwo;
    }

    public void setConsecSession_tagTwo(String consecSession_tagTwo) {
        this.consecSession_tagTwo = consecSession_tagTwo;
    }

    public String getConsecSessionBuilding() {
        return consecSessionBuilding;
    }

    public void setConsecSessionBuilding(String consecSessionBuilding) {
        this.consecSessionBuilding = consecSessionBuilding;
    }

    public String getConsecSessionRoom() {
        return consecSessionRoom;
    }

    public void setConsecSessionRoom(String consecSessionRoom) {
        this.consecSessionRoom = consecSessionRoom;
    }


}
