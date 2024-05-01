package com.user.controller;

import com.user.model.UserModel;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/post")
    public ResponseEntity<String>insert(@RequestBody UserModel userModel){
        UserModel user=userService.insert(userModel);
        if(user!=null){
            return ResponseEntity.ok("inserted successfully !!!");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not inserted");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?>getAll(){
        List<UserModel> userAll=userService.getAll();
        if(!userAll.isEmpty()){
            return ResponseEntity.ok(userAll);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not fetched all data");
        }
    }


    @DeleteMapping("/delete/{roll}")
    public ResponseEntity<String>deleteByRoll(@PathVariable Long roll){
        try {
            userService.deleteByRoll(roll);
            return ResponseEntity.ok("deleted successfully !!!");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not deleted based on given roll");
        }
    }

}
