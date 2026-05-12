package Entities;

public class GeneralPractitioner {
    private boolean walkinAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;

    public GeneralPractitioner(boolean walkinAvailable, boolean homeVisitAvailable, boolean vaccinationCertified) {
        this.walkinAvailable = walkinAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;
    }
}
