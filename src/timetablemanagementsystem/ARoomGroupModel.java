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
public class ARoomGroupModel {
    
    private int id;
    private String group_name;
    private String groupSub_name;
    private String groupTag;
    private String groupBuilding;
    private String groupRoom;    
    
public ARoomGroupModel (int id, String group_name, String groupSub_name, String groupTag, String groupBuilding, String groupRoom){

        this.id = id;
        this.group_name = group_name;
        this.groupSub_name = groupSub_name; 
        this.groupTag = groupTag;  
        this.groupBuilding = groupBuilding;  
        this.groupRoom = groupRoom;  
        
    }     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroupSub_name() {
        return groupSub_name;
    }

    public void setGroupSub_name(String groupSub_name) {
        this.groupSub_name = groupSub_name;
    }

    public String getGroupTag() {
        return groupTag;
    }

    public void setGroupTag(String groupTag) {
        this.groupTag = groupTag;
    }

    public String getGroupBuilding() {
        return groupBuilding;
    }

    public void setGroupBuilding(String groupBuilding) {
        this.groupBuilding = groupBuilding;
    }

    public String getGroupRoom() {
        return groupRoom;
    }

    public void setGroupRoom(String groupRoom) {
        this.groupRoom = groupRoom;
    }

}
