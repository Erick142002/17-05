package cat.prateducacio.app03.ciutat.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ciutats", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nom"})
})
public class Ciutat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom", nullable = false, length = 45)
    private String nom;

    @Column(name = "prefix_tel", nullable = false)
    private int prefixTel;

    // Constructors, getters, and setters

    public Ciutat() {
    }

    public Ciutat(String nom, int prefixTel) {
        this.nom = nom;
        this.prefixTel = prefixTel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrefixTel() {
        return prefixTel;
    }

    public void setPrefixTel(int prefixTel) {
        this.prefixTel = prefixTel;
    }
}
