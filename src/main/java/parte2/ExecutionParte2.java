package parte2;

import classes.Aluno;
import classes.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecutionParte2 {

    public static void main(String[] args) {

//      OBS: Esse codigo deve executar SEM ERROS com a implementacao JPA que foi definida no "persistence.xml".
//      Se estiver somente com o JPA baixado, o codigo NAO IRA funcionar.
//
//      O ideal é que nessa parte (Parte 2) o codigo EXECUTE SEM ERROS, pois aqui tera uma implementacao JPA sendo utilizada.

        // 1 - Passos iniciais para criar um gerenciadop de entidades com o banco de dados especificado no arquivo  "persistence.xml"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("parte2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1 - Criar instancias para serem adicionadas no banco de dados
        Estado estadoParaAdicionar = new Estado("Rio da Janeiro", "RJ");
        Aluno alunoParaAdicionar = new Aluno("Daniel", 29, estadoParaAdicionar);


        // 2.2 - Iniciar uma transacao para adiconar as instancias no banco de dados

        entityManager.getTransaction().begin();

        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(alunoParaAdicionar);

        entityManager.getTransaction().commit();


        // Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();

    }
}
