import State.*;

import java.util.ArrayList;
import java.util.List;

public class Quarantine {

    //Patient list
    private List<Patient> patients;
    //String contains all medicines
    String treatment ="medicine";

    //Getters and Setters
    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    /*
    Constructor create list of patients based on @param String
    @param patientList like "H,F.."
    H for healthy
    F for Fever and so on
     */
    public Quarantine(String patientList) {
        patients = new ArrayList<>();
        //take char by char in pair positions(i+2) to avoid comma
        for (int i =0;i <= patientList.toCharArray().length;i=i+2){

            Patient statelessPatient = new Patient();       //initiate patient with healthy status

            char patient= patientList.toCharArray()[i];     //return char with a pair position

            //in each condition statement it creates a new Patient with a specific state based on the char returned
            //and then add it to the patients list
            if (Character.toString(patient).equals("H")){
                statelessPatient.setPatientState(statelessPatient.changeToHealthy());
                patients.add(statelessPatient);
            }
            if (Character.toString(patient).equals("F")){
                statelessPatient.setPatientState(statelessPatient.changeToFever());
                patients.add(statelessPatient);
            }
            if (Character.toString(patient).equals("D")){
                statelessPatient.setPatientState(statelessPatient.changeToDiabetic());
                patients.add(statelessPatient);
            }
            if (Character.toString(patient).equals("T")){
                statelessPatient.setPatientState(statelessPatient.changeToTuberculosis());
                patients.add(statelessPatient);
            }

        }
    }

    //Return String contains how much patient we have in each state
    public String report() {
        //initialize cpts
        int F=0,H=0,D=0,T=0,X=0;
        for (Patient patient:patients){

            //checking the condition with the type of each instance
            if (patient.getPatientState() instanceof Healthy){
                H++;
            }
            if (patient.getPatientState() instanceof Fever){
                F++;
            }
            if (patient.getPatientState() instanceof Tuberculosis){
                T++;
            }
            if (patient.getPatientState() instanceof Death){
                X++;
            }
            if (patient.getPatientState() instanceof Diabetes){
                D++;
            }

        }
        return "F:"+F+" H:"+H+" D:"+D+" T:"+T+" X:"+X;
    }

    //Change patient status based on it's last status and the medicine given to him
    public void wait40Days() {
        for (Patient patient:patients) {
            if (this.getTreatment().contains("antibiotic")){
                if (patient.getPatientState() instanceof Tuberculosis){
                    patient.setPatientState(patient.changeToHealthy());
                }
            }
            if (!getTreatment().contains("insulin")){
                if (patient.getPatientState() instanceof Diabetes){
                    patient.setPatientState(patient.changeToDead());
                }
            }
            if (getTreatment().contains("aspirin")||getTreatment().contains("paracetamol") ){
                if (patient.getPatientState() instanceof Fever){
                    patient.setPatientState(patient.changeToHealthy());
                }
            }
            if (getTreatment().contains("antibiotic") && getTreatment().contains("insulin") ){
                if (patient.getPatientState() instanceof Healthy){
                    patient.setPatientState(patient.changeToFever());
                }else{
                if (patient.getPatientState()instanceof Fever){
                    patient.setPatientState(patient.changeToHealthy());
                }}

            }
            if (getTreatment().contains("aspirin")&& getTreatment().contains("paracetamol") ){

                    patient.setPatientState(patient.changeToDead());

            }
        }
    }

    //add aspirin to patients treatment
    public void aspirin() {

        this.setTreatment(this.getTreatment()+"-aspirin");
    }

    //add antibiotic to patients treatment
    public void antibiotic() {
        this.setTreatment(this.getTreatment()+"-antibiotic");
    }

    //add insulin to patients treatment
    public void insulin() {
        this.setTreatment(this.getTreatment()+"-insulin");
    }

    //add paracetamol to patients treatment
    public void paracetamol() {
        this.setTreatment(this.getTreatment()+"-paracetamol");
    }



}
