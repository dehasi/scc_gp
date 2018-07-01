package me.dehasi.contracts.sub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserExistsController {

    @GetMapping("/exists/{userId}")
    public ResponseEntity isExists(@PathVariable("userId") String userId) {
        try {
            int id = Integer.parseInt(userId);
            if (0 < id && id < 30) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
