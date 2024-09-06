package com.example;

public class DoctorDetails {
    private String doctorName;
    private String bachelor;
    private String arrtime;
    private String deptime;
    private String imageFileName;

    // Constructor
    public DoctorDetails(String doctorName, String bachelor, String arrtime, String deptime, String imageFileName) {
        this.doctorName = doctorName;
        this.bachelor = bachelor;
        this.arrtime = arrtime;
        this.deptime = deptime;
        this.imageFileName = imageFileName;
    }

    // Getters and setters
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getBachelor() {
        return bachelor;
    }

    public void setBachelor(String bachelor) {
        this.bachelor = bachelor;
    }

    public String getArrtime() {
        return arrtime;
    }

    public void setArrtime(String arrtime) {
        this.arrtime = arrtime;
    }

    public String getDeptime() {
        return deptime;
    }

    public void setDeptime(String deptime) {
        this.deptime = deptime;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
