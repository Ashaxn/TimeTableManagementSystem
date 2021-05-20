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
public class ULectureNotAvailableTimeModel {
    
    private int id;
    private int session_id;
    private String lecturename;
    private String stugrpname;
    private String stusubgrpname; 
    private String start_time;  
    private String end_time;
    
public ULectureNotAvailableTimeModel (int id, int session_id, String lecturename, String stugrpname, String stusubgrpname, String start_time, String end_time){

        this.id = id;
        this.session_id = session_id; 
        this.lecturename = lecturename;
        this.stugrpname = stugrpname;
        this.stusubgrpname = stusubgrpname;
        this.start_time = start_time;
        this.end_time = end_time;  

        
    }        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }


    public String getLecturename() {
        return lecturename;
    }

    public void setLecturename(String lecturename) {
        this.lecturename = lecturename;
    }    

    public String getStugrpname() {
        return stugrpname;
    }

    public void setStugrpname(String stugrpname) {
        this.stugrpname = stugrpname;
    }

    public String getStusubgrpname() {
        return stusubgrpname;
    }

    public void setStusubgrpname(String stusubgrpname) {
        this.stusubgrpname = stusubgrpname;
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
