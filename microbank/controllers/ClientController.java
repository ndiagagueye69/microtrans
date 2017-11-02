package microbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import microbank.models.Client;
import microbank.models.ClientRepository;

import microbank.models.Contact;
import microbank.models.ContactRepository;


@Controller
public class ClientController {

  // ==============
  // PRIVATE FIELDS
  // ==============

  @Autowired
  private ClientRepository clientRepository;
  
  @Autowired
  private ContactRepository contactRepository;


  /**
   * /user/create/person?email=[email]&firstName=[firstName] -> create a new 
   * person user and save it in the database.
   * 
   * @param email The person's email
   * @param firstName The person's first name
   * @return a string describing if the person is succesfully created or not.
   */
  @RequestMapping("/microbank/create/client")
  @ResponseBody
  public String createPerson(String name, String firstName) {
    try {
      Client client = new Client();
      client.setName(name);
      client.setFirstName(firstName);
      clientRepository.save(client);
    }
    catch (Exception ex) {
      return "Error creating the client: " + ex.toString();
    }
    return "Client succesfully created!";
  }
  
  
  @RequestMapping("/microbank/get/client")
  @ResponseBody
  public String getclient(Long id) {
	
    try {
      Client client = clientRepository.findOne(id);
      System.out.println(client.getName() + "    "+ client.getFirstName() );
      if(client.getContacts() != null){
    	  for (Contact c : client.getContacts()){
    		  System.out.println(c.getOwner().getId() + "    "+ c.getContact().getId() );
    	  }
      }
    }
    catch (Exception ex) {
      return "Error creating the client: " + ex.toString();
    }
    return "Client succesfully created! " ;
  }
  
  @RequestMapping("/microbank/add/contact")
  @ResponseBody
  public String addContact(Long owner, Long contact) {
    try {
      Client client = clientRepository.findOne(owner);
      Client contact1 = clientRepository.findOne(contact);
      
      Contact cc = new Contact();
      cc.setOwner(client);
      cc.setContact(contact1);
      
      contactRepository.save(cc);
    }
    catch (Exception ex) {
      return "Error creating the client: " + ex.toString();
    }
    return "Client succesfully created!";
  }
} 
