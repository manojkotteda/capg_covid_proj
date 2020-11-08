package com.capg.covidproj.modal.consultation;

import com.capg.covidproj.modal.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Priscription implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    private String priscription_UUID;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="user_UUID", nullable=true)
    private User patient;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="doctor_UUID", nullable=true)
    private Doctor doctor;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="consult_UUID", nullable=true)
    private  ConsultBooking consultBooking;
    @Getter @Setter
    private String medecine;
    @Getter @Setter
    private String tests;


}
