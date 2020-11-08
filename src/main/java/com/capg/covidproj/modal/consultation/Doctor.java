package com.capg.covidproj.modal.consultation;

import com.capg.covidproj.modal.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Doctor implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String doctor_UUID;
    @Getter @Setter
    private String doctor_name;
    @Getter @Setter
    private String doctor_email;
    @Getter @Setter
    private String doctor_image_url;
    @Getter @Setter
    @ManyToMany(mappedBy = "doctors")
    private List<User> patients;
    @Getter @Setter
    private Double consult_fee;
    @Getter @Setter
    @OneToMany(mappedBy = "doctor")
    private List<Priscription> priscriptions;
    @Getter @Setter
    @OneToMany(mappedBy = "doctor")
    private  List<ConsultBooking> bookings;

    public Doctor() {
    }
}
