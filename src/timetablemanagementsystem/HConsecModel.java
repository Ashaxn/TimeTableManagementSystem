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
public class HConsecModel {
    
    
    private int consec_id; 
    private String consec_name;
    private int sessionid1;
    private int sessionid2;
    private String SubCode1;
    private String SubCode2;
    private String SubName1;
    private String SubName2;
    private String Tag1;
    private String Tag2;
    
    public HConsecModel(int consec_id, String consec_name, int sessionid1, int sessionid2, String SubCode1,String SubCode2,String SubName1, String SubName2, String Tag1, String Tag2){
        this.consec_id = consec_id;
        this.consec_name = consec_name; 
        this.sessionid1= sessionid1;
        this.sessionid2 = sessionid2;
        this.SubCode1 = SubCode1;  
        this.SubCode2 = SubCode2; 
        this.SubName1 = SubName1; 
        this.SubName2 = SubName2; 
        this.Tag1 = Tag1; 
        this.Tag2 = Tag2; 
    }
    
     public int getconsec_id() {
        return consec_id;
    }

    public void setID(int consec_id) {
        this.consec_id = consec_id;
    }
    
    public void setconsec_name(String consec_name) {
        this.consec_name = consec_name;
    }
    
     public String getconsec_name() {
        return consec_name;
    }
    
    public int getsessionid1() {
        return sessionid1;
    }

    public void setsessionid1(int sessionid1) {
        this.sessionid1 = sessionid1;
    }

    public int getsessionid2() {
        return sessionid2;
    }

    public void setsessionid2(int sessionid2) {
        this.sessionid2 = sessionid2;
    }

    public String getSubCode1() {
        return SubCode1;
    }

    public void setSubCode1(String SubCode1) {
        this.SubCode1 = SubCode1;
    }
    
     public String getSubCode2() {
        return SubCode2;
    }

    public void setSubCode2(String SubCode2) {
        this.SubCode2 = SubCode2;
    }
    
     public String getSubName1() {
        return SubName1;
    }

    public void setSubName1(String SubName1) {
        this.SubName1 = SubName1;
    }
    
     public String getSubName2() {
        return SubName2;
    }

    public void setSubName2(String SubName2) {
        this.SubName2 = SubName2;
    }
    
     public String getTag1() {
        return Tag1;
    }

    public void setTag1(String Tag1) {
        this.Tag1 = Tag1;
    }
    
     public String getTag2() {
        return Tag2;
    }

    public void setTag2(String Tag2) {
        this.Tag2 = Tag2;
    }
}
    

