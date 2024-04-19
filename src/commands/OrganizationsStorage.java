package commands;

import models.Organization;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;


public class OrganizationsStorage {
    public LinkedList<Organization> orgs = new LinkedList<>();

    public void addOrganizationsToOrgs(Organization organization){
        orgs.add(organization);
    }

    public LinkedList<Organization> getOrgs(){
        return orgs;
    }
}
