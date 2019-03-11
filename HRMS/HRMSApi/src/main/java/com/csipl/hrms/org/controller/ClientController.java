
package com.csipl.hrms.org.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.ClientDTO;
import com.csipl.hrms.model.organisation.Client;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.ClientAdaptor;
import com.csipl.hrms.service.organization.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	ClientAdaptor clientAdaptor = new ClientAdaptor();

	@Autowired
	ClientService clientService;

	/**
	 * @param clientDto
	 *            This is the first parameter for getting client Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveClient(@RequestBody ClientDTO clientDto, HttpServletRequest req) {
		logger.info("saveClient is calling : " + " : ClientDTO " + clientDto);
		Client client = clientAdaptor.uiDtoToDatabaseModel(clientDto);
		clientService.save(client);
	}

	/**
	 * to get all Clients List from database based on companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ClientDTO> findAllClients(@RequestParam("companyId") String companyId,
			HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("findAllClients is calling : ");
		Long longCompanyId = Long.parseLong(companyId);
		List<Client> clientList = clientService.getAllClients(longCompanyId);
		logger.info("clientList: " + clientList);
		if (clientList != null && clientList.size() > 0)
			return clientAdaptor.databaseModelToUiDtoList(clientList);
		else
			throw new ErrorHandling("Data not found");
	}

	/**
	 * to get branch Object from database based on clientId
	 */
	@RequestMapping(path = "/{clientId}", method = RequestMethod.GET)
	public @ResponseBody ClientDTO findClient(@PathVariable("clientId") String clientId) {
		logger.info("findClient is calling : " + "clientId " + clientId);
		Long longClientId = Long.parseLong(clientId);
		return clientAdaptor.databaseModelToUiDto(clientService.getClient(longClientId));
	}
}
