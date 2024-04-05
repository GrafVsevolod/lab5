package comparators;

import models.Organization;

import java.util.Comparator;

public class OrganizationsComparator implements Comparator<Organization> {
    @Override
    public int compare(Organization org1, Organization org2){
        return org1.getAnnualTurnover().compareTo(org2.getAnnualTurnover());
    }
}
