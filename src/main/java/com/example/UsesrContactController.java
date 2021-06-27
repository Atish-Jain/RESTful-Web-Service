
  package com.example;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.RequestMapping; import
  org.springframework.web.bind.annotation.RestController;
  
  @RequestMapping("/userscontact")
  
  @RestController public class UsesrContactController {
  
  @Autowired UsersContactRepository usersContactRepository;
  
  @Autowired UsersRepository usersRepository;
 
  @GetMapping(value="/get")
  public List <UsersContact> getContacts()
	  {
		  return usersContactRepository.findAll();
	  }
  }
 