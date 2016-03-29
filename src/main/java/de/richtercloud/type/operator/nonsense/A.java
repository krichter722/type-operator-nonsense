package de.richtercloud.type.operator.nonsense;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Entity
public class A implements Serializable {
    private static final long serialVersionUID = 1L;
    private String b;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public A() {
    }

    public A(String b) {
        this.b = b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getB() {
        return b;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
