/*******************************************************************************
 * 	Copyright 2016 ContainX and OpenStack4j                                          
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package org.openstack4j.connectors.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.openstack4j.api.exceptions.ConnectionException;
import org.openstack4j.api.exceptions.ResponseException;
import org.openstack4j.core.transport.ClientConstants;
import org.openstack4j.core.transport.HttpExecutorService;
import org.openstack4j.core.transport.HttpRequest;
import org.openstack4j.core.transport.HttpResponse;
import org.openstack4j.openstack.internal.OSAuthenticator;
import org.openstack4j.openstack.internal.OSClientSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpExecutor is the default implementation for HttpExecutorService which is responsible for interfacing with HttpClient and mapping common status codes, requests and responses
 * back to the common API
 *
 * @author Jeremy Unruh
 */
public class HttpExecutorServiceImpl implements HttpExecutorService {

    private static final String NAME = "Apache HttpClient Connector";
    private static final Logger LOG = LoggerFactory.getLogger(HttpExecutorServiceImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> HttpResponse execute(HttpRequest<R> request) {
        try {
            return invoke(request);
        }
        catch (ResponseException re) {
            throw re;
        }
        catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * Invokes the given request
     *
     * @param <R> the return type
     * @param request the request to invoke
     * @return the response
     * @throws Exception the exception
     */
    private <R> HttpResponse invoke(HttpRequest<R> request) throws Exception {

        HttpCommand<R> command = HttpCommand.create(request);

        try {
            return invokeRequest(command);
        } catch (ResponseException re) {
        	throw re;
        } catch (Exception pe) {
            throw new ConnectionException(pe.getMessage(), 0, pe);
        }
    }

    private <R> HttpResponse invokeRequest(HttpCommand<R> command) throws Exception {
        CloseableHttpResponse response = command.execute();

        if (command.getRetries() == 0 && response.getStatusLine().getStatusCode() == 401 && !command.getRequest().getHeaders().containsKey(ClientConstants.HEADER_OS4J_AUTH))
        {
            try
            {
                OSAuthenticator.reAuthenticate();
                command.getRequest().getHeaders().put(ClientConstants.HEADER_X_AUTH_TOKEN, OSClientSession.getCurrent().getTokenId());
                return invokeRequest(command.incrementRetriesAndReturn());
            } finally {
                response.close();
            }
        }

        return HttpResponseImpl.wrap(response);
    }

    @Override
    public String getExecutorDisplayName() {
        return NAME;
    }
}
