package pl.dmcs.iwalecture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.iwalecture.model.Address;
import pl.dmcs.iwalecture.repository.AddressRepository;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressRESTController {
    private AddressRepository addressRepository;

    @Autowired
    public AddressRESTController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        addressRepository.save(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("id") long id) {
        if (!addressRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        addressRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAddress(@RequestBody Address address, @PathVariable("id") long id) {
        if (!addressRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        address.setId(id);
        addressRepository.save(address);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") long id) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}

