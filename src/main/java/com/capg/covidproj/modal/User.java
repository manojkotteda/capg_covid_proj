package com.capg.covidproj.modal;

import com.capg.covidproj.modal.consultation.ConsultBooking;
import com.capg.covidproj.modal.consultation.Doctor;
import com.capg.covidproj.modal.consultation.Priscription;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "_User")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String user_UUID;
    private String user_name;
    private String user_email;
    private String user_image_url;
    @ManyToMany
    @JoinTable(name = "user_doctor", joinColumns = @JoinColumn(name = "user_UUID"),
            inverseJoinColumns = @JoinColumn(name = "doctor_UUID"))
    private List<Doctor> doctors;
    @OneToMany(mappedBy = "patient")
    private List<Priscription> priscriptions;
    @OneToMany(mappedBy = "patient")
    private List<ConsultBooking> bookings;
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "user_UUID='" + user_UUID + '\'' +
                ", u_name='" + user_name + '\'' +
                ", Email='" + user_email + '\'' +
                ", image_url='" + user_image_url + '\'' +
                ", doctors=" + doctors +
                ", priscriptions=" + priscriptions +
                ", bookings=" + bookings +
                '}';
    }

    public String getUser_UUID() {
        return user_UUID;
    }

    public void setUser_UUID(String user_UUID) {
        this.user_UUID = user_UUID;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_image_url() {
        return user_image_url;
    }

    public void setUser_image_url(String user_image_url) {
        this.user_image_url = user_image_url;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Priscription> getPriscriptions() {
        return priscriptions;
    }

    public void setPriscriptions(List<Priscription> priscriptions) {
        this.priscriptions = priscriptions;
    }

    public List<ConsultBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<ConsultBooking> bookings) {
        this.bookings = bookings;
    }
}
