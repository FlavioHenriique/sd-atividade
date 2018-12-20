
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DAO {

    private Object lock = new Object();
    private EntityManager em;

    public DAO() {
        em = Persistence.createEntityManagerFactory("SD").createEntityManager();
    }

    public void salvar(Entidade entidade) {
        synchronized (lock) {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
            em.clear();
        };
    }

    public void atualizar(Entidade entidade) {
        synchronized (lock) {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
            em.clear();
        }
    }
}
