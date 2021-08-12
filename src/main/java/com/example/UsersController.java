package com.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*import Repository.UsersRepository;

import Entity.Users;
import Exception.NoNameException;
import Exception.NoUserFoundException;*/

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UsersController {

	Logger logger = LoggerFactory.getLogger(UsersController.class);
	@Autowired
	UsersRepository usersRepository;

	
	@GetMapping(value = "/get")
	public List<Users> getData() {
		logger.info("Show information of all the users");
		return usersRepository.findAll();
	}
	
	@GetMapping(value="/get/{id}")
	@Cacheable(value="Users", key="#id")
	public Users getDataById(@PathVariable("id") int id)
	{
		
		  if(usersRepository.findById(id).isPresent()) {
		 
			logger.info("Show information of user with id number: {}",id);
			logger.info("Data is taken from Data Base");
			return usersRepository.findById(id).get();
		}
	
		
		
		  else { logger.error("No user found for id = "+id); throw new
		  NoUserFoundException("No User for ID: "+id); }
		 
		 
	}

	@PostMapping(value = "/load")
	@CachePut(value="Users", key="#users.getId()")
	public Users addData(@RequestBody final Users users) {
		
		if((users.getName().isEmpty()) || (users.getName().length()==0))
		{	
			logger.error("Name is not entered");
			throw new NoNameException("No name is entered");
		}
		else
		{
			 logger.info("User Added");
			 return usersRepository.save(users); 
			 
			 
		}
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<Users> updateData(@PathVariable("id") int id, @RequestBody final Users users)
	{
		
		if(usersRepository.findById(id).isPresent())
		{
			logger.info("Attributes of user with id {} is updated.",id);
			Users new_user = usersRepository.findById(id).get();
			new_user.setName(users.getName());
			new_user.setAge(users.getAge());
			new_user.setCity(users.getCity());
			return new ResponseEntity<Users>(usersRepository.save(new_user),HttpStatus.OK);
		}
		else
		{
			logger.error("No user found for id = "+id);
			throw new NoUserFoundException("No User for ID: "+id);
		}
		
	}
	
		@DeleteMapping(value="/delete/{id}")
		public ResponseEntity<String> deleteData(@PathVariable("id") int id) 
		{
		    
			if(usersRepository.findById(id).isPresent())
			{
				logger.info("User with id {} is deleted",id); 
				usersRepository.deleteById(id);
			      return new ResponseEntity<String> ("deleted",HttpStatus.OK);
			}
			else
			{
				logger.error("No user found for id = "+id);
				throw new NoUserFoundException("No User for ID: "+id);
			}
			
		 }
}


