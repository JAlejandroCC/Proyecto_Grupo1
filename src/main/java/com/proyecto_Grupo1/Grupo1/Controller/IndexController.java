package com.proyecto_Grupo1.Grupo1.Controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@Slf4j

public class IndexController
{
  
    @GetMapping("/")
   public String inicio()
   {
       return "Index";
   }
   
   @GetMapping ("GuiaDeUso")
   public String guia()
   {
       return "/GuiaDeUso/GuiaDeUso";
   }
   
   @GetMapping ("Catalogo")
   public String catalogo()
   {
       return "/Catalogo/catalogo";
   }
           
   
   
   
}
