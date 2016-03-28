package de.richtercloud.type.operator.nonsense;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class A implements Serializable {
    private static final long serialVersionUID = 1L;
    private String b;
    @Id
    private Long id;

    public A() {
    }

    public A(Long id, String b) {
        this.id = id;
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
