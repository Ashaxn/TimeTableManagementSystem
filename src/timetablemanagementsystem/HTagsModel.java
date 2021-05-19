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
public class HTagsModel {
    private int ID; 
    private String tagName;
    private String tagCode;
    private String relatedTag;
    
    public HTagsModel(int ID, String tagName, String tagCode, String relatedTag){
        this.ID = ID;
        this.tagName= tagName;
        this.tagCode = tagCode;
        this.relatedTag = relatedTag;   
    }
    
     public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String gettagName() {
        return tagName;
    }

    public void settagName(String tagName) {
        this.tagName = tagName;
    }

    public String gettagCode() {
        return tagCode;
    }

    public void settagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getrelatedTag() {
        return relatedTag;
    }

    public void setrelatedTag(String relatedTag) {
        this.relatedTag = relatedTag;
    }
    
}
    