package com.millenniumit.mx.data.nethdsizing.domain;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;


	/**
	 * @author DECANS <draminda@gmail.com>
	 * @category for Audit the data read write operations  
	 */

	@MappedSuperclass
	public class AuditFields {
		
		private Date  Calendar_modified;
		@Temporal(TemporalType.DATE)
		private Date  Calendar_created;
		private Date  Calendar_logged;
		
		/**
		 * @return the Calendar_modified
		 */
		AuditFields(){
			Date dNow=new Date();
		    SimpleDateFormat ft =new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss");
			try {
				dNow=ft.parse(ft.format(dNow));
			} catch (ParseException e) {
				dNow=new Date();
			}
		    Calendar_modified= dNow;
			Calendar_created= dNow;
			Calendar_logged= dNow;
		}
		@Temporal(TemporalType.TIMESTAMP)
		public Date getCalendar_modified() {
			return Calendar_modified;
		}
		/**
		 * @param Calendar_modified the Calendar_modified to set
		 */
		
		public void setCalendar_modified(Date Calendar_modified) {
			this.Calendar_modified = Calendar_modified;
		}
		/**
		 * @return the Calendar_created
		 */
		public Date getCalendar_created() {
			return Calendar_created;
		}
		/**
		 * @param Calendar_created the Calendar_created to set
		 */
		public void setCalendar_created(Date Calendar_created) {
			this.Calendar_created = Calendar_created;
		}
		/**
		 * @return the Calendar_logged
		 */
		@Temporal(TemporalType.DATE)
		public Date getCalendar_logged() {
			return Calendar_logged;
		}
		/**
		 * @param Calendar_logged the Calendar_logged to set
		 */
		public void setCalendar_logged(Date Calendar_logged) {
			this.Calendar_logged = Calendar_logged;
		}
		
		
  
	}

