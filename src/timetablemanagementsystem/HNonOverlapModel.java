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
public class HNonOverlapModel {
    
    private int nonoverID;
    private int session_id; 
    private String session_name;
    private String lecturer_1;
    private String lecturer_2;
    private String lecturer_3;
    private String subject_code;
    private String subject_name;
    private String group_id;
    private String tag;
    private int student_count;
    private String duration;
    
    public HNonOverlapModel(int nonoverID,int session_id, String session_name, String lecturer_1, String lecturer_2, String lecturer_3, String subject_code, String subject_name, String group_id, String tag, int student_count, String duration){
        
        this.nonoverID = nonoverID;
        this.session_id = session_id;
        this.session_name = session_name;
        this.lecturer_1= lecturer_1;
        this.lecturer_2 = lecturer_2;
        this.lecturer_3 = lecturer_3;
        this.subject_code = subject_code;  
        this.subject_name = subject_name; 
        this.group_id = group_id; 
        this.tag = tag; 
        this.student_count = student_count; 
        this.duration = duration; 
    }
    
    
   public int getnonoverID() {
        return nonoverID;
    }

    public void setnonoverID(int nonoverID) {
        this.nonoverID = nonoverID;
    }
    
     public int getsession_id() {
        return session_id;
    }

    public void setsession_id(int session_id) {
        this.session_id = session_id;
    }
    
    
    public String getsession_name() {
        return session_name;
    }

    public void setsession_name(String session_name) {
        this.session_name = session_name;
    }
    public String getlecturer_1() {
        return lecturer_1;
    }

    public void setlecturer_1(String lecturer_1) {
        this.lecturer_1 = lecturer_1;
    }
    

    public String getlecturer_2() {
        return lecturer_2;
    }

    public void setlecturer_2(String lecturer_2) {
        this.lecturer_2 = lecturer_2;
    }
    
     public String getlecturer_3() {
        return lecturer_3;
    }

    public void setlecturer_3(String lecturer_3) {
        this.lecturer_3 = lecturer_3;
    }

    public String getsubject_code() {
        return subject_code;
    }

    public void setsubject_code(String subject_code) {
        this.subject_code = subject_code;
    }
    
     public String getsubject_name() {
        return subject_name;
    }

    public void setsubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
    
     public String getgroup_id() {
        return group_id;
    }

    public void setgroup_id(String group_id) {
        this.group_id = group_id;
    }
    
     public String gettag() {
        return tag;
    }

    public void settag(String tag) {
        this.tag = tag;
    }
    
     public int getstudent_count() {
        return student_count;
    }

    public void setstudent_count(int student_count) {
        this.student_count = student_count;
    }
    
     public String getduration() {
        return duration;
    }

    public void setduration(String duration) {
        this.duration = duration;
    }
    
    
}
