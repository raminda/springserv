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
@Entity(name = "Mcc")
@Table(name = "metric_mcc")
@PrimaryKeyJoinColumn(name="code_item_file_id")
public class Mcc extends RelmanCodeItemFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="mcc_critical_errors")
	private Long mcc_critical_errors;
	
	@Column(name="mcc_high_errors")
	private Long mcc_high_errors;
	
	@Column(name="mcc_medium_errors")
	private Long mcc_medium_errors;
	
	@Column(name="mcc_low_errors")
	private Long mcc_low_errors;
	
	@Column(name="mcc_whenfree_errors")
	private Long mcc_whenfree_errors;
	
	@Column(name="mcc_comment_density")
	private Double mcc_comment_density;
	
	@Column(name="mcc_blanks_density")
	private Double mcc_blanks_density;
	
	@Column(name="mcc_error_density")
	private Double mcc_error_density;
		
	@Column(name="date_created")
	private Date date_created;

	/**
	 * @return the mcc_critical_errors
	 */
	public Long getMcc_critical_errors() {
		return mcc_critical_errors;
	}

	/**
	 * @return the mcc_high_errors
	 */
	public Long getMcc_high_errors() {
		return mcc_high_errors;
	}

	/**
	 * @return the mcc_medium_errors
	 */
	public Long getMcc_medium_errors() {
		return mcc_medium_errors;
	}

	/**
	 * @return the mcc_low_errors
	 */
	public Long getMcc_low_errors() {
		return mcc_low_errors;
	}

	/**
	 * @return the mcc_whenfree_errors
	 */
	public Long getMcc_whenfree_errors() {
		return mcc_whenfree_errors;
	}

	/**
	 * @return the mcc_comment_density
	 */
	public Double getMcc_comment_density() {
		return mcc_comment_density;
	}

	/**
	 * @return the mcc_blanks_density
	 */
	public Double getMcc_blanks_density() {
		return mcc_blanks_density;
	}

	/**
	 * @return the mcc_error_density
	 */
	public Double getMcc_error_density() {
		return mcc_error_density;
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
	public Mcc() {
		super();
	}
}
