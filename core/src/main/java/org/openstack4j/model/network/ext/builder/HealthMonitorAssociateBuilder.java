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
package org.openstack4j.model.network.ext.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.network.ext.HealthMonitorAssociate;
/**
 * A builder to assiocate a healthmonitor with a lb pool
 * @author liujunpeng
 *
 */
public interface HealthMonitorAssociateBuilder extends Builder<HealthMonitorAssociateBuilder,HealthMonitorAssociate>{

	/**
	 * @param id the healthMonitor identifier
	 * @return HealthMonitorAssociateBuilder
	 */
	public HealthMonitorAssociateBuilder id(String id);
}
