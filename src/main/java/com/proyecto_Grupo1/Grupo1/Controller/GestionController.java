
package com.proyecto_Grupo1.Grupo1.Controller;

import com.proyecto_Grupo1.Grupo1.domain.Reserva;
import com.proyecto_Grupo1.Grupo1.service.ReservaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@Slf4j

public class GestionController {
    
    @Autowired
   public ReservaService clienteService;
    
   
   @GetMapping ("/listarReservas")
   public String listar (Model model){
       var clientes=clienteService.getClientes();
       model.addAttribute("clientes",clientes);
       return "/Gestion/Listar";
   }
   
         
  
   
   @GetMapping("/nuevoReserva")
   public String nuevoReserva(Reserva cliente){
       return "Agregar";
   }
   
   @PostMapping("/guardarReserva")
   public String guardarReserva(Reserva cliente)
   {
       clienteService.save(cliente);
       return "redirect:/";
   }
   
//   @GetMapping("/modificarReserva/{idcliente}")
//   public String modificarReserva(Reserva cliente, Model model)
//   {
//       cliente = clienteService.getCliente(cliente);
//       model.addAttribute("cliente",cliente);
//       return "/modificar/modificar";
//   }
//   
//   
   @GetMapping("/eliminarReserva/{idcliente}")
   public String eliminarReserva(Reserva cliente, Model model)
   {
       
       clienteService.delete(cliente);
       return "redirect:/";
   }
   
    
}
