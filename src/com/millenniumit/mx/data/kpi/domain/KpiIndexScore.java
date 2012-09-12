package com.millenniumit.mx.data.kpi.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.millenniumit.mx.data.kpi.domain.KpiProject;

/**
 * 
 * @author Vimukthi
 *
 */
@Entity(name = "KpiIndexScore")
@Table(name = "kpi_index_scores")
public class KpiIndexScore extends AuditFields2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "level_id")
	private KpiLevel level;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private KpiProject project;
	
	@ManyToOne
	@JoinColumn(name = "watched_release_id")
	@NotFound( action = NotFoundAction.IGNORE )
	private KpiWatchedRelease release;
	
	@ManyToOne
	@JoinColumn(name = "index_id")
	private KpiIndex index;
	
	@Column(name = "week")
	private String week;
	
	@Column(name = "as_at")
	private String asAt;
	
	@Column(name = "sum_score")
	private Double sumScore;
	
	@Column(name = "sum_weight")
	private int sumWeight;
	
	@Column(name = "score")
	private Double score;

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
	 * @return the level
	 */
	public KpiLevel getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(KpiLevel level) {
		this.level = level;
	}

	/**
	 * @return the project
	 */
	public KpiProject getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(KpiProject project) {
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
	 * @return the index
	 */
	public KpiIndex getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(KpiIndex index) {
		this.index = index;
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
	 * @return the sumScore
	 */
	public Double getSumScore() {
		return sumScore;
	}

	/**
	 * @param sumScore the sumScore to set
	 */
	public void setSumScore(Double sumScore) {
		this.sumScore = sumScore;
	}

	/**
	 * @return the sumWeight
	 */
	public int getSumWeight() {
		return sumWeight;
	}

	/**
	 * @param sumWeight the sumWeight to set
	 */
	public void setSumWeight(int sumWeight) {
		this.sumWeight = sumWeight;
	}	
}
