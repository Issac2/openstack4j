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
package org.openstack4j.openstack.loadbalance.internal;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;

import org.openstack4j.api.loadbalance.ELBListenerService;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.loadbalance.Listener;
import org.openstack4j.model.loadbalance.ListenerCreate;
import org.openstack4j.model.loadbalance.ListenerUpdate;
import org.openstack4j.model.loadbalance.ListenerUpdateResp;
import org.openstack4j.openstack.loadbalance.domain.ELBListener;
import org.openstack4j.openstack.loadbalance.domain.ELBListenerCreate;
import org.openstack4j.openstack.loadbalance.domain.ELBListenerUpdateResp;
import org.openstack4j.openstack.loadbalance.domain.ELBListener.ELBListeners;
import org.openstack4j.openstack.loadbalance.options.ELBListenerListOptions;

import com.google.common.base.Strings;

public class ELBListenerServiceImpl extends BaseELBServices implements ELBListenerService {
	private static final String API_PATH = "/elbaas/listeners";

	@Override
	public ListenerCreate create(ListenerCreate listener) {
		checkArgument(listener != null, "listener is required");
		checkArgument(!Strings.isNullOrEmpty(listener.getName()), "name is required");
		checkArgument(!Strings.isNullOrEmpty(listener.getLoadBalancerId()), "loadBalancerId is required");
		checkArgument(!Strings.isNullOrEmpty(listener.getProtocol()), "protocol is required");
		checkArgument(listener.getPort() != null, "port is required");
		checkArgument(!Strings.isNullOrEmpty(listener.getBackendProtocol()), "backendProtocol is required");
		checkArgument(listener.getBackendPort() != null, "backendPort is required");
		checkArgument(!Strings.isNullOrEmpty(listener.getLbAlgorithm()), "lbAlgorithm is required");

		return post(ELBListenerCreate.class, uri(API_PATH)).entity(listener).execute();
	}

	@Override
	public ActionResponse delete(String listenerId) {
		checkArgument(!Strings.isNullOrEmpty(listenerId), "listenerId is required");
		return deleteWithResponse(uri("%s/%s", API_PATH, listenerId)).execute();
	}

	@Override
	public ListenerUpdateResp update(String listenerId, ListenerUpdate listener) {
		checkArgument(!Strings.isNullOrEmpty(listenerId), "listenerId is required");
		checkArgument(listener != null, "listener is required");

		return put(ELBListenerUpdateResp.class, uri("%s/%s", API_PATH, listenerId)).entity(listener).execute();
	}

	@Override
	public Listener get(String listenerId) {
		checkArgument(!Strings.isNullOrEmpty(listenerId), "listenerId is required");
		return get(ELBListener.class, uri("%s/%s", API_PATH, listenerId)).execute();
	}

	@Override
	public List<? extends Listener> list() {
		return get(ELBListeners.class, uri(API_PATH)).execute().getList();
	}

	@Override
	public List<? extends Listener> list(ELBListenerListOptions options) {
		checkArgument(options != null, "options is required");
		return get(ELBListeners.class, uri(API_PATH)).params(options.getOptions()).execute().getList();
	}
}
