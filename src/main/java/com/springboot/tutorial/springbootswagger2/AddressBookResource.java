package com.springboot.tutorial.springbootswagger2;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

    ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<String, Contact>();

    @ApiOperation(
            value = "Finds contact by id",
            notes = "Provide an id to look up specific contact from the address book",
            response = Contact.class
    )
    @GetMapping("/{id}")
    public Contact getContact(@ApiParam(value = "ID value for the contact that you  need to retrieve", required = true) @PathVariable String id) {
        return contacts.get(id);
    }

    @GetMapping("/")
    public List<Contact> getAllContacts() {
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact) {
        contacts.put(contact.getId(), contact);
        return contact;
    }
}
