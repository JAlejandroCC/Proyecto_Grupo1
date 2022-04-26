
package com.proyecto_Grupo1.Grupo1.Controller;

import com.proyecto_Grupo1.Grupo1.domain.Reserva;
import com.proyecto_Grupo1.Grupo1.service.ReservaReportService;
import com.proyecto_Grupo1.Grupo1.service.ReservaService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@Slf4j

public class GestionController {
    
    @Autowired
   public ReservaService clienteService;
    
     @Autowired
    private ReservaReportService reservaReportService;
    
   
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
   
    @GetMapping("/modificarReserva{idcliente}")
   public String modificarReserva(Reserva cliente, Model model)
   {
       cliente = clienteService.getCliente(cliente);
       model.addAttribute("cliente",cliente);
       return "/Gestion/modifica";
   }
   
   
 
   
   @GetMapping("/eliminarReserva/{idcliente}")
   public String eliminarReserva(Reserva cliente, Model model)
   {
       
       clienteService.delete(cliente);
       return "redirect:/";
   }
   
   @GetMapping ("cambio")
   public String cambio()
   {
       return "/Gestion/cambio";
   }
   
   @GetMapping(value = "/cliente/ReporteReservas", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(reservaReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
   
  
   
 
   
    
}
