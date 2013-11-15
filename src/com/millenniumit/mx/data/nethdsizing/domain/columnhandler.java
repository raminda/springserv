package com.millenniumit.mx.data.nethdsizing.domain;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


	/**
	 * @author DECANS <draminda@gmail.com>
	 * @category for Audit the data read write operations  
	 */

	@MappedSuperclass
	public class columnhandler {
		
		@Id
		@GeneratedValue
		private String  IdColumn;
		private int  sequence_next_hi_value;
		
		/**
		 * @param Calendar_modified the Calendar_modified to set
		 */
		
		public void setIdColumn(String IdColumn) {
			this.IdColumn = IdColumn;
		}
		/**
		 * @return the Calendar_created
		 */
		public String getIdColumn() {
			return IdColumn;
		}
		/**
		 * @param Calendar_created the Calendar_created to set
		 */
		public void setsequence_next_hi_value(int sequence_next_hi_value) {
			this.sequence_next_hi_value = sequence_next_hi_value;
		}
		/**
		 * @return the Calendar_logged
		 */
		public int getsequence_next_hi_value() {
			return sequence_next_hi_value;
		}
	}

