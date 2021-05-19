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
public class HStudentGroupsModel {
    private int ID;     
    private String AYS;
    private String program;
    private int groupNo;
    private int subGroupNo;
    private String groupID;
    private String subGroupID;
    
    public HStudentGroupsModel(int ID,String AYS, String program, int groupNo, int subGroupNo, String groupID, String subGroupID){
        this.ID = ID;
        this.AYS = AYS;
        this.program = program;
        this.groupNo = groupNo;
        this.subGroupNo = subGroupNo;
        this.groupID = groupID;
        this.subGroupID = subGroupID;
       
               
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    public String getAYS() {
        return AYS;
    }

    public void setAYS(String AYS) {
        this.AYS = AYS;
    }

    public String getprogram() {
        return program;
    }

    public void setprogram(String program) {
        this.program = program;
    }

    public int getgroupNo() {
        return groupNo;
    }

    public void setgroupNo(int groupNo) {
        this.groupNo = groupNo;
    }
    
     public int getsubGroupNo() {
        return subGroupNo;
    }

    public void setsubGroupNo(int subGroupNo) {
        this.subGroupNo = subGroupNo;
    }

    public String getgroupID() {
        return groupID;
    }

    public void setgroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getsubGroupID() {
        return subGroupID;
    }

    public void setsubGroupID(String subGroupID) {
        this.subGroupID = subGroupID;
    }
    
    
}
