import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.sail.memory.MemoryStore;

/**
 * Created with IntelliJ IDEA.
 * User: xma
 * Date: 05/07/13
 * Time: 11:30
 * To change this template use File | Settings | File Templates.
 */
public class SesameRepository {
   public Repository createMemoryRepository(){
        Repository repo=new SailRepository(new MemoryStore());
        try {
            repo.initialize();
        }
        catch (RepositoryException e){
            System.out.println("***************fail to create a new memory repository***************");
            e.printStackTrace();
        }
         return (repo);
    }
}
