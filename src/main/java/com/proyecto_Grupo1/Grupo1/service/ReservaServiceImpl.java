
package com.proyecto_Grupo1.Grupo1.service;
import com.proyecto_Grupo1.Grupo1.dao.ReservaDao;
import com.proyecto_Grupo1.Grupo1.domain.Reserva;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ReservaServiceImpl implements ReservaService {
    
    @Autowired
    private ReservaDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> getClientes() {
        return (List<Reserva>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Reserva cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Reserva cliente) {
        clienteDao.delete(cliente);   
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva getCliente(Reserva cliente) {
        return clienteDao.findById(cliente.getIdcliente()).orElse(null);
    }
    
}

