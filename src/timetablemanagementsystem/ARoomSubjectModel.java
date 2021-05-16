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
public class ARoomSubjectModel {
    private String subject_code;
    private String subjectName;
    private String subjectLecturer;
    private String subjectTag;
    private String subjectBuilding;   
    private String subjectRoom;
    
public ARoomSubjectModel (String subject_code, String subjectName, String subjectLecturer, String subjectTag, String subjectBuilding, String subjectRoom){

        this.subject_code = subject_code;
        this.subjectName = subjectName;
        this.subjectLecturer = subjectLecturer; 
        this.subjectTag = subjectTag;  
        this.subjectBuilding = subjectBuilding;  
        this.subjectRoom = subjectRoom;  
        
    }
    
    public String getSubjectCode() {
        return subject_code;
    }

    public void setSubjectCode(String subjectCode) {
        this.subject_code = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectLecturer() {
        return subjectLecturer;
    }

    public void setSubjectLecturer(String subjectLecturer) {
        this.subjectLecturer = subjectLecturer;
    }

    public String getSubjectTag() {
        return subjectTag;
    }

    public void setSubjectTag(String subjectTag) {
        this.subjectTag = subjectTag;
    }

    public String getSubjectBuilding() {
        return subjectBuilding;
    }

    public void setSubjectBuilding(String subjectBuilding) {
        this.subjectBuilding = subjectBuilding;
    }

    public String getSubjectRoom() {
        return subjectRoom;
    }

    public void setSubjectRoom(String subjectRoom) {
        this.subjectRoom = subjectRoom;
    }
    
    
}
