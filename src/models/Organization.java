package models;

import commands.Validator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class Organization {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным,
    //Значение этого поля должно генерироваться автоматически

    private String name; //Поле не может быть null, Строка не может быть пустой

    private Coordinates coordinates; //Поле не может быть null

    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private Long annualTurnover; //Значение поля должно быть больше 0

    private String fullName; //Строка не может быть пустой, Поле не может быть null

    private OrganizationType type; //Поле может быть null

    private Address postalAddress; //Поле может быть null

    public Organization() {
        this.id = IdGenerator.generateId();
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDate.now();
        this.annualTurnover = null;
        this.fullName = null;
        this.type = null;
        this.postalAddress = null;
    }

    public Organization(int id) {
        this.id = id;
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDate.now();
        this.annualTurnover = null;
        this.fullName = null;
        this.type = null;
        this.postalAddress = null;
    }

    public Organization(String[] data) throws Exception {
        Validator.idIsGood(data[0]);
        Validator.notNull(data[1], "name");
        Validator.notNull(data[2], "coordinate X");
        Validator.coordinateIsGood(data[3], "coordinate Y");
        Validator.notNull(data[4], "data");
        Validator.numIsGood(data[5]);
        Validator.notNull(data[6], "fullName");
        Validator.typeIsGood(data[7]);
        Validator.notNull(data[8], "street");
        Validator.zipCodeIsGood(data[9]);

        this.id = Integer.parseInt(data[0]);
        this.name = data[1];
        this.coordinates = new Coordinates(Long.valueOf(data[2]), Double.valueOf(data[3]));
        this.creationDate = LocalDate.now();
        this.annualTurnover = Long.parseLong(data[5]);
        this.fullName = data[6];
        this.type = OrganizationType.valueOf(data[7]);
        this.postalAddress = new Address(data[8], data[9]);
    }


    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ",name=" + name +
                ",coordinates=" + coordinates +
                ",creationDate=" + creationDate +
                ",annualTurnover=" + annualTurnover +
                ",fullName=" + fullName +
                ",type=" + type +
                ",postalAddress" + postalAddress +
                "}";
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(Long annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }
}

