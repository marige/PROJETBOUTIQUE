/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie{
    @OneToMany(targetEntity=Article.class)
    private List listArticles;
    @Column(name = "libCategorie")
    private String libcat;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategorie")
    private int idcat;
    
    
    public Categorie() {
    }
     public Categorie(int idCategorie,String libcat) {
       this.setIdCategorie(idCategorie);
       this.setLibCategorie(libcat);
    }
    public Categorie(int idCategorie) {
       // idCat.set(idCategorie);
    }
 
    public Integer getIdCategorie() {
        return this.idcat;
    }

    public void setIdCategorie(Integer idCategorie) {
       this.idcat=idCategorie;
    }
    
 
    public String getLibCategorie() {
        return this.libcat;
    }

    public void setLibCategorie(String libCategorie) {
        this.libcat=libCategorie;
    }
    public void setListArticle(List article){
        this.listArticles=article;
    }
    public List getListArticle(){
        return this.listArticles;
    }
    @Override
    public String toString(){
        return this.libcat;
    }
}
