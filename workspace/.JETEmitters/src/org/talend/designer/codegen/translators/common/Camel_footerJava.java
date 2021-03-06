package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Vector;
import java.util.List;
import java.util.Map;

public class Camel_footerJava
{
  protected static String nl;
  public static synchronized Camel_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Camel_footerJava result = new Camel_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tgetCamelContexts().get(0).addRoutes(routeBuilder);" + NL + "\t\t}\t" + NL + "\t\t" + NL + "" + NL + "\t\tprotected void doStop() throws Exception {" + NL + "\t\t\tsuper.doStop();" + NL + "\t\t\tgetCamelContexts().get(0).stop();" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected org.apache.camel.ProducerTemplate findOrCreateCamelTemplate() {" + NL + "\t\t\treturn getCamelContexts().get(0).createProducerTemplate();" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected java.util.Map<String, org.apache.camel.CamelContext> getCamelContextMap() {" + NL + "\t\t\tjava.util.Map<String, org.apache.camel.CamelContext> answer = new java.util.HashMap<String, org.apache.camel.CamelContext>();" + NL + "\t\t\torg.apache.camel.impl.DefaultCamelContext camelContext;" + NL + "\t\t\torg.apache.camel.spi.TypeConverterRegistry typeConverterRegistry;";
  protected final String TEXT_2 = NL + "\t\t\t\tif (bundleContext != null) {" + NL + "\t\t\t\t\torg.apache.camel.osgi.CamelContextFactory factory = new org.apache.camel.osgi.CamelContextFactory();" + NL + "\t\t\t\t\tfactory.setBundleContext(bundleContext);" + NL + "\t\t\t\t\tcamelContext = factory.createContext();" + NL + "\t\t\t\t\tbundleContext.registerService(org.apache.camel.CamelContext.class.getName(), camelContext, null);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tcamelContext = new org.apache.camel.impl.DefaultCamelContext();" + NL + "\t\t\t\t}";
  protected final String TEXT_3 = NL + "\t\t\t\tcamelContext = new org.apache.camel.impl.DefaultCamelContext();";
  protected final String TEXT_4 = NL + "\t\t\tTalendRouteRegistry contextRegister = new TalendRouteRegistry(camelContext.getRegistry());" + NL + "\t\t\tcamelContext.setRegistry(contextRegister);" + NL + "\t\t\ttypeConverterRegistry = camelContext.getTypeConverterRegistry();";
  protected final String TEXT_5 = NL + "\t\t\t\tObject beanInstance = null;";
  protected final String TEXT_6 = NL + "\t\t\t\t\tcontextRegister.register(";
  protected final String TEXT_7 = ", new ";
  protected final String TEXT_8 = "(";
  protected final String TEXT_9 = "));";
  protected final String TEXT_10 = NL + "\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\tif(beanInstance != null){" + NL + "\t\t\t\t\t\tcontextRegister.register(";
  protected final String TEXT_12 = ", beanInstance);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_13 = NL + "\t\t\t\tjavax.jms.ConnectionFactory jmsConnectionFactory = null;";
  protected final String TEXT_14 = NL + "\t\t\t\tjmsConnectionFactory = new org.apache.activemq.ActiveMQConnectionFactory(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\t\t\t\torg.apache.activemq.pool.PooledConnectionFactory pooledConnectionFactory_";
  protected final String TEXT_17 = " " + NL + "\t\t\t\t\t= new org.apache.activemq.pool.PooledConnectionFactory();" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_18 = ".setConnectionFactory(jmsConnectionFactory);" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_19 = ".setExpiryTimeout(";
  protected final String TEXT_20 = "L);" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_21 = ".setIdleTimeout(";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_23 = ".setMaxConnections(";
  protected final String TEXT_24 = ");" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_25 = ".setMaximumActive(";
  protected final String TEXT_26 = ");" + NL + "\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_27 = "," + NL + "\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_28 = "(pooledConnectionFactory_";
  protected final String TEXT_29 = "));\t";
  protected final String TEXT_30 = "\t\t\t\t" + NL + "\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_31 = "," + NL + "\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_32 = "(jmsConnectionFactory));";
  protected final String TEXT_33 = NL + "\t\t\t\t\tjmsConnectionFactory = new com.ibm.mq.jms.MQQueueConnectionFactory();" + NL + "\t       \t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setHostName(";
  protected final String TEXT_34 = ");" + NL + "\t       \t\t\ttry {" + NL + "\t       \t\t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setPort(";
  protected final String TEXT_35 = ");" + NL + "\t       \t\t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setTransportType(";
  protected final String TEXT_36 = ");" + NL + "\t       \t\t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setQueueManager(";
  protected final String TEXT_37 = ");\t" + NL + "\t       \t\t\t} catch (javax.jms.JMSException e) {" + NL + "\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t}";
  protected final String TEXT_38 = NL + "\t\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_39 = "," + NL + "\t\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_40 = "(jmsConnectionFactory));";
  protected final String TEXT_41 = NL + "\t\t\t\t\torg.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter connectionFactoryAdapter";
  protected final String TEXT_42 = " " + NL + "\t\t\t\t\t\t\t= new org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter();" + NL + "       \t\t\t\tconnectionFactoryAdapter";
  protected final String TEXT_43 = ".setUsername(";
  protected final String TEXT_44 = ");" + NL + "      \t\t\t\tconnectionFactoryAdapter";
  protected final String TEXT_45 = ".setPassword(";
  protected final String TEXT_46 = ");" + NL + "       \t\t\t\tconnectionFactoryAdapter";
  protected final String TEXT_47 = ".setTargetConnectionFactory(jmsConnectionFactory);" + NL + "       " + NL + "\t\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_48 = "," + NL + "\t\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_49 = "(connectionFactoryAdapter";
  protected final String TEXT_50 = "));";
  protected final String TEXT_51 = NL + "\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_53 = "," + NL + "\t\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_54 = "(jmsConnectionFactory));";
  protected final String TEXT_55 = NL + "\t\t\t    ";
  protected final String TEXT_56 = NL + "\t\t\t//using Route name as CamelContext ID" + NL + "\t\t\tanswer.put(\"";
  protected final String TEXT_57 = "\", camelContext);" + NL + "\t\t\tcamelContext.setName(\"";
  protected final String TEXT_58 = "\");" + NL + "\t\t\treturn answer;" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected org.apache.camel.view.ModelFileGenerator createModelFileGenerator()" + NL + "\t\t\t\tthrows javax.xml.bind.JAXBException {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tfinal CamelImpl camelImplementation = new CamelImpl();" + NL + "\tif(start){" + NL + "\t\tstopDelegate = new TalendESBRoute() {" + NL + "\t\t\t" + NL + "\t\t\tpublic int runJobInTOS(String[] args) {" + NL + "\t\t\t\treturn 0;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String[][] runJob(String[] args) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic void stop() throws Exception {" + NL + "\t\t\t\tcamelImplementation.stop();" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic void shutdown() throws Exception {" + NL + "\t\t\t\tcamelImplementation.shutdown();" + NL + "\t\t\t}" + NL + "\t\t};\t" + NL + "\t\tcamelImplementation.enableHangupSupport();" + NL + "\t\tcamelImplementation.run();" + NL + "\t}" + NL + "\treturn routeBuilder;" + NL + "\t" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	 Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess)v.get(0);
	
	boolean stats = codeGenArgument.isStatistics();

    stringBuffer.append(TEXT_1);
    
			boolean startable = false;
			for (INode node : (List< ? extends INode>)process.getGraphicalNodes()) {
				Object value = node.getPropertyValue("STARTABLE");
				startable = value == null? false:(Boolean)value;
				if(startable){
					break;
				}
			}
			
			if (startable) { 

    stringBuffer.append(TEXT_2);
    
			} else {

    stringBuffer.append(TEXT_3);
    
			}

    stringBuffer.append(TEXT_4);
    

			List<? extends INode> beanRegisterNodes = process.getNodesOfType("cBeanRegister");
			if(beanRegisterNodes != null && beanRegisterNodes.size()>0){

    stringBuffer.append(TEXT_5);
    			}
			for(INode node: beanRegisterNodes){
				String id = ElementParameterParser.getValue(node, "__ID__");
				String isSimple = ElementParameterParser.getValue(node, "__SIMPLE_CONFIG__");
				String classQualifiedName = ElementParameterParser.getValue(node, "__CLASS_QUALIFIED_NAME__");
				String hasArguments = ElementParameterParser.getValue(node, "__SPECIFY_ARGUMENTS__");
				List<Map<String, String>> arguments = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ARGUMENTS__");
				
				String code = ElementParameterParser.getValue(node, "__CODE__");
				
				if("true".equals(isSimple)){
					StringBuilder sb = new StringBuilder();
					for(Map<String, String> s: arguments){
						if(sb.length() == 0){
							sb.append(s.get("VALUE"));
						}else{
							sb.append(",");
							sb.append(s.get("VALUE"));
						}
					}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(classQualifiedName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sb.toString());
    stringBuffer.append(TEXT_9);
    
				}else{

    stringBuffer.append(TEXT_10);
    stringBuffer.append(code);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_12);
    
				}
			}
            //cJMSConnectionFactory http://jira.talendforge.org/browse/TESB-4860
			List<? extends INode> jmsCFNodes = process.getNodesOfType("cJMSConnectionFactory");
			if(jmsCFNodes.size()>0){

    stringBuffer.append(TEXT_13);
    			}
			for(INode node: jmsCFNodes){
				//Use transaction http://jira.talendforge.org/browse/TESB-5160 By LiXiaopeng
				String useTransaction = ElementParameterParser.getValue(node, "__USE_TRANSACTION__");
				String transactedMethodStr = "";
				if("true".equals(useTransaction)){
					transactedMethodStr = "Transacted";
				}
			
				//Component Name
				String name = node.getUniqueName().replace("_", "");
				name = "\"" + name + "\"";
				    // ElementParameterParser.getValue(node, "__NAME__").trim();
    				//Remove unnecessary subfix
    				//name += "+";
    				//name += ElementParameterParser.getValue(node, "__SUBFIX__").trim();
			
				//ActiveMQ
				String mqType = ElementParameterParser.getValue(node, "__MQ_TYPE__");
				if("ActiveMQ".equals(mqType)){
					String amqUri = ElementParameterParser.getValue(node, "__AMQ_BROKER_URI__").trim();
					

    stringBuffer.append(TEXT_14);
    stringBuffer.append(amqUri);
    stringBuffer.append(TEXT_15);
    
				String amqPool = ElementParameterParser.getValue(node, "__AMQ_POOL__").trim();
				if("true".equals(amqPool)){
				     String amq_pool_max_connections = ElementParameterParser.getValue(node, "__AMQ_POOL_MAX_CONNECTIONS__").trim();
				     String amq_pool_max_active = ElementParameterParser.getValue(node, "__AMQ_POOL_MAX_ACTIVE__").trim();
				     String amq_pool_idle_timeout = ElementParameterParser.getValue(node, "__AMQ_POOL_IDLE_TIMEOUT__").trim();
				     String amq_pool_expiry_timeout = ElementParameterParser.getValue(node, "__AMQ_POOL_EXPIRY_TIMEOUT__").trim();
				     
				     if(amq_pool_max_connections.startsWith("\"")){
						 amq_pool_max_connections = amq_pool_max_connections.substring(1);
					 }
					 if(amq_pool_max_connections.endsWith("\"")){
						 amq_pool_max_connections = amq_pool_max_connections.substring(0, amq_pool_max_connections.length() - 1);
					 }
				     if(amq_pool_max_active.startsWith("\"")){
						 amq_pool_max_active = amq_pool_max_active.substring(1);
					 }
					 if(amq_pool_max_active.endsWith("\"")){
						 amq_pool_max_active = amq_pool_max_active.substring(0, amq_pool_max_active.length() - 1);
					 }
				     if(amq_pool_idle_timeout.startsWith("\"")){
						 amq_pool_idle_timeout = amq_pool_idle_timeout.substring(1);
					 }
					 if(amq_pool_idle_timeout.endsWith("\"")){
						 amq_pool_idle_timeout = amq_pool_idle_timeout.substring(0, amq_pool_idle_timeout.length() - 1);
					 }
				     if(amq_pool_expiry_timeout.startsWith("\"")){
						 amq_pool_expiry_timeout = amq_pool_expiry_timeout.substring(1);
					 }
					 if(amq_pool_expiry_timeout.endsWith("\"")){
						 amq_pool_expiry_timeout = amq_pool_expiry_timeout.substring(0, amq_pool_expiry_timeout.length() - 1);
					 }

    stringBuffer.append(TEXT_16);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(amq_pool_expiry_timeout);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(amq_pool_idle_timeout);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(amq_pool_max_connections);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(amq_pool_max_active);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_29);
    
					 
				}else{

    stringBuffer.append(TEXT_30);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_32);
    				
				    }
				}else if("WebSphere MQ".equals(mqType)){
					String wmqServer = ElementParameterParser.getValue(node, "__WQM_SEVER__");
					String wmqPort = ElementParameterParser.getValue(node, "__WMQ_PORT__");
					String wmqTransportType = ElementParameterParser.getValue(node, "__WMQ_TRANSPORT_TYPE__");
					String wmqUM = ElementParameterParser.getValue(node, "__WMQ_QUEUE_MANAGER__");
					
					//Username and password, http://jira.talendforge.org/browse/TESB-4073
					String username = ElementParameterParser.getValue(node, "__WMQ_USERNAME__");
					String password = ElementParameterParser.getValue(node, "__WMQ_PASSWORD__");
					String useAuth = ElementParameterParser.getValue(node, "__WMQ_AUTH__");
					
					if(wmqPort.startsWith("\"")){
						wmqPort = wmqPort.substring(1);
					}
					if(wmqPort.endsWith("\"")){
						wmqPort = wmqPort.substring(0, wmqPort.length() - 1);
					}
					if(wmqTransportType.startsWith("\"")){
						wmqTransportType = wmqTransportType.substring(1);
					}
					if(wmqTransportType.endsWith("\"")){
						wmqTransportType = wmqTransportType.substring(0, wmqTransportType.length() - 1);
					}
					

    stringBuffer.append(TEXT_33);
    stringBuffer.append(wmqServer);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(wmqPort);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(wmqTransportType);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(wmqUM);
    stringBuffer.append(TEXT_37);
    
					if("false".equals(useAuth)){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_40);
    					
					}else{

    stringBuffer.append(TEXT_41);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_50);
    						
					}					
					
				}else if("Other".equals(mqType)){

    stringBuffer.append(TEXT_51);
    stringBuffer.append(ElementParameterParser.getValue(node, "__OTHER_CODE__"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_54);
    
				}
			
			}
			//cConfig 
			List<? extends INode> camelContextNodes = process.getNodesOfType("cConfig");
			for(INode node: camelContextNodes){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CODE__"));
    
			} 
			//http://jira.talendforge.org/browse/TESB-4087: Change CamelContext name

    stringBuffer.append(TEXT_56);
    stringBuffer.append(process.getName() + "-ctx");
    stringBuffer.append(TEXT_57);
    stringBuffer.append(process.getName() + "-ctx");
    stringBuffer.append(TEXT_58);
    return stringBuffer.toString();
  }
}
