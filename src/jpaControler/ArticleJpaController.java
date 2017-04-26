/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControler;

import entite.Article;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
//import jpaControler.exceptions.NonexistentEntityException;

/**
 *
 * @author OBAM
 */
public class ArticleJpaController implements Serializable {
    private EntityManagerFactory emf=null;
    private EntityManager em = null;
    public ArticleJpaController() {
         emf=Persistence.createEntityManagerFactory("PROJETBOUTIQUEPU");   
    }

    public void create(Article article) {
        try {
            em=emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(article);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Article article) throws Exception {
        try {
            em=emf.createEntityManager();
            em.getTransaction().begin();
            article = em.merge(article);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = article.getIdarticle();    
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) {
            em=emf.createEntityManager();
            em.getTransaction().begin();
            Article article;
            try {
                article = em.getReference(Article.class, id);
                article.getIdarticle();
            em.remove(article);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Article> findArticleEntities() {
        return findArticleEntities(true, -1, -1);
    }

    public List<Article> findArticleEntities(int maxResults, int firstResult) {
        return findArticleEntities(false, maxResults, firstResult);
    }

    private List<Article> findArticleEntities(boolean all, int maxResults, int firstResult) {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Article.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Article findArticle(Integer id) {
        try {
            return em.find(Article.class, id);
        } finally {
            em.close();
        }
    }

    public int getArticleCount() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Article> rt = cq.from(Article.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public Article requeteNomme(){
         Query q=em.createNamedQuery("SELECT a FROM Article a WHERE a.idarticle = :idarticle");
         q.setParameter("idarticle", 1);
         return (Article)q.getSingleResult();
    }
    
}
