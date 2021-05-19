/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem;

/**
 *
 * @author umesha
 */
public class RoomCannotReservedModel {
    
     
    private String RoomNumber;
    private int start_Time,End_Time,id;
    private boolean monday,tuesday,wednesday,thrusday,friday,saterday,sunday;

    public RoomCannotReservedModel(String RoomNumber, int start_Time , int End_Time , boolean monday, boolean tuesday, boolean wednesday, boolean thrusday, boolean friday, boolean saterday, boolean sunday) {
        this. RoomNumber= RoomNumber;
        this.start_Time = start_Time;
        this.End_Time = End_Time;
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

    
    
    public String getRoomNumber() {
        return RoomNumber;
    }

    public void SetRoomNumber(String RoomNumber) {
        this.RoomNumber= RoomNumber;
    }

    public int getstart_Time() {
        return start_Time;
    }

    public void setNumof_m(int start_Time) {
        this.start_Time= start_Time;
    }

    public int getEnd_Time() {
        return End_Time;
    }

    public void setEnd_Time(int End_Time) {
        this.End_Time= End_Time;
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
        return "RoomCannotReservedModel{" + "RoomNumber=" + RoomNumber + ",start_Time=" + start_Time + ", End_Time" + End_Time + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thrusday=" + thrusday + ", friday=" + friday + ", saterday=" + saterday + ", sunday=" + sunday + '}';
    }
    
    
    
}

    
    
