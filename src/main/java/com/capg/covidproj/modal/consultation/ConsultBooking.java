package com.capg.covidproj.modal.consultation;

import com.capg.covidproj.modal.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ConsultBooking implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String consult_UUID;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "user_UUID",nullable = true)
    private User patient;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "doctor_UUID",nullable = true)
    private Doctor doctor;
    @Getter @Setter
    @OneToMany(mappedBy = "consultBooking")
    private List<Priscription> priscription;

}
