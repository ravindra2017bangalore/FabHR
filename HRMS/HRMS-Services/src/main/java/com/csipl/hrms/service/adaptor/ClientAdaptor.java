package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.hrms.dto.organisation.ClientDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.organisation.Client;

public class ClientAdaptor implements Adaptor<ClientDTO, Client> {
	AddressAdaptor addressAdaptor = new AddressAdaptor();

	@Override
	public List<Client> uiDtoToDatabaseModelList(List<ClientDTO> clientDtoList) {
		List<Client> clientList = new ArrayList<Client>();
		for (ClientDTO clientDto : clientDtoList) {

			clientList.add(uiDtoToDatabaseModel(clientDto));
		}
		return clientList;
	}

	@Override
	public List<ClientDTO> databaseModelToUiDtoList(List<Client> clientList) {
		List<ClientDTO> clientDtoList = new ArrayList<ClientDTO>();
		for (Client client : clientList) {

			clientDtoList.add(databaseModelToUiDto(client));
		}
		return clientDtoList;
	}

	@Override
	public Client uiDtoToDatabaseModel(ClientDTO clientDto) {
		Client client = new Client();
		Company company=new Company();
		Groupg groupg=new Groupg();
		client.setClientId(clientDto.getClientId());
		client.setClientName(clientDto.getClientName());
		client.setUserId(clientDto.getUserId());
  		company.setCompanyId(clientDto.getCompanyId());
  		client.setCompany(company);
		
  		
  		if(client.getClientId()==null)
  			client.setDateCreated(new Date());
   		else
   			client.setDateCreated(clientDto.getDateCreated());

  		 
  		client.setDateUpdate(new Date());
  		client.setUserIdUpdate(clientDto.getUserIdUpdate());

  		groupg.setGroupId(1l);
  		client.setGroupg(groupg);
  		client.setAddress(addressAdaptor.uiDtoToDatabaseModel(clientDto.getAddress()));
  		
		
		//client.setUserId(clientDto.getUserId());
		//client.setDateCreated(clientDto.getDateCreated());
		client.setAddress(addressAdaptor.uiDtoToDatabaseModel(clientDto.getAddress()));
		client.setConcernPerson(clientDto.getConcernPerson());
		client.setGstNo(clientDto.getGstNo());
		return client;
	}

	@Override
	public ClientDTO databaseModelToUiDto(Client client) {
		ClientDTO clientDto = new ClientDTO();
		clientDto.setClientId(client.getClientId());
		clientDto.setClientName(client.getClientName());
		clientDto.setUserId(client.getUserId());
		clientDto.setDateCreated(client.getDateCreated());
		clientDto.setAddress(addressAdaptor.databaseModelToUiDto(client.getAddress()));
		clientDto.setConcernPerson(client.getConcernPerson());
		clientDto.setGstNo(client.getGstNo());
		return clientDto;
	}

}
