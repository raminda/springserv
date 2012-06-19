package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 
 * @author Kalpag
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
	private IssuemanProject project;
	
	@ManyToOne
	@JoinColumn(name = "release_id")
	@NotFound( action = NotFoundAction.IGNORE )
	private IssuemanRelease release;
	
	@ManyToOne
	@JoinColumn(name = "index_id")
	private KpiIndex index;
	
	@Column(name = "week")
	private String week;
	
	@Column(name = "as_at")
	private String asAt;
	
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
	public IssuemanRelease getRelease() {
		return release;
	}

	/**
	 * @param release the release to set
	 */
	public void setRelease(IssuemanRelease release) {
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
}
