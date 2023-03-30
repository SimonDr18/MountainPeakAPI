package com.drieux.MountainPeakAPI.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="peak")
public class Peak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "latitude")
    private float latitude;

    @Column(name = "longitude")
    private float longitude;

    @Column(name = "altitude")
    private int altitude;

    @Column(name = "name")
    private String name;

    public Peak(){}

    public Peak(String name, float latitude, float longitude, int altitude){
        super();
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public long getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    private void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    private void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getAltitude() {
        return altitude;
    }

    private void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void updatePeak(Peak peak){
        setName(peak.getName());
        setAltitude(peak.getAltitude());
        setLatitude(peak.getLatitude());
        setLongitude(peak.getLongitude());
    }

    @Override
    public String toString(){
        // Example : "N°20: Peak Everest, 5678m high at coordinates 41.40338, 2.17403"
        return "N°" + this.id + ": Peak " + this.name + ", " + this.altitude +"m high at coordinates "+ this.latitude + ", " + this.longitude;
    }
}
