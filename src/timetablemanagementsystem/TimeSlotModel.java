/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem;

/**
 *
 * @author pramitha
 */
public class TimeSlotModel {
    
    private int slotid;
    private String slot;

    public TimeSlotModel(String slot) {
        this.slot = slot;
    }

    public TimeSlotModel(int slotid, String slot) {
        this.slotid = slotid;
        this.slot = slot;
    }

    public int getSlotid() {
        return slotid;
    }

    public void setSlotid(int slotid) {
        this.slotid = slotid;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "TimeSlotModel{" + "slotid=" + slotid + ", slot=" + slot + '}';
    }
    
    
    
}
