/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.hhs.fha.nhinc.lift.proxy;

import gov.hhs.fha.nhinc.properties.PropertyAccessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * This class is used to create an instance of the GatewayLiftManager.
 *
 * @author Les Westberg
 */
public class GatewayLiftManagerProxyObjectFactory
{
    private static final String CONFIG_FILE_NAME = "GatewayLiftManagerProxyConfig.xml";
    private static final String BEAN_NAME_GATEWAY_LIFT_MANAGER = "gatewayliftmanager";
    private static ApplicationContext context = null;

    public GatewayLiftManagerProxyObjectFactory()
    {
        if(context == null)
        {
            context = createApplicationContext();
        }
    }

    protected ApplicationContext createApplicationContext()
    {
        return new FileSystemXmlApplicationContext(PropertyAccessor.getPropertyFileLocation() + CONFIG_FILE_NAME);
    }

    public GatewayLiftManagerProxy getGatewayLiftManagerProxy()
    {
        GatewayLiftManagerProxy gatewayLiftManagerProxy = null;
        ApplicationContext workingContext = getContext();
        if (workingContext != null)
        {
            gatewayLiftManagerProxy = (GatewayLiftManagerProxy) workingContext.getBean(BEAN_NAME_GATEWAY_LIFT_MANAGER);
        }
        return gatewayLiftManagerProxy;
    }

    protected ApplicationContext getContext()
    {
        return context;
    }

}