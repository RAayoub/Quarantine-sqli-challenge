package State;

public class Diabetes implements PatientState{

    private Patient patient;

    public Diabetes(Patient patient) {
        this.patient=patient;
    }

    @Override
    public void hasDiabetes() {
        System.out.println("already diabetic");
    }

    @Override
    public void hasFever() {
        System.out.println("change from Diabetic to Fever");
        patient.setPatientState(patient.changeToFever());
    }

    @Override
    public void hasTuberculosis() {
        System.out.println("change from  to T");
       // patient.setPatientState(patient.changeToTuberculosis());
    }

    @Override
    public void beHealthy() {
        System.out.println("you're cured ");
      //  patient.setPatientState(patient.changeToHealthy());
    }

    @Override
    public void rip() {
        System.out.println("change from D to Death");
        patient.setPatientState(patient.changeToDead());
    }

    @Override
    public String getType() {
        return "diabetes";
    }
}
