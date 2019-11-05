package State;

public class Fever  implements PatientState{

    private Patient patient;

    public Fever(Patient patient) {
        this.patient=patient;
    }

    @Override
    public void hasDiabetes() {
        System.out.println("from fever to diabetic");
        patient.setPatientState(patient.changeToDiabetic());
    }

    @Override
    public void hasFever() {
        System.out.println("has already fever");
    }

    @Override
    public void hasTuberculosis() {
        System.out.println("from fever to tuberculosis");
        patient.setPatientState(patient.changeToTuberculosis());
    }

    @Override
    public void beHealthy() {
        System.out.println("Cured from fever");
        patient.setPatientState(patient.changeToHealthy());
    }

    @Override
    public void rip() {
        System.out.println("Fever killed him");
        patient.setPatientState(patient.changeToDead());
    }

    @Override
    public String getType() {
        return "fever";
    }
}
