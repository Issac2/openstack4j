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
package org.openstack4j.api.telemetry;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.openstack4j.api.AbstractTest;
import org.openstack4j.model.telemetry.MeterSample;
import org.testng.annotations.Test;

@Test(suiteName = "Meter Sample Tests")
public class MeterSampleTests extends AbstractTest {

    private static final String JSON_METER_SAMPLES = "/telemetry/metersamples.json";

    @Override
    protected Service service() {
        return Service.TELEMETRY;
    }

    @Test
    public void listMeterSampleTest() throws IOException {
        respondWith(JSON_METER_SAMPLES);

        List<? extends MeterSample> samples = osv3().telemetry().meters().samples("cpu");
        assertEquals(samples.size(), 3);

        MeterSample sample = samples.get(0);
        assertEquals(sample.getCounterName(), "cpu");
        assertNotNull(sample.getMetadata());
        assertEquals(sample.getMetadata().size(), 26);

    }

}
