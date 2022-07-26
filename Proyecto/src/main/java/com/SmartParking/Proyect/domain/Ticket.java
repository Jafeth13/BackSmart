package com.SmartParking.Proyect.domain;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Ticket;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private Parking_Lot parking_Lot;

    @ManyToOne
    @JoinColumn(name = "Spot_Id")
    private Spot spot;
    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User_Smart user_smart;
    @ManyToOne
    @JoinColumn(name = "Rate_Type_Id")
    private RateType rateType;

    private Date Star_Day;

    private Date End_Day;

    public Ticket(int id_Ticket, Parking_Lot parking_Lot, Spot spot, User_Smart user_smart, RateType rateType, Date star_Day, Date end_Day) {
        this.id_Ticket = id_Ticket;
        this.setParking_Lot(parking_Lot);
        this.setSpot(spot);
        this.setUser_smart(user_smart);
        this.setRateType(rateType);
        Star_Day = star_Day;
        End_Day = end_Day;
    }

    public Ticket() {

    }

    public int getId_Ticket() {
        return id_Ticket;
    }

    public void setId_Ticket(int id_Ticket) {
        this.id_Ticket = id_Ticket;
    }

    public Parking_Lot getParking_Lot() {
        return parking_Lot;
    }

    public void setParking_Lot(Parking_Lot parking_Lot) {
        this.parking_Lot = parking_Lot;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public User_Smart getUser_smart() {
        return user_smart;
    }

    public void setUser_smart(User_Smart user_smart) {
        this.user_smart = user_smart;
    }

    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    public Date getStar_Day() {
        return Star_Day;
    }

    public void setStar_Day(Date star_Day) {
        Star_Day = star_Day;
    }

    public Date getEnd_Day() {
        return End_Day;
    }

    public void setEnd_Day(Date end_Day) {
        End_Day = end_Day;
    }
}
