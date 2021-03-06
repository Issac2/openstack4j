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
package org.openstack4j.model.network.ext;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.network.ext.builder.VipUpdateBuilder;

/**
 * An entity used to update a vip
 * 
 * @author liujunpeng
 */
public interface VipUpdate extends ModelEntity, Buildable<VipUpdateBuilder> {
	/**
	 * Optional
	 * 
	 * @see Vip#isAdminStateUp()
	 */
	public boolean isAdminStateUp();

	/**
	 * Optional
	 * 
	 * @see Vip#getConnectionLimit()
	 */
	public Integer getConnectionLimit();

	/**
	 * Optional
	 * 
	 * @see Vip#getDescription()
	 */
	public String getDescription();

	/**
	 * Optional
	 * 
	 * @see Vip#getName()
	 */
	public String getName();

	/**
	 * Optional
	 * 
	 * @see Vip#getPoolId()
	 */
	public String getPoolId();

	/**
	 * Optional
	 * 
	 * @see Vip#getSessionPersistence()
	 */
	public SessionPersistence getSessionPersistence();

}
