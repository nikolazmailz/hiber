package ru.hiber.hibernate.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Collection;
import java.util.Date;
/**
 * Created by Ник on 10.06.2017.
 */
@Entity
@Table(name = "contact", schema = "public", catalog = "postgres")
public class ContactEntity {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int version;
    private Collection<ContactHobbyDetailEntity> contactHobbyDetailsById;
    private Collection<ContactTelDetailEntity> contactTelDetailsById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 60)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 40)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = true, insertable = true, updatable = true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "version", nullable = false, insertable = true, updatable = true)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntity that = (ContactEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }

    @OneToMany(mappedBy = "contactByContactId")
    public Collection<ContactHobbyDetailEntity> getContactHobbyDetailsById() {
        return contactHobbyDetailsById;
    }

    public void setContactHobbyDetailsById(Collection<ContactHobbyDetailEntity> contactHobbyDetailsById) {
        this.contactHobbyDetailsById = contactHobbyDetailsById;
    }

    @OneToMany(mappedBy = "contactByContactId")
    public Collection<ContactTelDetailEntity> getContactTelDetailsById() {
        return contactTelDetailsById;
    }

    public void setContactTelDetailsById(Collection<ContactTelDetailEntity> contactTelDetailsById) {
        this.contactTelDetailsById = contactTelDetailsById;
    }
}
