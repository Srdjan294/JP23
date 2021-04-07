/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author srdja
 */
@MappedSuperclass
public abstract class Entitet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Operater operaterUnosa;
    
    @ManyToOne
    private Operater operaterPromjene;
    
    private Date datumUnosa;
    private Date datumPromjene;

    public Date getDatumUnosa() {
        return datumUnosa;
    }

    public void setDatumUnosa(Date datumUnosa) {
        this.datumUnosa = datumUnosa;
    }

    public Date getDatumPromjene() {
        return datumPromjene;
    }

    public void setDatumPromjene(Date datumPromjene) {
        this.datumPromjene = datumPromjene;
    }
    
    

    public Operater getOperaterUnosa() {
        return operaterUnosa;
    }

    public void setOperaterUnosa(Operater operaterUnosa) {
        this.operaterUnosa = operaterUnosa;
    }

    public Operater getOperaterPromjene() {
        return operaterPromjene;
    }

    public void setOperaterPromjene(Operater operaterPromjene) {
        this.operaterPromjene = operaterPromjene;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
