package State;

import java.time.Period;

public class Healthy implements PatientState {

    Patient patient;

    public Healthy(Patient newPatient){
        patient=newPatient;
    }


    @Override
    public void hasDiabetes() {
        System.out.println("from healthy to diabetic");
        patient.setPatientState(patient.changeToDiabetic());

    }

    @Override
    public void hasFever() {
        System.out.println("from healthy to fever");
        patient.setPatientState(patient.changeToFever());
    }

    @Override
    public void hasTuberculosis() {
        System.out.println("from healthy to tuberculosis");
        patient.setPatientState(patient.changeToTuberculosis());
    }

    @Override
    public void beHealthy() {
        System.out.println("already healthy");
    }

    @Override
    public void rip() {
        System.out.println("healthy is dead");
        patient.setPatientState(patient.changeToDead());
    }

    @Override
    public String getType() {
        return "h";
    }
}
