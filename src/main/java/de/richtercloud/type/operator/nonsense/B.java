/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.richtercloud.type.operator.nonsense;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

/**
 *
 * @author richter
 */
@Entity
@Inheritance
public class B extends A {
    private static final long serialVersionUID = 1L;
    private String c;

    public B() {
    }

    public B(String c, String b) {
        super(b);
        this.c = c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getC() {
        return c;
    }
    
}
