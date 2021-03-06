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
package org.openstack4j.api.scaling;

import java.util.List;

import org.openstack4j.common.RestService;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.scaling.ScalingPolicy;
import org.openstack4j.model.scaling.ScalingPolicyCreateUpdate;
import org.openstack4j.openstack.scaling.options.ScalingPolicyListOptions;

public interface AutoScalingPolicyService extends RestService {

	public ScalingPolicyCreateUpdate create(ScalingPolicyCreateUpdate policy);

	public ScalingPolicyCreateUpdate update(ScalingPolicyCreateUpdate policy);

	public List<? extends ScalingPolicy> list(String groupId);

	public List<? extends ScalingPolicy> list(String groupId, ScalingPolicyListOptions options);

	public ScalingPolicy get(String policyId);

	public ActionResponse execute(String policyId);

	public ActionResponse resume(String policyId);

	public ActionResponse pause(String policyId);

	public ActionResponse delete(String policyId);
}
