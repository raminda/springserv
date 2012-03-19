package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Entity(name = "RelmanCurrentCodeItemFile")
@Table(name = "relman_current_code_item_files")
public class RelmanCurrentCodeItemFile extends AuditFields implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "code_item_id")
	private RelmanCodeItem codeItem;
	
	@Column(name = "code_path")
	private int codePath;
	
	@ManyToOne
	@JoinColumn(name = "code_item_file_id")
	private RelmanCodeItemFile codeItemFile;
	
	@Column(name = "current_version")
	private int currentVersion;

	@Column(name = "code_item_file_name")
	private String codeItemFileName;  
	
	/**
	 * 
	 */
	public RelmanCurrentCodeItemFile() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the codeItem
	 */
	public RelmanCodeItem getCodeItem() {
		return codeItem;
	}

	/**
	 * @return the codePath
	 */
	public int getCodePath() {
		return codePath;
	}

	/**
	 * @return the codeItemFile
	 */
	public RelmanCodeItemFile getCodeItemFile() {
		return codeItemFile;
	}

	/**
	 * @return the currentVersion
	 */
	public int getCurrentVersion() {
		return currentVersion;
	}

	/**
	 * @return the codeItemFileName
	 */
	public String getCodeItemFileName() {
		return codeItemFileName;
	}
}
