package com.csipl.hrms.service.organization;

import java.io.File;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.service.organization.repository.GroupRepository;

@Transactional
@Service("groupService")
public class GroupServiceImpl implements GroupService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);

	@Autowired
	StorageService storageService;
	
	@Autowired
	private GroupRepository groupRepository;

	/**
	 * to get Group List  object
 	 */
	@Override
	public List<Groupg> getAllGroups() {
		return groupRepository.findAllGroup();
	}
	/**
	 * Method performed save operation  
 	 */
	@Override
	public Groupg save(Groupg groupg, MultipartFile file, boolean fileFlag) {
		Groupg groupg1 = groupRepository.save(groupg);
		String fileName="";
		if(fileFlag)
		{
			fileName="Group_"+groupg1.getGroupId().toString();
			String extension=FilenameUtils.getExtension(file.getOriginalFilename());
			fileName=fileName+"."+extension;
			System.out.println("File with extension : "+fileName);
			String path=File.separator+"images"+File.separator+"groupImages";
			String dbPath = path+File.separator+fileName;
			storageService.store(file, path, fileName);
			groupg1.setGroupLogoPath(dbPath);
			groupg1=groupRepository.save(groupg1);
			//storageService.store(file, fileName, "GroupImages");	
		}
		return groupg1;
	}
	/**
	 * to get Group object  based on groupId(primary key)  
 	 */
	@Override
	public Groupg getGroup(Long groupId) {
		return groupRepository.findOne(groupId);
	}

}
