/*******************************************************************************
 * 	Copyright 2017 HuaWei Tld                                     
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
package org.openstack4j.model.loadbalance;

import java.util.Date;

import org.openstack4j.model.ModelEntity;

public interface Listener extends ModelEntity {

	/**
	 * @return listener id
	 */
	String getId();
	
	/**
	 * @return listener name
	 */
	String getName();
	
	/**
	 * @return listener description
	 */
	String getDescription();
	
	/**
	 * @return load balancer id
	 */
	String getLoadBalancerId();
	
	/**
	 * @return listener protocol
	 */
	String getProtocol();
	
	/**
	 * @return listen port
	 */
	Integer getPort();
	
	/**
	 * @return backend protocol of listener
	 */
	String getBackendProtocol();
	
	/**
	 * @return backend listen port
	 */
	Integer getBackendPort();
	
	/**
	 * @return algorithm of load balancer
	 */
	String getLbAlgorithm();

	/**
	 * @return whether session sticky
	 */
	Boolean getSessionSticky();
	
	/**
	 * @return session sticky type
	 */
	String getStickySessionType();
	
	/**
	 * @return cookie timeout
	 */
	Integer getCookieTimeout();

	/**
	 * @return certificate id
	 */
	String getCertificateId();
	
	/**
	 * @return status of listener
	 */
	String getStatus();
	
	/**
	 * @return whether administration state up
	 */
	Boolean getAdminStateUp();
	
	/**
	 * @return health check id
	 */
	String getHealthCheckId();
	
	/**
	 * @return whether tcp draining
	 */
	Boolean getTcpDraining();
	
	/**
	 * @return tcp draining timeout
	 */
	Integer getTcpDrainingTimeout();
	
	/**
	 * @return create time
	 */
	Date getCreateTime();
	
	/**
	 * @return update time
	 */
	Date getUpdateTime();
	
}
