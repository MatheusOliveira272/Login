package br.com.unincor.web;

import br.com.unincor.web.model.dao.ClienteDao;
import br.com.unincor.web.model.domain.Cliente;
import br.com.unincor.web.view.utils.Criptografar;


public class main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(null, "Matheus", "matheus@gmail.com", "123654789", Criptografar.encryp("123"), Boolean.TRUE);
        ClienteDao clienteDao = new ClienteDao();
              clienteDao.save(cliente);

    }
}
