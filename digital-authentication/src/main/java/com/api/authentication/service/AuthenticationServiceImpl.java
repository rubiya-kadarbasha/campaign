/**
 *
 * <p>Title       		: AuthenticationServiceImpl</p>
 * <p>Description 		: This is a AuthenticationServiceImpl class</p>
 * <p>Date of Creation 	: 2020-02-19</p>
 * <p>Source      		: AuthenticationServiceImpl </p>
 * <p>Package     		: com.api.authentication.service</p>
 * 
 * @author Rubiya KadarBasha
 * @version 1.0
 * 
 * <p>------------------------------------------------------------------------------------</p>
 * <p>:MODIFICATION HISTORY:</p>
 * <p>------------------------------------------------------------------------------------</p>
 * <p>SERIAL  AUTHOR     DATE            SCF            DESCRIPTION</p>
 * <p>------------------------------------------------------------------------------------</p>
 * 
 * <p>------------------------------------------------------------------------------------</p>
 */
package com.api.authentication.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.api.authentication.config.ElasticSearchUserConfig;
import com.api.authentication.constant.Constant;
import com.api.authentication.model.SignedResponse;
import com.api.authentication.model.UserEntity;
import com.api.authentication.models.Login;
import com.api.authentication.models.Logout;
import com.api.authentication.util.AuthenticationUtil;
import lombok.AllArgsConstructor;


/**
 * The Class AuthenticationServiceImpl.
 *
 * @author rubiya.kadarbasha
 */
@Component
@CrossOrigin(origins = "*", allowedHeaders = "*")

/**
 * Instantiates a new authentication service impl.
 *
 * @param util the util
 * @param config the config
 */
@AllArgsConstructor
public class AuthenticationServiceImpl {

	/** The util. */
	@Autowired
	AuthenticationUtil util;
	
	/** The config. */
	@Autowired
	ElasticSearchUserConfig config;
	

	/**
	 * Logger object is initialized for AuthenticationServiceImpl class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

	/**
	 * Validate jwt and process login request.
	 *
	 * @param headersMap the headers map
	 * @param loginObj the login obj
	 * @return the response entity
	 * @throws Exception the exception
	 */
	public ResponseEntity<SignedResponse> validateJwtAndProcessLoginRequest(final Map<String, String> headersMap,
			final Login loginObj) throws Exception {

			final String userName = loginObj.getPayload().getUsername();
			final String password = loginObj.getPayload().getPassword();

		LOGGER.info("{} userName request", userName);
		LOGGER.info("{} password request", password);

		if (userName.equals(Constant.USERNAME) && password.equals(Constant.PASSWORD)) {
			
			
			
			return util.processRequest(Constant.RESPONSE_CODE_200, loginObj);
		}  
		else {
			return util.processRequest(Constant.ERROR_CODE_401, loginObj);
		}
	

	}
	
	/**
	 * Validate jwt and process logout request.
	 *
	 * @param headersMap the headers map
	 * @param lObj the l obj
	 * @return the response entity
	 * @throws Exception the exception
	 */
	public ResponseEntity<SignedResponse> validateJwtAndProcessLogoutRequest(final Map<String, String> headersMap,
			final Logout lObj) throws Exception {

			final String islogout = lObj.getPayload().getIslogout();
		LOGGER.info("{} islogout request", islogout);


		if (islogout.equals(Constant.TRUE) ) {
			
						
			return util.processLogoutRequest(Constant.RESPONSE_CODE_200);
		}  
		else {
			return util.processLogoutRequest(Constant.ERROR_CODE_422);
		}
	
	

	}
	/*
	 * @see com.assignment.service.UserDetails#ListofUsers()
	 */
	
	/**
	 * Listof users.
	 *
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<UserEntity> ListofUsers() throws IOException {
		
		
		/**
		 * Elastic search Starts
		 */
		List<UserEntity> list = config.listOfUsers();

		LOGGER.info("ALL Elastic Search CAMPAGINS {}"+list);
		/**
		 * Elastic search End
		 */
		return list;

	}

	/**
	 * Listof ongoing users.
	 *
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<UserEntity> ListofOngoingUsers() throws IOException {
		/**
		 * Elastic search Starts
		 */
		List<UserEntity> list = config.listOfOngoingUsers();

		LOGGER.info("Ongoing Elastic Search CAMPAGINS List  {}"+list);
		/**
		 * Elastic search End
		 */
		return list;
	}

	/**
	 * Listofcompleted users.
	 *
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<UserEntity> ListofcompletedUsers() throws IOException {
		/**
		 * Elastic search Starts
		 */
		List<UserEntity> list = config.listOfCompletedUsers();

		LOGGER.info("Completed Elastic Search CAMPAGINS List {}"+list);
		/**
		 * Elastic search End
		 */
		return list;
	}

	/**
	 * Listof historical users.
	 *
	 * @param historical the historical
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<UserEntity> ListofHistoricalUsers(String historical) throws IOException {
		/**
		 * Elastic search Starts
		 */
		List<UserEntity> list = config.listOfHistoricalUsers(historical);

		LOGGER.info("Completed Elastic Search CAMPAGINS List {}"+list);
		/**
		 * Elastic search End
		 */
		return list;	}
	

	

}
