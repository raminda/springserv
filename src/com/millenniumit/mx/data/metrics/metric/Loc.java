package com.millenniumit.mx.data.metrics.metric;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.millenniumit.mx.data.relman.domain.RelmanCodeItemFile;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
@Entity(name = "Loc")
@Table(name = "metric_loc")
@PrimaryKeyJoinColumn(name="code_item_file_id")
public class Loc extends RelmanCodeItemFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="loccu_total_loc")
	private Long loccu_total_loc;
	
	@Column(name="loccu_source_loc")
	private Long loccu_source_loc;
	
	@Column(name="loccu_blank_loc")
	private Long loccu_blank_loc;
	
	@Column(name="loccu_comment_loc")
	private Long loccu_comment_loc;
	
	@Column(name="loccu_eff_comment_loc")
	private Long loccu_eff_comment_loc;
	
	@Column(name="date_created")
	private Date date_created;

	/**
	 * @return the loccu_total_loc
	 */
	public Long getLoccu_total_loc() {
		return loccu_total_loc;
	}

	/**
	 * @return the loccu_source_loc
	 */
	public Long getLoccu_source_loc() {
		return loccu_source_loc;
	}

	/**
	 * @return the loccu_blank_loc
	 */
	public Long getLoccu_blank_loc() {
		return loccu_blank_loc;
	}

	/**
	 * @return the loccu_comment_loc
	 */
	public Long getLoccu_comment_loc() {
		return loccu_comment_loc;
	}

	/**
	 * @return the loccu_eff_comment_loc
	 */
	public Long getLoccu_eff_comment_loc() {
		return loccu_eff_comment_loc;
	}

	/**
	 * @return the date_created
	 */
	public Date getDate_created() {
		return date_created;
	}

	/**
	 * 
	 */
	public Loc() {
		super();
	}	
}
