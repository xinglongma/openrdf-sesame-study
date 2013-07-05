import org.junit.Test;
import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.rio.RDFFormat;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: xma
 * Date: 04/07/13
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 */
public class ImportN3Test {
    @Test
    public void testN3() throws Exception {
        Repository repo = new CreateRepository1().createMemoryRepository();

        URL url = Thread.currentThread().getContextClassLoader().getResource("data/sample.n3");
        File file = new File(url.getPath());
        String baseURI = "http://example.org/example/local";

        RepositoryConnection con = repo.getConnection();
        TupleQueryResult result = null;
        try {
            con.add(file, baseURI, RDFFormat.N3);
            String queryString = "SELECT ?x ?y WHERE {?x ?p ?y}";
            TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
            result = tupleQuery.evaluate();
            BindingSet bindingSet = result.next();
            String expectedX = "http://example.org/example/gedcom-relations.n3#Goedele";
            String expectedY = "http://example.org/example/gedcom-relations.n3#dt";
            assertEquals("The subject of the first record should be" + expectedX, expectedX, bindingSet.getValue("x").stringValue());
            assertEquals("The object of the first record should be" + expectedY, expectedY, bindingSet.getValue("y").stringValue());
        } finally {
            result.close();
            con.close();
        }
    }
}