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
public class ARoomSessionModel {
    
    private int id;
    private String session_name;
    private String sessionBuilding;
    private String sessionRoom;   
    private String lecture_one;  
    private String lecture_two;  
    private String lecture_three;
    private String subject_code;  
    private String subject_name; 
    private String group_id;  
    private String seesion_tag; 

public ARoomSessionModel (int id, String session_name, String lecture_one, String lecture_two, String lecture_three, String subject_code, String subject_name, String group_id, String seesion_tag, String sessionBuilding, String sessionRoom){

        this.id = id;
        this.session_name = session_name; 
        this.lecture_one = lecture_one;
        this.lecture_two = lecture_two;
        this.lecture_three = lecture_three;
        this.subject_code = subject_code;
        this.subject_name = subject_name;
        this.group_id = group_id;
        this.seesion_tag = seesion_tag;        
        this.sessionBuilding = sessionBuilding;  
        this.sessionRoom = sessionRoom;  

        
    }     
    

    public String getLecture_one() {
        return lecture_one;
    }

    public void setLecture_one(String lecture_one) {
        this.lecture_one = lecture_one;
    }

    public String getLecture_two() {
        return lecture_two;
    }

    public void setLecture_two(String lecture_two) {
        this.lecture_two = lecture_two;
    }
    
    public String getLecture_three() {
        return lecture_three;
    }

    public void setLecture_three(String lecture_three) {
        this.lecture_three = lecture_three;
    }    

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getSeesion_tag() {
        return seesion_tag;
    }

    public void setSeesion_tag(String seesion_tag) {
        this.seesion_tag = seesion_tag;
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSessionBuilding() {
        return sessionBuilding;
    }

    public void setSessionBuilding(String sessionBuilding) {
        this.sessionBuilding = sessionBuilding;
    }

    public String getSessionRoom() {
        return sessionRoom;
    }

    public void setSessionRoom(String sessionRoom) {
        this.sessionRoom = sessionRoom;
    }    
    
}
