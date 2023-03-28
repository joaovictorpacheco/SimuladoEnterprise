import domain.Advogado;
import domain.Estado;
import domain.Processo;
import domain.TipoDeAcao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");

        EntityManager manager = factory.createEntityManager();


        //save(manager);
        //findById(manager);

        //findAll(manager);
    }
    //Consulta Todos os itena
    private static void findAll(EntityManager manager) {
        String jpql = "FROM Processo";

        List<Processo> resultList = manager.createQuery(jpql).getResultList();

        resultList.stream().forEach(System.out::println);
    }

    //Consulta
    private static void findById(EntityManager manager) {
        Processo processo = manager.find(Processo.class, 1L);
        System.out.println(processo);
    }

    private static void save(EntityManager manager) {
        Estado uf = new Estado();
        uf.setNome("São Paulo").setSigla("SP");

        TipoDeAcao tpAcao = new TipoDeAcao();
        tpAcao.setNome("Ação de Alimentos");

        Advogado adv = new Advogado();
        adv.setEstado(uf).setNome("João Victor Pacheco").setNumeroOAB("123456");

        Processo alimentos = new Processo();
        alimentos.setAdvogado(adv).setTipoDeAcao(tpAcao).setNumero("12345678910").setProBono(true).setDataDeDistribuicao(LocalDate.now());

        manager.getTransaction().begin();
        manager.persist(uf);
        manager.persist(tpAcao);
        manager.persist(adv);
        manager.persist(alimentos);
        manager.getTransaction().commit();
    }
}
