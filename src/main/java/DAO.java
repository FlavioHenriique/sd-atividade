import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DAO {

    private EntityManager em;

    public DAO(){
        em = Persistence.createEntityManagerFactory("SD").createEntityManager();
    }

    public void salvar(Entidade entidade){
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
        em.clear();

    }

    public void atualizar(Entidade entidade){
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
        em.clear();

    }
}
