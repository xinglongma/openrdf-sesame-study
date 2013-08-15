import nu.xom.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: xma
 * Date: 15/08/13
 * Time: 10:59
 * To change this template use File | Settings | File Templates.
 */
public class NodeLister {

    public static void listChildren(Node current, int depth){
        printSpaces(depth);
        String data="";
        if (current instanceof Element){
            Element temp=(Element) current;
            data=": "+ temp.getQualifiedName();
        }
        else if(current instanceof ProcessingInstruction)  {
            ProcessingInstruction temp=(ProcessingInstruction) current;
            data=": "+ temp.getTarget();
        }
        else if(current instanceof DocType){
            DocType temp=(DocType) current;
            data=": "+temp.getRootElementName();
        }
        else if(current instanceof Text||current instanceof Comment) {
            String value=current.getValue();
            value=value.replace('\n',' ').trim();
            if(value.length()<=20)
                data=": "+value;
            else data=": "+current.getValue().substring(0, 17) +"....";
        }
        System.out.println(current.getClass().getName()+data);
        for(int i=0; i<current.getChildCount(); i++) {
            listChildren(current.getChild(i), depth+1);
        }
    }

    public static void printSpaces (int n){
        for (int i=0; i<n; i++){
            System.out.print("***"+i+"***");
        }
    }

    public static void main(String [] args){
        /**if(args.length==0){
            System.out.println("Usage: java nu.xom.samples.NodeLister URL");
            return;
        }
         **/
        Builder builder=new Builder();
        try{
            Document doc=builder.build("http://www.cafeconleche.org");
            Element root=doc.getRootElement();
            listChildren(root, 0);
        }
        catch (ParsingException ex){
            System.out.println(args[0]+"is not well-formed.");
            System.out.println(ex.getMessage());
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }
}
