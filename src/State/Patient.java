package State;

public class Patient {



    PatientState healthy,diabetic,dead,hasFever,hasTuberculosis;

    PatientState patientState;

    public PatientState getPatientState() {
        return patientState;
    }


    public Patient(){
        healthy = new Healthy(this);
        dead = new Death(this);
        diabetic =  new Diabetes(this);
        hasFever =  new Fever(this);
        hasTuberculosis =  new Tuberculosis(this);
    }

    //Set state to a Patient
    public void setPatientState(PatientState patientState){
        this.patientState=patientState;
    }

    //Change Status
    public PatientState changeToDiabetic() {return diabetic;}
    public PatientState changeToHealthy() {return healthy;}
    public PatientState changeToDead() {return dead;}
    public PatientState changeToTuberculosis() {return hasTuberculosis;}
    public PatientState changeToFever() {return hasFever;}
}
