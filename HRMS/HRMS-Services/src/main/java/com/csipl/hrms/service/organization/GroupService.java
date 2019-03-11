package com.csipl.hrms.service.organization;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.model.common.Groupg;

public interface GroupService {
	public List<Groupg> getAllGroups();
	
	public Groupg getGroup(Long groupId);

	public Groupg save(Groupg groupg, MultipartFile file, boolean fileFlag);

}
