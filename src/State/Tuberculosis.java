package State;

public class Tuberculosis implements PatientState {

    private Patient patient;

    public Tuberculosis(Patient patient) {
        this.patient=patient;
    }

    @Override
    public void hasDiabetes() {
        System.out.println("from Tuberculosis to diabetic");
        patient.setPatientState(patient.changeToDiabetic());
    }

    @Override
    public void hasFever() {
        System.out.println("from Tuberculosis to fever");
        patient.setPatientState(patient.changeToFever());
    }

    @Override
    public void hasTuberculosis() {
        System.out.println("has already tuberculosis");
    }

    @Override
    public void beHealthy() {
        System.out.println("from Tuberculosis to healthy ");
        patient.setPatientState(patient.changeToHealthy());
    }

    @Override
    public void rip() {
        System.out.println("from Tuberculosis to dead");
        patient.setPatientState(patient.changeToDead());
    }

    @Override
    public String getType() {
        return "tuberculosis";
    }
}
