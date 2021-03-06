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
package org.openstack4j.model.storage.block;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;

import org.openstack4j.model.ModelEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.CaseFormat;

public interface VolumeBackup   extends ModelEntity {
	
	/**
	 * The volume backup Status
	 *
	 */
		
	public enum Status {
		AVAILABLE,  CREATING, DELETING,   ERROR,  ERROR_RESTORING,  RESTORING , UNRECOGNIZED;

		@JsonValue
		public String value() {
			return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, name());
		}

		@Override
		public String toString() {
			return value();
		}

		@JsonCreator
		public static Status fromValue(String status) {
			try {
				return valueOf(CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_UNDERSCORE, checkNotNull(status, "status")));
			} catch (IllegalArgumentException e) {
				return UNRECOGNIZED;
			}
		}
	}
	
	String getId();
	
	/**
	 * @return the name of the Volume Transfer.
	 */
	String getName();
	
	/**
	 * @return the description of the volume backup
	 */
	String getDescription();
	
	/**
	 * @return The UUID of the volume.
	 */
	String getVolumeId();
	
	/**
	 * @return The container name or null.
	 */
	String getContainer();
	
	
	/**
	 * @return The backup mode. A valid value is true for incremental backup mode or false for full backup mode
	 */
	Boolean isIncremental();
	
	/**
	 * @return the zone of availability to use
	 */
	String getZone();
	
	/**
	 * @return the status of the volume
	 */
	Status getStatus();
	
	
	/**
	 * @return The size of the volume, in gibibytes (GiB).
	 */
	int getSize();
	
	/**
	 * @return the created date of the volume
	 */
	Date getCreated();
	
	/**
	 * @return If the backup failed, the reason for the failure. Otherwise, null.
	 */
	String getFailReason();
	
	/**
	 * @return The number of objects in the backup.
	 */
	int getObjectCount();
	
	/**
	 * 
	 * @return True if the backup depends on other backups.
	 */
	Boolean hasDependent();

	/**
	 * @return If the backup was created from snapshot, the snapshot id. Otherwise, null.
	 */
	String getSnapshotId();

}
