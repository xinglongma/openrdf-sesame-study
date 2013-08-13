import nu.xom.*;
import org.json.*;

import java.io.*;
import java.net.*;


/**
 * Created with IntelliJ IDEA.
 * User: xma
 * Date: 01/08/13
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class MyURLConnection {



    public static void main (String [] args)throws Exception{
        String query="PREFIX id: <http://dblp.rkbexplorer.com/id/> PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX akt: <http://www.aktors.org/ontology/portal#> PREFIX owl: <http://www.w3.org/2002/07/owl#> PREFIX akt: <http://www.aktors.org/ontology/portal#> PREFIX akts: <http://www.aktors.org/ontology/support#> SELECT * WHERE { ?s rdfs:label ?o } LIMIT 10";
        query=URLEncoder.encode(query, "UTF-8");
        URL url =new URL("http://dblp.rkbexplorer.com/sparql/?query="+query+"&output=xml");
       // URL url=new URL ("http://data.open.ac.uk/openlearn/ontology/OpenLearnUnit");
       // URL url=new URL("http://www.w3.org/2006/03/wn/wn20/instances/index.rdf");
        URLConnection urlcon = url.openConnection();
        BufferedReader in=new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

        String inputLine;
        while ((inputLine=in.readLine())!= null)
            System.out.println(inputLine);

        try{
        Builder builder = new Builder();
       // for (String line = null; (line = in.readLine()) != null;) {
         //   builder.append(line).append("&#92n");
       // }

        Document doc=builder.build(in);
        //JSONTokener tokener = new JSONTokener(builder.toString());
       // JSONArray finalResult = new JSONArray(tokener);

        }catch (ParsingException ex){
            System.err.println("catched the parsingexception");
        }
        catch (IOException ex){
            System.err.println("can't connect the file");
        }
        in.close();
    }
}
