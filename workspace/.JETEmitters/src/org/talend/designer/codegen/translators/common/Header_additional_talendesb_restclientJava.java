package org.talend.designer.codegen.translators.common;

import java.util.Vector;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IProcess;

public class Header_additional_talendesb_restclientJava
{
  protected static String nl;
  public static synchronized Header_additional_talendesb_restclientJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Header_additional_talendesb_restclientJava result = new Header_additional_talendesb_restclientJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/**" + NL + " * A special Dom4J provider implementation to help conversion in JAX-RS" + NL + " * @see http://jira.talendforge.org/browse/TESB-3329" + NL + " * TODO: replace with org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider once CXF version gets updated to 2.6.2" + NL + " */" + NL + "@javax.ws.rs.Produces({\"application/xml\", \"text/xml\", \"application/json\"})" + NL + "@javax.ws.rs.Consumes({\"application/xml\", \"text/xml\", \"application/json\"})" + NL + "public static class ClientDOM4JProvider" + NL + "\t\timplements javax.ws.rs.ext.MessageBodyReader<org.dom4j.Document>," + NL + "\t\t\tjavax.ws.rs.ext.MessageBodyWriter<org.dom4j.Document> {" + NL + "" + NL + "\tprivate static final Class<org.w3c.dom.Document> DOM_DOC_CLS = org.w3c.dom.Document.class;" + NL + "" + NL + "\tprivate javax.ws.rs.ext.Providers providers;" + NL + "" + NL + "\t@javax.ws.rs.core.Context" + NL + "\tpublic void setProviders(javax.ws.rs.ext.Providers providers) {" + NL + "\t\tthis.providers = providers;" + NL + "\t}" + NL + "" + NL + "\tpublic boolean isReadable(Class<?> cls, java.lang.reflect.Type type," + NL + "\t\t\tjava.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt) {" + NL + "\t\treturn org.dom4j.Document.class.isAssignableFrom(cls);" + NL + "\t}" + NL + "" + NL + "\tpublic org.dom4j.Document readFrom(Class<org.dom4j.Document> cls, java.lang.reflect.Type type," + NL + "\t\t\tjava.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt," + NL + "\t\t\tjavax.ws.rs.core.MultivaluedMap<String, String> headers, java.io.InputStream is)" + NL + "\t\t\tthrows IOException, javax.ws.rs.WebApplicationException {" + NL + "\t\tjavax.ws.rs.ext.MessageBodyReader<org.w3c.dom.Document> reader =" + NL + "\t\t\t\tproviders.getMessageBodyReader(DOM_DOC_CLS, DOM_DOC_CLS, anns, mt);" + NL + "\t\tif (reader == null) {" + NL + "\t\t\tthrow new javax.ws.rs.WebApplicationException(415);" + NL + "\t\t}" + NL + "\t\torg.w3c.dom.Document domDoc =" + NL + "\t\t\t\treader.readFrom(DOM_DOC_CLS, DOM_DOC_CLS, anns, mt, headers, is);" + NL + "\t\treturn new org.dom4j.io.DOMReader().read(domDoc);" + NL + "\t}" + NL + "" + NL + "\tpublic long getSize(org.dom4j.Document doc, Class<?> cls, java.lang.reflect.Type type," + NL + "\t\t\tjava.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\tpublic boolean isWriteable(Class<?> cls, java.lang.reflect.Type type," + NL + "\t\t\tjava.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt) {" + NL + "\t\treturn org.dom4j.Document.class.isAssignableFrom(cls);" + NL + "\t}" + NL + "" + NL + "\tpublic void writeTo(org.dom4j.Document doc,Class<?> cls, java.lang.reflect.Type type," + NL + "\t\t\tjava.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt," + NL + "\t\t\tjavax.ws.rs.core.MultivaluedMap<String, Object> headers, java.io.OutputStream os)" + NL + "\t\t\tthrows IOException, javax.ws.rs.WebApplicationException {" + NL + "\t\tif (mt.getSubtype().contains(\"xml\")) {" + NL + "\t\t\torg.dom4j.io.XMLWriter writer = new org.dom4j.io.XMLWriter(os);" + NL + "\t\t\twriter.write(doc);" + NL + "\t\t\twriter.flush();" + NL + "\t\t} else {" + NL + "\t\t\torg.w3c.dom.Document domDoc = convertToDOM(doc);" + NL + "" + NL + "\t\t\tjavax.ws.rs.ext.MessageBodyWriter<org.w3c.dom.Document> writer =" + NL + "\t\t\t\t\tproviders.getMessageBodyWriter(DOM_DOC_CLS, DOM_DOC_CLS, anns, mt);" + NL + "\t\t\tif (writer == null) {" + NL + "\t\t\t\tthrow new javax.ws.rs.WebApplicationException(406);" + NL + "\t\t\t}" + NL + "\t\t\twriter.writeTo(domDoc, DOM_DOC_CLS, DOM_DOC_CLS, anns, mt, headers, os);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\tprivate org.w3c.dom.Document convertToDOM(org.dom4j.Document doc) {" + NL + "\t\tString xml = doc.asXML();" + NL + "\t\ttry {" + NL + "\t\t\treturn org.apache.cxf.helpers.DOMUtils.readXml(new java.io.StringReader(xml));" + NL + "\t\t} catch (Exception ex) {" + NL + "\t\t\tthrow new javax.ws.rs.WebApplicationException(ex);" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
Vector v = (Vector) codeGenArgument.getArgument();
IProcess process = (IProcess) v.get(0);

boolean jobHasRestConsumerComponent = !process.getNodesOfType("tRESTClient").isEmpty();

if (jobHasRestConsumerComponent) { 
    stringBuffer.append(TEXT_1);
     } 
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
