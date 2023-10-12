package br.com.java.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Modificadores
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    /**
     * String (texto)
     * Integer (int) numeros inteiros
     * Double (float) números 0.0000
     * Float (float) números 0.0000
     * Char (A C)
     * Date (data)
     * Void - não retorna valor/resultado 
     */

     /**
      * Body
      * @param userModel
      */
    @PostMapping("/")  
    public void create (@RequestBody UserModel userModel){

        System.out.println("userModel.name");

    }

}
