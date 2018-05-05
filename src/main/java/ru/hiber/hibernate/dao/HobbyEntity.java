package ru.hiber.hibernate.dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Ник on 10.06.2017.
 */
@Entity
@Table(name = "hobby", schema = "public", catalog = "postgres")
public class HobbyEntity {
    private String hobbyId;
    private Collection<ContactHobbyDetailEntity> contactHobbyDetailsByHobbyId;

    @Id
    @Column(name = "hobby_id", nullable = false, length = 20)
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HobbyEntity that = (HobbyEntity) o;

        if (hobbyId != null ? !hobbyId.equals(that.hobbyId) : that.hobbyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return hobbyId != null ? hobbyId.hashCode() : 0;
    }

    @OneToMany(mappedBy = "hobbyByHobbyId")
    public Collection<ContactHobbyDetailEntity> getContactHobbyDetailsByHobbyId() {
        return contactHobbyDetailsByHobbyId;
    }

    public void setContactHobbyDetailsByHobbyId(Collection<ContactHobbyDetailEntity> contactHobbyDetailsByHobbyId) {
        this.contactHobbyDetailsByHobbyId = contactHobbyDetailsByHobbyId;
    }
}
