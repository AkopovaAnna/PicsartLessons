package com.picsart.Lesson3.objects.hospital;

import com.picsart.Lesson3.objects.hospital.model.Doctor;
import com.picsart.Lesson3.objects.hospital.model.Hospital;
import com.picsart.Lesson3.objects.hospital.model.Patient;

public class HospitalRunner {

    public static void main(String[] args) {

        Hospital erebuni = new Hospital();
        erebuni.setHospitalId(1);
        erebuni.setHospitalName("Erebuni");

        Hospital nairi = new Hospital();
        nairi.setHospitalId(2);
        nairi.setHospitalName("Nairi");

        Doctor doctor1 = new Doctor();
        doctor1.setDocId(1);
        doctor1.setFirstName("Nune");
        doctor1.setLastName("Samvelyan");
        doctor1.setSpecialisation("Nyardaban");

        Doctor doctor2 = new Doctor();
        doctor2.setDocId(2);
        doctor2.setFirstName("Arman");
        doctor2.setLastName("Grigoryan");
        doctor2.setSpecialisation("surgery");

        Patient patient1 = new Patient();
        patient1.setpId(1);
        patient1.setFirstName("Vladimir");
        patient1.setLastName("Petrosyan");
        patient1.setDisease("headeack");

        Patient patient2 = new Patient();
        patient2.setpId(2);
        patient2.setFirstName("Armine");
        patient2.setLastName("Gevorgyan");
        patient2.setDisease("headeack");


    }
}
