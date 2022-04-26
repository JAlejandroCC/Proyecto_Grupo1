package com.proyecto_Grupo1.Grupo1.Controller;



import com.proyecto_Grupo1.Grupo1.service.ReservaReportService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
