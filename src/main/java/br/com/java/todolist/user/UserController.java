package br.com.java.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private IUserRepository userRepository;

    /**
     * Body
     * 
     * @param userModel
     */
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByName(userModel.getUsername());

        if(user != null){
            //Mensagem de erro
            //Status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
        }
    }

}
