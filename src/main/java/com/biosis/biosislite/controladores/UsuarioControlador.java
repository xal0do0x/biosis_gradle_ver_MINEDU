/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.Usuario;
import com.biosis.biosislite.utiles.Encriptador;

/**
 *
 * @author RyuujiMD
 */
public class UsuarioControlador extends Controlador<Usuario>{

    public UsuarioControlador() {
        super(Usuario.class);
    }
    
    public Usuario login(String login, String password){
        Usuario usuario = this.buscarPorId(login);
        if(usuario == null){
            return null;
        }else{
            String p2 = Encriptador.decrypt(usuario.getPassword());
            if(password.equals(p2)){
                return usuario;
            }else{
                return null;
            }
        }
    }
    
}
