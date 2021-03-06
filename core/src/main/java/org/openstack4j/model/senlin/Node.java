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
package org.openstack4j.model.senlin;

import org.openstack4j.model.ResourceEntity;

import java.util.Date;
import java.util.Map;

/**
 * This interface describes the getter-methods (and thus components) of a Node.
 * All getters map to the possible return values of
 * <code> GET /v1/nodes/​{node_id}​</code>
 * 
 * @see http://developer.openstack.org/api-ref-clustering-v1.html
 * 
 * @author lion
 * 
 */
public interface Node extends ResourceEntity {

    /**
     * Returns the cluster id of the Event
     *
     * @return the cluster id of the Event
     */
    String getClusterID();

    /**
     * Returns the created at time of the Event
     *
     * @return the created at time of the Event
     */
    Date getCreatedAt();

    /**
     * Returns the domain of the Event
     *
     * @return the domain of the Event
     */
    String getDomain();

    /**
     * Returns the index of the Event
     *
     * @return the index of the Event
     */
    Integer getIndex();

    /**
     * Returns the data of the Event
     *
     * @return the data of the Event
     */
    Map<String, Object> getData();

    /**
     * Returns the details of the Event
     *
     * @return the details of the Event
     */
    Map<String, Object> getDetails();

    /**
     * Returns the init at time of the Event
     *
     * @return the init at time of the Event
     */
    Date getInitAt();

    /**
     * Returns the metadata of the Event
     *
     * @return the metadata of the Event
     */
    Map<String, Object> getMetadata();

    /**
     * Returns the physical id of the Event
     *
     * @return the physical id of the Event
     */
    String getPhysicalID();

    /**
     * Returns the profile id of the Event
     *
     * @return the profile id of the Event
     */
    String getProfileID();

    /**
     * Returns the profile name of the Event
     *
     * @return the profile name of the Event
     */
    String getProfileName();

    /**
     * Returns the project of the Event
     *
     * @return the project of the Event
     */
    String getProject();

    /**
     * Returns the role of the Event
     *
     * @return the role of the Event
     */
    String getRole();

    /**
     * Returns the status of the Event
     *
     * @return the status of the Event
     */
    String getStatus();

    /**
     * Returns the status reason of the Event
     *
     * @return the status reason of the Event
     */
    String getStatusReason();

    /**
     * Returns the updated at time of the Event
     *
     * @return the updated at time of the Event
     */
    Date getUpdatedAt();

    /**
     * Returns the user of the Event
     *
     * @return the user of the Event
     */
    String getUser();
}
