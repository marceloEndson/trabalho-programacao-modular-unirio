/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acessodados;

import java.util.List;
import negocio.Vendedor;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author MCE
 */
public class VendedoresDAOTest {

    @Test
    public void VendedoresDAOTest(){
        AbstractArquivosDAO<Vendedor> vendedorDAO = new VendedoresDAO();
        List<Vendedor> vendedores = vendedorDAO.getObjetos("test/acessodados/dadosDeVendedores.txt");
        
        assertEquals(2,vendedores.size());
        
        assertEquals(new Vendedor(0020, "MANOEL DA SILVA", 1).getCodigo(), vendedores.get(0).getCodigo());
        assertEquals(new Vendedor(0021, "JOANA ANGELICA", 2).getCodigo(), vendedores.get(1).getCodigo());
    }
}
