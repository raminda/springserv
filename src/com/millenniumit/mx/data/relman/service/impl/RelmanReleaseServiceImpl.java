package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanReleaseDao;
import com.millenniumit.mx.data.relman.domain.*;
import com.millenniumit.mx.data.relman.service.RelmanReleaseService;
import com.millenniumit.mx.data.relman.util.RelmanReleaseCriteria;

@Service("relmanReleaseService")
public class RelmanReleaseServiceImpl implements RelmanReleaseService {

	@Autowired
	@Qualifier("relmanReleaseDao")
	private RelmanReleaseDao releasedao;

	public RelmanReleaseDao getReleasedao() {
		return releasedao;
	}

	public void setReleasedao(RelmanReleaseDao releasedao) {
		this.releasedao = releasedao;
	}

	@Override
	@Transactional
	public List<RelmanRelease> getRelmanReleases() {
		return releasedao.getRelmanReleases();
	}

	@Override
	@Transactional
	public List<RelmanRelease> getRelmanReleases(RelmanReleaseCriteria criteria) {

		if (criteria.getState() == null && criteria.getParentRelease() == null) {
			return releasedao.getRelmanReleases(criteria.getProject());

		} else if (criteria.getProject() == null && criteria.getState() == null) {
			return releasedao.getRelmanReleases(criteria.getParentRelease());

		} else if (criteria.getProject() == null
				&& criteria.getParentRelease() == null) {
			return releasedao.getRelmanReleases(criteria.getState());

		} else if (criteria.getState() != null
				&& criteria.getParentRelease() != null) {
			return releasedao.getRelmanReleases(criteria.getParentRelease(),
					criteria.getState());

		} else if (criteria.getState() != null && criteria.getProject() != null) {
			return releasedao.getRelmanReleases(criteria.getProject(),
					criteria.getState());

		} else if (criteria.getParentRelease() != null
				&& criteria.getProject() != null) {
			return releasedao.getRelmanReleases(criteria.getParentRelease());

		} else if (criteria.getParentRelease() != null
				&& criteria.getProject() != null && criteria.getState() == null) {
			return releasedao.getRelmanReleases(criteria.getParentRelease(),
					criteria.getState());
		}

		return null;
	}

	@Override
	@Transactional
	public List<RelmanRelease> getRelmanReleases(int offset, int limit) {
		return releasedao.getRelmanReleases(offset, limit);
	}

	@Override
	@Transactional
	public List<RelmanRelease> getRelmanReleases(
			RelmanReleaseCriteria criteria, int offset, int limit) {

		if (criteria.getState() == null && criteria.getParentRelease() == null) {
			return releasedao.getRelmanReleases(criteria.getProject(), offset,
					limit);

		} else if (criteria.getProject() == null && criteria.getState() == null) {
			return releasedao.getRelmanReleases(criteria.getParentRelease(),
					offset, limit);

		} else if (criteria.getProject() == null
				&& criteria.getParentRelease() == null) {
			return releasedao.getRelmanReleases(criteria.getState(), offset,
					limit);

		} else if (criteria.getState() != null
				&& criteria.getParentRelease() != null) {
			return releasedao.getRelmanReleases(criteria.getParentRelease(),
					criteria.getState(), offset, limit);

		} else if (criteria.getState() != null && criteria.getProject() != null) {
			return releasedao.getRelmanReleases(criteria.getProject(),
					criteria.getState(), offset, limit);

		} else if (criteria.getParentRelease() != null
				&& criteria.getProject() != null) {
			return releasedao.getRelmanReleases(criteria.getParentRelease(),
					offset, limit);

		} else if (criteria.getParentRelease() != null
				&& criteria.getProject() != null && criteria.getState() == null) {
			return releasedao.getRelmanReleases(criteria.getParentRelease(),
					criteria.getState(), offset, limit);

		}

		return null;
	}

	@Override
	@Transactional
	public RelmanRelease getRelmanRelease(String relmanId) {
		return releasedao.getRelmanRelease(relmanId);
	}

	@Override
	@Transactional
	public RelmanRelease getRelmanRelease(Long id) {
		return releasedao.getRelmanRelease(id);
	}

	@Override
	@Transactional
	public long getRelmanReleasesCount() {
		return releasedao.getRelmanReleasesCount();
	}

	@Override
	@Transactional
	public long getRelmanReleasesCount(RelmanReleaseCriteria criteria) {
		if (criteria.getState() == null && criteria.getParentRelease() == null) {
			return releasedao.getRelmanReleasesCount(criteria.getProject());

		} else if (criteria.getProject() == null && criteria.getState() == null) {
			return releasedao.getRelmanReleasesCount(criteria
					.getParentRelease());

		} else if (criteria.getProject() == null
				&& criteria.getParentRelease() == null) {
			return releasedao.getRelmanReleasesCount(criteria.getState());

		} else if (criteria.getState() != null
				&& criteria.getParentRelease() != null) {
			return releasedao.getRelmanReleasesCount(
					criteria.getParentRelease(), criteria.getState());

		} else if (criteria.getState() != null && criteria.getProject() != null) {
			return releasedao.getRelmanReleasesCount(criteria.getProject(),
					criteria.getState());

		} else if (criteria.getParentRelease() != null
				&& criteria.getProject() != null) {
			return releasedao.getRelmanReleasesCount(criteria
					.getParentRelease());

		} else if (criteria.getParentRelease() != null
				&& criteria.getProject() != null && criteria.getState() == null) {
			return releasedao.getRelmanReleasesCount(
					criteria.getParentRelease(), criteria.getState());

		}

		return 0;
	}
}
