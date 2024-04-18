package models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "OrganizationType")
@XmlEnum
public enum OrganizationType {
    @XmlEnumValue("COMMERCIAL")
    COMMERCIAL,
    @XmlEnumValue("GOVERNMENT")
    GOVERNMENT,
    @XmlEnumValue("TRUST")
    TRUST,
    @XmlEnumValue("PRIVATE_LIMITED_COMPANY")
    PRIVATE_LIMITED_COMPANY
}
