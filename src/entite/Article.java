/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
//@XmlRootElement
public class Article implements Serializable{
    private static final long serialVersionUID = 1L;
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarticle")
    private int idArticle;
    @Column(name = "libarticle")
    private String libarticle;
    @Column(name = "stock")
    private String stock;
 
    //gestion de 
    @ManyToOne
    private Categorie categorie;
  
    public Article() {
      //  super();
    }
    public Article(int id,String lib,String stock){
      this.setIdarticle(id);
      this.setLibarticle(lib);
      this.setStock(stock);
    }

    public Article(int idarticle) {
      this.idArticle=idarticle;
    }
  
    public int getIdarticle() {
        return this.idArticle;
    }
    
    public void setIdarticle(int idarticle) {
       this.idArticle=idarticle;    
    }
   
    public String getLibarticle() {
        return this.libarticle;
    }

    public void setLibarticle(String libarticle) {
        this.libarticle=libarticle;
    }
   
    public String getStock() {
       return this.stock;
    }

    public void setStock(String stock) {
      this.stock=stock;
    }
    
    public void setCategorie(Categorie cat){
        this.categorie=cat;
    }
    
    public Categorie getCategorie(Categorie cat){
        return this.categorie;
    }
    
}
