package com.example.payease.controller

import com.example.payease.dto.CreateUserDto
import com.example.payease.model.Users
import com.example.payease.service.UsersService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UsersController(private val usersService: UsersService) {

    @GetMapping()
    fun getAllUsers(): MutableList<Users> {
        return this.usersService.getAll();
    }

    @GetMapping("/{id}")
    fun getAllUsers(@PathVariable id: UUID):Users? {
        return this.usersService.getById(id);
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID){
        return this.usersService.deleteById(id);
    }

    @PostMapping("/create")
    fun createUser(@RequestBody createUserDto: CreateUserDto): Users {
        return this.usersService.createUser(createUserDto);
    }
}