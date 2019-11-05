package State;

public class Death  implements PatientState{

    private Patient patient;

    public Death(Patient patient) {
            this.patient=patient;
    }

    @Override
    public void hasDiabetes() {
        System.out.println("RIP it's to late");
    }

    @Override
    public void hasFever() {
        System.out.println("RIP it's to late");
    }

    @Override
    public void hasTuberculosis() {
        System.out.println("RIP it's to late");
    }

    @Override
    public void beHealthy() {
        System.out.println("RIP it's to late");
    }

    @Override
    public void rip() {
        System.out.println("RIP it's to late");
    }

    @Override
    public String getType() {
        return "death";
    }
}
