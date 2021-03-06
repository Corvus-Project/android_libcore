
/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001-2003 World Wide Web Consortium,
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University).  All
Rights Reserved.  This program is distributed under the W3C's Software
Intellectual Property License.  This program is distributed in the
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE.

See W3C License http://www.w3.org/Consortium/Legal/ for more details.


*/

package tests.org.w3c.dom;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;

import javax.xml.parsers.DocumentBuilder;

/**
 *  The method getNamespaceURI returns the namespace URI of this node, or null if it is unspecified
 *  For nodes of any type other than ELEMENT_NODE and ATTRIBUTE_NODE and nodes created with
 *  a DOM Level 1 method, such as createElement from the Document interface, this is always null.
 *
 *  Ceate two new element nodes and atribute nodes, with and without namespace prefixes.
 *  Retreive their namespaceURI's using getNamespaceURI and verrify if it is correct.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSname">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSname</a>
* @see <a href="http://www.w3.org/Bugs/Public/show_bug.cgi?id=259">http://www.w3.org/Bugs/Public/show_bug.cgi?id=259</a>
*/
public final class NodeGetNamespaceURI extends DOMTestCase {

    DOMDocumentBuilderFactory factory;

    DocumentBuilder builder;

    protected void setUp() throws Exception {
        super.setUp();
        try {
            factory = new DOMDocumentBuilderFactory(DOMDocumentBuilderFactory
                    .getConfiguration1());
            builder = factory.getBuilder();
        } catch (Exception e) {
            fail("Unexpected exception" + e.getMessage());
        }
    }

    protected void tearDown() throws Exception {
        factory = null;
        builder = null;
        super.tearDown();
    }

   /**
    * Runs the test case.
    * @throws Throwable Any uncaught exception causes test to fail
    */
   public void testGetNamespaceURI() throws Throwable {
      Document doc;
      Element element;
      Element elementNS;
      Attr attr;
      Attr attrNS;
      String elemNSURI;
      String elemNSURINull;
      String attrNSURI;
      String attrNSURINull;
      String nullNS = null;

      doc = (Document) load("staff", builder);
      element = doc.createElementNS(nullNS, "elem");
      elementNS = doc.createElementNS("http://www.w3.org/DOM/Test/elem", "qual:qelem");
      attr = doc.createAttributeNS(nullNS, "attr");
      attrNS = doc.createAttributeNS("http://www.w3.org/DOM/Test/attr", "qual:qattr");
      elemNSURI = elementNS.getNamespaceURI();
      elemNSURINull = element.getNamespaceURI();
      attrNSURI = attrNS.getNamespaceURI();
      attrNSURINull = attr.getNamespaceURI();
      assertEquals("nodegetnamespaceuri03_elemNSURI", "http://www.w3.org/DOM/Test/elem", elemNSURI);
      assertNull("nodegetnamespaceuri03_1", elemNSURINull);
      assertEquals("nodegetnamespaceuri03_attrNSURI", "http://www.w3.org/DOM/Test/attr", attrNSURI);
      assertNull("nodegetnamespaceuri03_2", attrNSURINull);
      }

}

