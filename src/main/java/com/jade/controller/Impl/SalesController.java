//package com.jade.controller.Impl;
//
//import com.jade.domain.Sales;
//import com.jade.service.SalesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/sales")
//public class SalesController {
//    @Autowired
//    @Qualifier("SalesServiceImpl")
//    private SalesService service;
//
//    @PostMapping("/create")
//    @ResponseBody
//    public Sales create(@RequestBody Sales sales) {
//        return service.create(sales);
//    }
//
//    @PostMapping("/update")
//    @ResponseBody
//    public Sales update(@RequestBody Sales sales) {
//        return service.update(sales);
//    }
//
//    @GetMapping("/delete/{id}")
//    @ResponseBody
//    public void delete(@PathVariable String id) {
//        service.delete(id);
//    }
//
//    @GetMapping("/read/{id}")
//    @ResponseBody
//    public Sales read(@PathVariable String id) {
//        return service.read(id);
//    }
//
//    @GetMapping("/read/all")
//    @ResponseBody
//    public Set<Sales> getAll() {
//        return service.getAll();
//    }
//}
