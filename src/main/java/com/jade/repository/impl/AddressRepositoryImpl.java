//package com.jade.repository.impl;
//
//import com.jade.domain.Address;
//import com.jade.repository.AddressRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
////added @repository("InMemory") to Repo for AddressServiceImpl @qualifier
//@Repository("InMemory4")
//public class AddressRepositoryImpl implements AddressRepository {
//
//    private static AddressRepositoryImpl repository = null;
//    private Set<Address> addresses;
//
//    private AddressRepositoryImpl(){
//        this.addresses = new HashSet<>();
//    }
//
//    //added a search by AddressId
//    private Address findAddress(final String addressId){
//        // version 1.8 + return this.addresses.stream()
//        // .filter(address -> address
//        // .getAddressId().trim()
//        // .equals(addressId)).findAny().orElse(null);
//        for(Address a : this.addresses){
//            if(a.getAddressId().equals(addressId)) return a;
//        }
//        return null;
//    }
//
//    //changed AddressRepository to AddressRepositoryImpl
//    public static AddressRepositoryImpl getRepository(){
//        if(repository == null) repository = new AddressRepositoryImpl();
//        return repository;
//    }
//
//    //changed return this.getAll(); to
//    @Override
//    public Set<Address> getAll() {
//        return this.addresses;
//    }
//
//    @Override
//    public Address create(Address address) {
//        this.addresses.add(address);
//        return address;
//    }
//
//    //updated update function by addressid
//    @Override
//    public Address update(Address address) {
//        Address toDelete = findAddress(address.getAddressId());
//        if(toDelete != null){
//            this.addresses.remove(toDelete);
//            return create(address);
//        }
//        return null;
//    }
//
//    //updated delete function by addressid
//    @Override
//    public void delete(String addressId) {
//        Address address = findAddress(addressId);
//        if(address != null) this.addresses.remove(address);
//    }
//
//    //updated the read by addressId
//    @Override
//    public Address read(final String addressId) {
//        Address address = findAddress(addressId);
//        return address;
//    }
//}