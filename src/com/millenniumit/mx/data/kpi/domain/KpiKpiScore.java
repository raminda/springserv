package com.millenniumit.mx.data.kpi.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.millenniumit.mx.data.kpi.domain.IssuemanProject;

/**
 * 
 * @author Vimukthi
 *
 */
@Entity(name = "KpiKpiScore")
@Table(name = "kpi_kpi_scores")
public class KpiKpiScore extends AuditFields2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private IssuemanProject project;
	
	@ManyToOne
	@JoinColumn(name = "watched_release_id")
	@NotFound( action = NotFoundAction.IGNORE )
	private KpiWatchedRelease release;
	
	@ManyToOne
	@JoinColumn(name = "kpi_instance_id")
	private KpiKpiInstance instance;
	
	@Column(name = "week")
	private String week;
	
	@Column(name = "as_at")
	private String asAt;
	
	@Column(name = "value")
	private Double value;
	
	@Column(name = "raw_percentage")
	private Double rawPercentage;
	
	@Column(name = "adjusted_percentage")
	private Double adjustedPercentage;
	
	@Column(name = "score")
	private Double score;
	
	@Column(name = "weighted_score")
	private Double weightedScore;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the project
	 */
	public IssuemanProject getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(IssuemanProject project) {
		this.project = project;
	}

	/**
	 * @return the release
	 */
	public KpiWatchedRelease getRelease() {
		return release;
	}

	/**
	 * @param release the release to set
	 */
	public void setRelease(KpiWatchedRelease release) {
		this.release = release;
	}

	/**
	 * @return the instance
	 */
	public KpiKpiInstance getInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public void setInstance(KpiKpiInstance instance) {
		this.instance = instance;
	}

	/**
	 * @return the week
	 */
	public String getWeek() {
		return week;
	}

	/**
	 * @param week the week to set
	 */
	public void setWeek(String week) {
		this.week = week;
	}

	/**
	 * @return the asAt
	 */
	public String getAsAt() {
		return asAt;
	}

	/**
	 * @param asAt the asAt to set
	 */
	public void setAsAt(String asAt) {
		this.asAt = asAt;
	}

	/**
	 * @return the value
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 * @return the rawPercentage
	 */
	public Double getRawPercentage() {
		return rawPercentage;
	}

	/**
	 * @param rawPercentage the rawPercentage to set
	 */
	public void setRawPercentage(Double rawPercentage) {
		this.rawPercentage = rawPercentage;
	}

	/**
	 * @return the adjustedPercentage
	 */
	public Double getAdjustedPercentage() {
		return adjustedPercentage;
	}

	/**
	 * @param adjustedPercentage the adjustedPercentage to set
	 */
	public void setAdjustedPercentage(Double adjustedPercentage) {
		this.adjustedPercentage = adjustedPercentage;
	}

	/**
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Double score) {
		this.score = score;
	}

	/**
	 * @return the weightedScore
	 */
	public Double getWeightedScore() {
		return weightedScore;
	}

	/**
	 * @param weightedScore the weightedScore to set
	 */
	public void setWeightedScore(Double weightedScore) {
		this.weightedScore = weightedScore;
	}	
}
