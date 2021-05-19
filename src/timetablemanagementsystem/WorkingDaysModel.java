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
public class WorkingDaysModel {
    
    private String numof_workingdays;
    private int numof_miniutes,numof_hours,id;
    private boolean monday,tuesday,wednesday,thrusday,friday,saterday,sunday;

    public WorkingDaysModel(String numof_workingdays, int numof_miniutes, int numof_hours, boolean monday, boolean tuesday, boolean wednesday, boolean thrusday, boolean friday, boolean saterday, boolean sunday) {
        this.numof_workingdays = numof_workingdays;
        this.numof_miniutes = numof_miniutes;
        this.numof_hours = numof_hours;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thrusday = thrusday;
        this.friday = friday;
        this.saterday = saterday;
        this.sunday = sunday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getNumof_workingdays() {
        return numof_workingdays;
    }

    public void setNumof_workingdays(String numof_workingdays) {
        this.numof_workingdays = numof_workingdays;
    }

    public int getNumof_miniutes() {
        return numof_miniutes;
    }

    public void setNumof_miniutes(int numof_miniutes) {
        this.numof_miniutes = numof_miniutes;
    }

    public int getNumof_hours() {
        return numof_hours;
    }

    public void setNumof_hours(int numof_hours) {
        this.numof_hours = numof_hours;
    }

    public boolean isMonday() {
        return monday;
    }

    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    public boolean isThrusday() {
        return thrusday;
    }

    public void setThrusday(boolean thrusday) {
        this.thrusday = thrusday;
    }

    public boolean isFriday() {
        return friday;
    }

    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    public boolean isSaterday() {
        return saterday;
    }

    public void setSaterday(boolean saterday) {
        this.saterday = saterday;
    }

    public boolean isSunday() {
        return sunday;
    }

    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }

    @Override
    public String toString() {
        return "WorkingDaysModel{" + "numof_workingdays=" + numof_workingdays + ", numof_miniutes=" + numof_miniutes + ", numof_hours=" + numof_hours + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thrusday=" + thrusday + ", friday=" + friday + ", saterday=" + saterday + ", sunday=" + sunday + '}';
    }
    
    
    
}
