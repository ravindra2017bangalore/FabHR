package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.payroll.TdsSlabDTO;
import com.csipl.hrms.dto.payroll.TdsSlabHdDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.payroll.TdsSlab;
import com.csipl.hrms.model.payroll.TdsSlabHd;

public class TdsSlabAdaptor implements Adaptor<TdsSlabHdDTO, TdsSlabHd> {

	@Override
	public List<TdsSlabHd> uiDtoToDatabaseModelList(List<TdsSlabHdDTO> tdsSlabHdDtoList) {
		// TODO Auto-generated method stub
		return null;
	}
 	@Override
	public List<TdsSlabHdDTO> databaseModelToUiDtoList(List<TdsSlabHd> tdsSlabHdList) {
 		List<TdsSlabHdDTO> tdsSlabHdDtoList =new ArrayList<TdsSlabHdDTO>();
 		for (TdsSlabHd tdsSlabHd : tdsSlabHdList) {
 			tdsSlabHdDtoList.add(databaseModelToUiDto(tdsSlabHd));
		}
  		return tdsSlabHdDtoList;
	}
 	@Override
	public TdsSlabHd uiDtoToDatabaseModel(TdsSlabHdDTO tdsSlabHdDto) {
		TdsSlabHd tdsSlabHd=new TdsSlabHd();
 		tdsSlabHd.setDateEffective(tdsSlabHdDto.getDateEffective());
		tdsSlabHd.setTdsCategory(tdsSlabHdDto.getTdsCategory());
  		tdsSlabHd.setTdsSLabHdId(tdsSlabHdDto.getTdsSLabHdId());
  		tdsSlabHd.setUserId(tdsSlabHdDto.getUserId());
  		tdsSlabHd.setDateCreated(tdsSlabHdDto.getDateCreated());
 		tdsSlabHd.setTdsSlabs(uiDtoToDatabaseModelListTds(tdsSlabHdDto.getTdsSlabs(),tdsSlabHd));
 		Company company=new Company();
 		company.setCompanyId(tdsSlabHdDto.getCompanyId());
 		tdsSlabHd.setCompany(company);
 		Groupg groupg=new Groupg();
		groupg.setGroupId(1l);
		tdsSlabHd.setGroupg(groupg);
		if(tdsSlabHdDto.getDateCreated()==null)
		tdsSlabHd.setDateCreated(new Date());
		else
		tdsSlabHd.setDateCreated(tdsSlabHdDto.getDateCreated());
		tdsSlabHd.setDateUpdate(new Date());
		tdsSlabHd.setUserIdUpdate(tdsSlabHdDto.getUserIdUpdate());
  		return tdsSlabHd;
 	}
  
 
 	public List<TdsSlabDTO> databaseModelToUiDto(List<TdsSlab> tdsSlabListHd){
 		List<TdsSlabDTO> TdsSlabDtoList=new  ArrayList<TdsSlabDTO>();
 		for (TdsSlab tdsSlab : tdsSlabListHd) {
 			TdsSlabDtoList.add(databaseModelToUiDto(tdsSlab));
		}
   		return TdsSlabDtoList;
  	}
   
  	public TdsSlab uiDtoToDatabaseModel(TdsSlabDTO tdsSlabDto, TdsSlabHd tdsSlabHd) {
		TdsSlab tdsSlab=new TdsSlab();
 		tdsSlab.setLimitFrom(tdsSlabDto.getLimitFrom());
		tdsSlab.setLimitTo(tdsSlabDto.getLimitTo());
		tdsSlab.setTdsSLabId(tdsSlabDto.getTdsSLabId());
		tdsSlab.setTdsPercentage(tdsSlabDto.getTdsPercentage());
		tdsSlab.setUserId(tdsSlabDto.getUserId());
		tdsSlab.setDateCreated(tdsSlabDto.getDateCreated());
		tdsSlab.setTdsSlabHd(tdsSlabHd);
		tdsSlab.setUserId(tdsSlabDto.getUserId());
		if(tdsSlabDto.getDateCreated()==null)
		tdsSlab.setDateCreated(new Date());
		else
		tdsSlab.setDateCreated(tdsSlabDto.getDateCreated());	
		tdsSlab.setDateUpdate(new Date());
		tdsSlab.setUserIdUpdate(tdsSlabDto.getUserId());
   		return tdsSlab;
	}
   	public	TdsSlabDTO databaseModelToUiDto(TdsSlab tdsSlab) {
 		TdsSlabDTO tdsSlabDto=new TdsSlabDTO();
 		tdsSlabDto.setLimitFrom(tdsSlab.getLimitFrom());
 		tdsSlabDto.setLimitTo(tdsSlab.getLimitTo());
 		tdsSlabDto.setTdsPercentage(tdsSlab.getTdsPercentage());
 		tdsSlabDto.setTdsSLabId(tdsSlab.getTdsSLabId());
 		tdsSlabDto.setUserId(tdsSlab.getUserId());
 		tdsSlabDto.setDateCreated(tdsSlab.getDateCreated());
		return tdsSlabDto;
		}
 	@Override
	public TdsSlabHdDTO databaseModelToUiDto(TdsSlabHd tdsSlabHd) {
 		TdsSlabHdDTO tdsSlabHdDto=new TdsSlabHdDTO();
 		tdsSlabHdDto.setDateEffective(tdsSlabHd.getDateEffective());
 		tdsSlabHdDto.setTdsCategory(tdsSlabHd.getTdsCategory());
 		tdsSlabHdDto.setTdsCategoryValue(DropDownCache.getInstance().getDropDownValue( DropDownEnum.Category.getDropDownName() , tdsSlabHd.getTdsCategory() ));
 		tdsSlabHdDto.setTdsSLabHdId(tdsSlabHd.getTdsSLabHdId());
 		tdsSlabHdDto.setUserId(tdsSlabHd.getUserId());
 		tdsSlabHdDto.setDateCreated(tdsSlabHd.getDateCreated());
 		if(tdsSlabHd.getTdsSlabs()!=null)  
 		tdsSlabHdDto.setTdsSlabs(databaseModelToUiDto(tdsSlabHd.getTdsSlabs()));
  		return tdsSlabHdDto;
	}
 	public  List<TdsSlab> uiDtoToDatabaseModelListTds(List<TdsSlabDTO> tdsSlabDtoList, TdsSlabHd tdsSlabHd){
		List<TdsSlab> tdsSlabList=new ArrayList<TdsSlab>();
 		for (TdsSlabDTO tdsSlabDto : tdsSlabDtoList) {
			tdsSlabList.add(uiDtoToDatabaseModel(tdsSlabDto, tdsSlabHd));
		}
 		return tdsSlabList;
 	}
  }
