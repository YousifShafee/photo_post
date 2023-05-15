package com.photo_service.photo_post.service;

import com.photo_service.photo_post.constants.PhotoPostConstants;
import com.photo_service.photo_post.model.Person;
import com.photo_service.photo_post.model.Roles;
import com.photo_service.photo_post.repository.PersonRepository;
import com.photo_service.photo_post.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(PhotoPostConstants.USER_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
