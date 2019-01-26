package com.squad.sippe.squadsippe.domain.generic;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public class GenericDomain  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    protected boolean active;

    /*private Integer createFrom;*/

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    protected Date create;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    protected Date update;


    public GenericDomain() {
    }

    public GenericDomain(Integer id, boolean active, Date update, Date create) {
        this.id = id;
        this.active = active;
        this.update = update;
        this.create = create;
    }

    public GenericDomain(Integer id, boolean active) {
        this.id = id;
        this.active = active;
        this.update = new Date();
        this.create = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericDomain)) return false;
        GenericDomain that = (GenericDomain) o;
        return isActive() == that.isActive() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCreate(), that.getCreate()) &&
                Objects.equals(getUpdate(), that.getUpdate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), isActive(), getCreate(), getUpdate());
    }
}
