/**
 * 
 */
package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanReleaseFieldCurrent;

/**
 * @author Kalpag
 * 
 */
public interface IssuemanReleaseFieldCurrentService {
	public List<IssuemanReleaseFieldCurrent> getIssuemanReleaseFieldCurrent(
			int offset, int limit);

	public List<IssuemanReleaseFieldCurrent> getIssuemanReleaseFieldCurrent();
}
