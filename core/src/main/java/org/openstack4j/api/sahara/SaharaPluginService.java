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
package org.openstack4j.api.sahara;

import java.util.List;

import org.openstack4j.common.RestService;
import org.openstack4j.model.common.Payload;
import org.openstack4j.model.sahara.ClusterTemplate;
import org.openstack4j.model.sahara.Plugin;

/**
 * Sahara Data Processing Operations
 * 
 * @author ekasit.kijsipongse@nectec.or.th
 */
public interface SaharaPluginService extends RestService {

    /**
     * List all plugins
     * 
     * @return list of plugins registered in Sahara or empty
     */
     List<? extends Plugin> list();

    /**
     * Get a plugin by name
     * @param name the plugin name
     * @return the plugin or null if not found
     */
     Plugin get(String name);

    /**
     * Get a specific plugin with all details by name and version
     * @param name the plugin name
     * @param version the plugin version
     * @return the plugin or null if not found
     */
     Plugin get(String name, String version);

    /**
     * Convert plugin specific config file into cluster template
     * 
     * @param name the plugin name
     * @param version the plugin version
     * @param templateName the cluster template name
     * @param payload the config file for the specific plugin
     * @return the cluster template 
     */
     ClusterTemplate convertConfig(String name, String version, String templateName, Payload<?> payload);

}
