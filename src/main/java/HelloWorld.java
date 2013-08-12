import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: xma
 * Date: 12/08/13
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld {
    public static void main(String[] args) {

        /** a simple example including one root "Hello world!"
         Element root=new Element("root");
         //root.appendChild("Hello World!");
         root.appendChild("\n Hello World! \n"); //break line and indentation
         Document doc=new Document(root);
         System.out.println(doc.toXML());

         **/
        //another example with more elements.
        Element root = new Element("Fibonacci_Numbers");
        Integer num1 = new Integer(0);
        Integer num2 = new Integer(0);
        for (int i = 0; i <= 10; i++) {
            Element fibonacci = new Element("Fibonacci");
            fibonacci.appendChild(num2.toString());
            root.appendChild(fibonacci);
            if (num2.intValue() == 0) {
                num1 = Integer.valueOf(num2.intValue() + 1);
            }
            Integer tran = num2;
            num2 = Integer.valueOf(num1.intValue() + num2.intValue());
            num1 = tran;
        }
        Document doc = new Document(root);
        try {
            Serializer serializer = new Serializer(System.out, "ISO-8859-1");
            serializer.setIndent(4);
            serializer.setMaxLength(64);
            serializer.write(doc);
        } catch (IOException ex) {
            System.out.println(ex);

        }
    }
}