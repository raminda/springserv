package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanRelationDao;
import com.millenniumit.mx.data.relman.domain.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Repository("relmanRelationDao")
@SuppressWarnings("unchecked")
public class RelmanRelationHibernateDao implements RelmanRelationDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public List<RelmanRelation> getRelmanRelations() {
		return sessionfactory.getCurrentSession()
				.createQuery("from RelmanRelation").setMaxResults(10).list();
	}

	/**
	 * Returns a list of RelmanCodeItemFile objects for the given hierarchy of
	 * relman objects
	 * 
	 */
	@Override
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(
			RelmanRelease release, RelmanGroup group, RelmanModule module,
			RelmanCodeItem codeItem) {

		return sessionfactory
				.getCurrentSession()
				.createQuery(
						"select r.relationKey.file from RelmanRelation r "
								+ "where r.relationKey.release=:release and r.group=:group"
								+ " and r.module=:module and r.codeItem=:codeItem")
				.setParameter("release", release).setParameter("group", group)
				.setParameter("module", module)
				.setParameter("codeItem", codeItem).list();
	}

	/**
	 * Returns a list of RelmanCodeItemFile objects for the given hierarchy of
	 * relman objects
	 * 
	 */
	@Override
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(
			RelmanRelease release, RelmanGroup group, RelmanModule module) {

		return sessionfactory
				.getCurrentSession()
				.createQuery(
						"select r.relationKey.file from RelmanRelation r "
								+ "where r.relationKey.release=:release and r.group=:group"
								+ " and r.module=:module")
				.setParameter("release", release)
				.setParameter("group", group)
				.setParameter("module", module).list();
	}

	/**
	 * Returns a list of RelmanCodeItemFile objects for the given hierarchy of
	 * relman objects
	 * 
	 */
	@Override
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(
			RelmanRelease release, RelmanGroup group) {
		return sessionfactory
				.getCurrentSession()
				.createQuery(
						"select r.relationKey.file from RelmanRelation r "
								+ "where r.relationKey.release=:release and r.group=:group")
				.setParameter("release", release)
				.setParameter("group", group)
				.list();
	}

	/**
	 * Returns a list of RelmanCodeItemFile objects for the given hierarchy of
	 * relman objects
	 * 
	 */
	@Override
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(RelmanRelease release) {
		return sessionfactory
				.getCurrentSession()
				.createQuery(
						"select r.relationKey.file from RelmanRelation r "
								+ "where r.relationKey.release=:release")
				.setParameter("release", release).list();
	}	
	
	/**
	 * Returns a list of RelmanCodeItemFile objects for the given hierarchy of
	 * relman objects
	 * 
	 */
	@Override	
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(
			RelmanRelease release, RelmanGroup group, RelmanModule module, String codeItemType) {

		return sessionfactory
				.getCurrentSession()
				.createQuery(
						"select r.relationKey.file from RelmanRelation r "
								+ "where r.relationKey.release=:release and r.group=:group"
								+ " and r.module=:module"
								+ " and r.codeItem.type=:codeItemType")
				.setParameter("release", release).setParameter("group", group)
				.setParameter("module", module)
				.setParameter("codeItemType", codeItemType)
				.list();
	}

	/**
	 * 
	 */
	@Override
	public List<RelmanCodeItem> getRelmanCodeItems(RelmanRelease release,
			RelmanGroup group, RelmanModule module) {
		return sessionfactory
				.getCurrentSession()
				.createQuery(
						"select distinct r.codeItem from RelmanRelation r "
								+ "where r.relationKey.release=:release and r.group=:group"
								+ " and r.module=:module")
				.setParameter("release", release)
				.setParameter("group", group)
				.setParameter("module", module)
				.list();
	}

	/**
	 * 
	 */
	@Override
	public List<RelmanModule> getRelmanModules(RelmanRelease release,
			RelmanGroup group) {
		return sessionfactory
				.getCurrentSession()
				.createQuery(
						"select distinct r.module from RelmanRelation r "
								+ "where r.relationKey.release=:release "
								+ "and r.group=:group")
				.setParameter("release", release)
				.setParameter("group", group)
				.list();
	}

	/**
	 * 
	 */
	@Override
	public List<RelmanGroup> getRelmanGroups(RelmanRelease release) {
		return sessionfactory
				.getCurrentSession()
				.createQuery(
						"select distinct r.group from RelmanRelation r "
								+ "where r.relationKey.release=:release")
				.setParameter("release", release)
				.list();
	}

	/**
	 * 
	 */
	@Override
	public List<RelmanCodeItem> getRelmanCodeItems(RelmanRelease release,
			RelmanGroup group, RelmanModule module, String codeItemType) {
		return sessionfactory
				.getCurrentSession()
				.createQuery(
						"select distinct r.codeItem from RelmanRelation r "
								+ "where r.relationKey.release=:release " 
								+ "and r.group=:group"
								+ " and r.module=:module"
								+ " and r.type=:codeItemType")
				.setParameter("release", release)
				.setParameter("group", group)
				.setParameter("module", module)
				.setParameter("codeItemType", codeItemType)
				.list();
	}
}
