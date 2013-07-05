import org.junit.Test;
import org.openrdf.OpenRDFException;
import org.openrdf.model.Value;
import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.rio.RDFFormat;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: xma
 * Date: 04/07/13
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 */
public class ImportN3Test {
    @Test
    public void testN3 (){
         Repository repo=new CreateRepository1().createMemoryRepository();

        File file=new File("../resource/data/sample.n3");
        String baseURI="http://example.org/example/local";
        try {


            RepositoryConnection con =repo.getConnection();
            try{
                con.add(file, baseURI, RDFFormat.N3);
                String queryString="SELECT ?x ?y WHERE {?x ?p ?y}";
                TupleQuery tupleQuery=con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
                TupleQueryResult result=tupleQuery.evaluate();
                try{
                    BindingSet bindingSet= result.next();
                    Value valueOfX=bindingSet.getValue("x");
                    Value valueOfY=bindingSet.getValue("y");
                }
                finally {
                            result.close();
                }


            }
            finally{
                con.close();
            }
        }

        catch (OpenRDFException e){
            //handle exception
        }
        catch (IOException e){
            //handle io exception
        }
    }
}