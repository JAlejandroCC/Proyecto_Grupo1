
package com.proyecto_Grupo1.Grupo1.service;
import com.proyecto_Grupo1.Grupo1.domain.Reserva;
import java.util.List;


public interface ReservaService
{
    public List<Reserva> getClientes();
    
    public void save(Reserva cliente);
    
    public void delete(Reserva cliente);
    
    public Reserva getCliente(Reserva cliente);
}
