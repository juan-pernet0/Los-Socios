package lossocios;


import dao.DAOCilindro;
import dao.DAOEmpresa;
import dao.DAOLlenado;
import dao.DAOPedido;
import dao.DAOPrestamo;
import dao.DAOPrestamoCilindro;
import dao.DAORol;
import dao.DAOUsuario;
import dto.DTOCilindro;
import dto.DTOEmpresa;
import dto.DTOPedido;
import dto.DTOUsuario;
import dto.DTOLlenado;
import dto.DTOPrestamo;
import dto.DTOPrestamoCilindro;
import dto.DTORol;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LosSocios {
    public static void main(String[]args) throws InstantiationException, SQLException, IllegalAccessException {
        
        
        
        //-USUARIO
                       
        //--Insertar un Usuario
        DAOUsuario daoUsuario = new DAOUsuario();
        //---1
        /*
        DTOUsuario dtoUsuario = new DTOUsuario();
        dtoUsuario.setDocumento("");
        dtoUsuario.setNombres("");
        dtoUsuario.setApellidos("");
        dtoUsuario.setDireccion("");
        dtoUsuario.setTelefono("");
        dtoUsuario.setEmail("");
        dtoUsuario.setPassword("");
        dtoUsuario.setRol("");
        
        daoUsuario.registrarUsuario(dtoUsuario);
        
        //---2
        
            */
        /*DTOUsuario dtoUsuario = new DTOUsuario("64", "Juan Ajdbhbd", "Sanchez lopez", "Cuatro Esquinas", "3543434552", "jdas@eg", "4653", "1");
        daoUsuario.registrarUsuario(dtoUsuario);

        
        //Imprimir El usuario Insertado
        System.out.println("Documento: " +dtoUsuario.getDocumento());
        System.out.println("Nombres: " +dtoUsuario.getNombres());
        System.out.println("Apellidos: " +dtoUsuario.getApellidos());
        System.out.println("Direccion: " +dtoUsuario.getDireccion());
        System.out.println("Telefono: " +dtoUsuario.getTelefono() );
        System.out.println("Email: " +dtoUsuario.getEmail());
        System.out.println("Password: " +dtoUsuario.getPassword());
        System.out.println("Rol: " +dtoUsuario.getRol()); 
        
        
        //--Actualizar un registro de un usuario
        //---1 
        DTOUsuario dtoUsuario = new DTOUsuario();
        dtoUsuario.setDocumento("10");
        dtoUsuario.setNombres("dfdf");
        dtoUsuario.setApellidos("wegfdfghr");
        dtoUsuario.setDireccion("sdfgfddfg");
        dtoUsuario.setTelefono("wefgfsd");
        dtoUsuario.setEmail("wefggfdf");
        dtoUsuario.setPassword("wdeffdsdf");
        dtoUsuario.setRol("4");
        daoUsuario.modificarUsuario(dtoUsuario);*/
        
        //---2
        /*DTOUsuario dtoUsuario = new DTOUsuario("64", "Hugo norrea", "Sanchez lopez", "Cuatro Esquinas", "3543434552", "jdas@eg", "4653", "1");
        daoUsuario.modificarUsuario(dtoUsuario);*/
        
        //--Eliminar un registro de un usuario (que no este ligado en otras tablas)
        
        //daoUsuario.eliminarUsuario("64");
             
        //--Buscar Usuario
        //---1
        /*DTOUsuario dtoUsuario = new DTOUsuario();
        dtoUsuario = daoUsuario.buscarUsuario("70");
        System.out.println("\nEl usuario buscado es: ");
        System.out.println("Documento: " +dtoUsuario.getDocumento());
        System.out.println("Nombres: " +dtoUsuario.getNombres());
        System.out.println("Apellidos: " +dtoUsuario.getApellidos());
        System.out.println("Direccion: " +dtoUsuario.getDireccion());
        System.out.println("Telefono: " +dtoUsuario.getTelefono() );
        System.out.println("Email: " +dtoUsuario.getEmail());
        System.out.println("Password: " +dtoUsuario.getPassword());
        System.out.println("Rol: " +dtoUsuario.getRol());*/
        
        //--mostrar todos los registros de una tabla
        /*List<DTOUsuario> listaUsuarios = daoUsuario.mostrarUsuarios();
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.print(listaUsuarios.get(i).getDocumento()+" ");
            System.out.print(listaUsuarios.get(i).getNombres()+" ");
            System.out.print(listaUsuarios.get(i).getApellidos()+" ");
            System.out.print(listaUsuarios.get(i).getDireccion()+" ");
            System.out.print(listaUsuarios.get(i).getTelefono()+" ");
            System.out.print(listaUsuarios.get(i).getEmail()+" ");
            System.out.print(listaUsuarios.get(i).getPassword()+" ");
            System.out.println(listaUsuarios.get(i).getRol()+" ");            
        }*/
        
        //-CILINDRO
        
        //--Insertar un Cilidro
        DAOCilindro daoCilindro = new DAOCilindro();
        
        //---1
        /*
        DTOCilindro dtoCilindro = new DTOCilindro(0,"3",100,334242233);
        daoCilindro.registrarCilindro(dtoCilindro);
        
        //--2
        DTOCilindro dtoCilindro = new DTOCilindro();
        
        dtoCilindro.setCodigo(4);
        dtoCilindro.setCapacidad(50);
        dtoCilindro.setPrecio(158737);
        dtoCilindro.setEmpresa(7);
        
        daoCilindro.registrarCilindro(dtoCilindro);*/
        
        //Imprimir los datos insertdos
        /*
        System.out.println("Codigo: " +dtoCilindro.getCodigo());
        System.out.println("Capacidad: " +dtoCilindro.getCapacidad());
        System.out.println("Precio: " +dtoCilindro.getPrecio());
        */       
       
        //--Actualizar un registro de un Cilindro
        /*DTOCilindro dtoCilindro = new DTOCilindro();
        dtoCilindro.setCodigo(0);
        dtoCilindro.setCapacidad(65);
        dtoCilindro.setPrecio(158737);
        dtoCilindro.setEmpresa("4");
        daoCilindro.modificarCilindro(dtoCilindro);*/
        
        //--Eliminar un registro de un lote de cilindros
        daoCilindro.eliminarCilindro(23);
        
        //--buscar un registro de un lote de cilindros
        
        /*DTOCilindro dtoCilindro = new DTOCilindro();
        dtoCilindro = daoCilindro.buscarCilindro(2);        
        System.out.println("El lote de cilindros buscado es: ");
        System.out.println("Codigo: " +dtoCilindro.getCodigo());
        System.out.println("Codigo de Empresa: " +dtoCilindro.getEmpresa());
        System.out.println("Capacidad: " +dtoCilindro.getCapacidad());
        System.out.println("Precio: " +dtoCilindro.getPrecio());*/
        
        //--mostrar todos los registros de la tabla tblcilindros
        /*System.out.println("Lista de cilindros: ");
        List<DTOCilindro> listaCilindros = daoCilindro.mostrarCilindro();
        for (int i = 0; i < listaCilindros.size(); i++) {
            System.out.print(listaCilindros.get(i).getCodigo()+" ");
            System.out.print(listaCilindros.get(i).getEmpresa()+" ");
            System.out.print(listaCilindros.get(i).getCapacidad()+" ");
            System.out.println(listaCilindros.get(i).getPrecio()+" ");
        }*/
        
        //-EMPRESA
        
        //--Insertar Empresa
        DAOEmpresa daoEmpresa = new DAOEmpresa();
        //---1
        /*
        DTOEmpresa dtoEmpresa = new DTOEmpresa("8","NorGas");
        daoEmpresa.registrarEmpresa(dtoEmpresa);
        
        //---2
        DTOEmpresa dtoEmpresa = new DTOEmpresa();
        
        dtoEmpresa.setNIT(4);
        dtoEmpresa.setNombre("Gases del Pacifico");
        daoEmpresa.registrarEmpresa(dtoEmpresa);*/
        
        //Imprimir los datos insertdos
        /*
        System.out.println("Codigo: " +dtoEmpresa.getNIT());
        System.out.println("Nombre: " +dtoEmpresa.getNombre() );
        
        
        //--Actualizar un registro de una empresa
        DTOEmpresa dtoEmpresa = new DTOEmpresa("","NebyefbrGas");
        daoEmpresa.modificarEmpresa(dtoEmpresa);
        
        
        //Eliminar una empresa
        daoEmpresa.eliminarEmpresa("8");
        
        
        //Buscar Empresa 
        DTOEmpresa dtoEmpresa = new DTOEmpresa();
        dtoEmpresa = daoEmpresa.buscarEmpresa("8");
        System.out.println("la empresa buscada es: ");
        System.out.println("Codigo: " +dtoEmpresa.getNIT());
        System.out.println("Codigo de Empresa: " +dtoEmpresa.getNombre());
        
        
        
        //mostrar todas las empresas
        System.out.println("Lista de cilindros: ");
        List<DTOEmpresa> listaEmpresas = daoEmpresa.mostrarEmpresa();
        for (int i = 0; i < listaEmpresas.size(); i++) {
            System.out.print(listaEmpresas.get(i).getNIT()+" ");
            System.out.println(listaEmpresas.get(i).getNombre()+" ");
        }
        */
        
        
        //-PEDIDO
        //--Insertar un pedido
        
        DAOPedido daoPedido = new DAOPedido();
        //---1
        /*DTOPedido dtoPedido = new DTOPedido(0,"7147752","70","2021/03/1 8:10:00", "2021/03/22 9:10:00", "Duvan Vergara", "10067877");//con llaves foranes es decir con documentos que obligatoriamente esten en tblusuario        
        daoPedido.registrarPedido(dtoPedido);
        DTOPedido dtoPedido1 = new DTOPedido();
        
        
        //---2
        DTOPedido dtoPedido = new DTOPedido();
        dtoPedido.setCodigo(0);
        dtoPedido.setDocCliente("10");
        dtoPedido.setDocEmpleado("19");
        dtoPedido.setFechapedido("2021/03/1 8:10:00");
        dtoPedido.setFechaentrega("2021/03/22 9:10:00");
        dtoPedido.setNombredestinatario("Duvan Vergara");
        dtoPedido.setDocumentodestinatario("123234");
        daoPedido.registrarPedido(dtoPedido);
        */
        //Imprimir datos insertados en tblpedido
        /*System.out.println("Codigo: " +dtoPedido.getCodigo());
        System.out.println("Fecha Pedido: " +dtoPedido.getFechapedido());
        System.out.println("Fecha Entrega : " +dtoPedido.getFechaentrega());
        System.out.println("Nombre del destianatrio: " +dtoPedido.getNombredestinatario());
        System.out.println("Documento del destinatario: " +dtoPedido.getDocumentodestinatario());*/
        
        
        //--Actualizar un pedido
        //---1
        /*DTOPedido dtoPedido = new DTOPedido(7,"7147752","70","2021/03/1 8:10:00", "2021/03/22 9:10:00", "Duvan Vergara", "10067877");//con llaves foranes es decir con documentos que obligatoriamente esten en tblusuario        
        daoPedido.modificarPedido(dtoPedido);
        
        
        //---2
        DTOPedido dtoPedido = new DTOPedido();
        dtoPedido.setCodigo(0);
        dtoPedido.setDocCliente("10");
        dtoPedido.setDocEmpleado("19");
        dtoPedido.setFechapedido("2021/03/1 8:10:00");
        dtoPedido.setFechaentrega("2021/03/22 9:10:00");
        dtoPedido.setNombredestinatario("Duvan Vergara");
        dtoPedido.setDocumentodestinatario("123234");
        daoPedido.modificarPedido(dtoPedido);
        
        //--Eliminar un pedido
        daoPedido.eliminarPedido(14);
        
        //--Buscar un pedido
        DTOPedido dtoPedido = new DTOPedido();
        dtoPedido = daoPedido.buscarPedido(7);
        System.out.println("\nEl pedido buscado es: ");
        System.out.println("Codigo : " +dtoPedido.getCodigo());
        System.out.println("Documento del cliente: " +dtoPedido.getDocCliente());
        System.out.println("Documento del empleado que va a llevar el pedido: " +dtoPedido.getDocEmpleado());
        System.out.println("Fecha en que se realizo el pedido: " +dtoPedido.getFechapedido());
        System.out.println("fecha de entrega del pedido: " +dtoPedido.getFechapedido());
        System.out.println("Nombre del destinatario: " +dtoPedido.getNombredestinatario());
        System.out.println("Documento del destinatario : " +dtoPedido.getDocumentodestinatario());
        
        
        //mostrar todos los pedidos
        
        List<DTOPedido> listaPedidos = daoPedido.mostrarPedidos();
        for (int i = 0; i < listaPedidos.size(); i++) {
            System.out.print(listaPedidos.get(i).getCodigo()+" ");
            System.out.print(listaPedidos.get(i).getDocCliente()+" ");
            System.out.print(listaPedidos.get(i).getDocEmpleado()+" ");
            System.out.print(listaPedidos.get(i).getFechapedido()+" ");
            System.out.print(listaPedidos.get(i).getFechapedido()+" ");
            System.out.print(listaPedidos.get(i).getNombredestinatario()+" ");
            System.out.println(listaPedidos.get(i).getDocumentodestinatario()+" ");         
        }
        */
        
        
        
        //-LLENADO
        //--Insertar un llenado
        DAOLlenado daoLlenado = new DAOLlenado();
        //---1
        /*DTOLlenado dtoLlenado = new DTOLlenado(0,"2021/09/25","3");        
        daoLlenado.registrarLlenado(dtoLlenado);
        
        //---2
        DTOLlenado dtoLlenado = new DTOLlenado();
        
        dtoLlenado.setCodigo(0);
        dtoLlenado.setFechallenado("2021/09/25");
        dtoLlenado.setCodEmpresa("3");

        daoLlenado.registrarLlenado(dtoLlenado);*/
        
        //Imprimir los datos insertados en la tabla tblllenado
        /*System.out.println("Fecha Llenado: " +dtoLlenado.getFechallenado());
        System.out.println("Codigo Empresa: " +dtoLlenado.getCodEmpresa());*/
        
        
        
        //--Actualizar un llenado
        //---1
        /*DTOLlenado dtoLlenado = new DTOLlenado(1,"2021/09/25","5");        
        daoLlenado.modificarLlenado(dtoLlenado);
        
        //---2
        DTOLlenado dtoLlenado = new DTOLlenado();
        
        dtoLlenado.setCodigo(2);
        dtoLlenado.setFechallenado("2021/09/25");
        dtoLlenado.setCodEmpresa("7");

        daoLlenado.modificarLlenado(dtoLlenado);
        
        
        //--Eliminar un llenado
        //daoLlenado.eliminarLlenado(2);
        
        //--buscar un llenado
        DTOLlenado dtoLlenado = new DTOLlenado();
        dtoLlenado = daoLlenado.buscarLlenado(1);
        System.out.println("El llenado buscado es: ");
        System.out.println("el Codigo : " +dtoLlenado.getCodigo());
        System.out.println("la fecha de llenado es : " +dtoLlenado.getFechallenado());
        System.out.println("la codiigo de la empresa es : " +dtoLlenado.getCodEmpresa());
        
        
        //--mostrar todos los llenados
        
        List<DTOLlenado> listaLlenados = daoLlenado.mostrarLlenados();
        for (int i = 0; i < listaLlenados.size(); i++) {
            System.out.print(listaLlenados.get(i).getCodigo()+" ");
            System.out.print(listaLlenados.get(i).getFechallenado()+" ");
            System.out.println(listaLlenados.get(i).getCodEmpresa()+" ");
        }
        */
        
        
        
        //-PRESTAMO
        //--Insertar Datos
        DAOPrestamo daoPrestamo = new DAOPrestamo();
        //---1
        
        /*DTOPrestamo dtoPrestamo = new DTOPrestamo(0,"10","40","2021/03/1 8:10:00", "2021/03/22 9:10:00", "Duvan Vergara", "10067877");       
        daoPrestamo.registrarPrestamo(dtoPrestamo);
       
        //---2
        
        DTOPrestamo dtoprestamo = new DTOPrestamo();
        dtoprestamo.setDocCliente("10");
        dtoprestamo.setDocEmpleado("60");
        dtoprestamo.setFechapedido("2021/03/1 8:10:00");
        dtoprestamo.setFechaentrega("2021/03/22 9:10:00");
        dtoprestamo.setNombredestinatario("Duvan Vergara");
        dtoprestamo.setDocumentodestianatario("10067877");
        daoPrestamo.registrarPrestamo(dtoprestamo);*/
        
        //Imprimir datos insertados en la tabla tblprestamo
        /*System.out.println("Documento del cliente que hizo el pedido: " +dtoPrestamo.getDocCliente());
        System.out.println("Documento del empleado que va a realizar el pedido: "+dtoPrestamo.getDocEmpleado());
        System.out.println("Fecha Pedido: " +dtoPrestamo.getFechapedido());
        System.out.println("Fecha Entrega : " +dtoPrestamo.getFechaentrega());
        System.out.println("Nombre del destianatrio: " +dtoPrestamo.getNombredestinatario());
        System.out.println("Documento del destinatario: " +dtoPrestamo.getDocumentodestianatario());
        */
        
        //--Actualizar datos de tblprestamo
        //---1
        /*DTOPrestamo dtoPrestamo = new DTOPrestamo(10,"10","7197752","2021/03/1 8:10:00", "2021/03/22 9:10:00", "Mari Konrado", "10067877");
        daoPrestamo.actualizarPrestamo(dtoPrestamo);
        

        //--2
        DTOPrestamo dtoprestamo = new DTOPrestamo();
        dtoprestamo.setCodigo(10);
        dtoprestamo.setDocCliente("10");
        dtoprestamo.setDocEmpleado("60");
        dtoprestamo.setFechapedido("2021/03/1 8:10:00");
        dtoprestamo.setFechaentrega("2021/03/22 9:10:00");
        dtoprestamo.setNombredestinatario("Duvan Vergara");
        dtoprestamo.setDocumentodestianatario("10067877");
        daoPrestamo.registrarPrestamo(dtoprestamo);*/
        
        
        //Eliminar un registro de un prestamo
        //daoPrestamo.eliminarPrestamo(6);
        
        //buscar un prestamo por el codigo del prestamo
        /*DTOPrestamo dtoprestamo = new DTOPrestamo();
        dtoprestamo = daoPrestamo.buscarPrestamo(17);
        System.out.println("El pedido busacdo tiene:");
        System.out.println("Codigo: "+dtoprestamo.getCodigo());
        System.out.println("Documento del cliente: "+dtoprestamo.getDocCliente());
        System.out.println("Documento del empleado: "+dtoprestamo.getDocEmpleado());
        System.out.println("Fecha en la que el cliente hizo el prestamo: "+dtoprestamo.getFechapedido());
        System.out.println("Fecha de entrega: "+dtoprestamo.getFechaentrega());
        System.out.println("Nombre del destinatario: "+dtoprestamo.getNombredestinatario());
        System.out.println("Documento del destinatario: "+dtoprestamo.getDocumentodestianatario());*/
        
        //--mostrar todos los registros de la tabla tblprestamo
        /*List<DTOPrestamo> listaPrestamos = daoPrestamo.mostrarPrestamos();
        for (int i = 0; i < listaPrestamos.size(); i++) {
            System.out.print(listaPrestamos.get(i).getCodigo()+" ");
            System.out.print(listaPrestamos.get(i).getDocCliente()+" ");
            System.out.print(listaPrestamos.get(i).getDocEmpleado()+" ");
            System.out.print(listaPrestamos.get(i).getFechapedido()+" ");
            System.out.print(listaPrestamos.get(i).getFechaentrega()+" ");
            System.out.print(listaPrestamos.get(i).getNombredestinatario()+" ");
            System.out.println(listaPrestamos.get(i).getDocumentodestianatario()+" ");            
        }*/
        
        
        
        //-Pretamo Cilindros
        DAOPrestamoCilindro daoPrestamoCilindro = new DAOPrestamoCilindro();
        //--Insertar un prestamo de un cilindro 
        //---1.
        /*DTOPrestamoCilindro dtoPrestamoCilindro = new DTOPrestamoCilindro();
        dtoPrestamoCilindro.setCodigoPrestamo(18);
        dtoPrestamoCilindro.setCodCilindro(7);
        dtoPrestamoCilindro.setCantidad(5);
        dtoPrestamoCilindro.setPrecio(12000);
        daoPrestamoCilindro.registrarPrestamoCilindro(dtoPrestamoCilindro);
        
        //---2
        
        DTOPrestamoCilindro dtoPrestamoCilindro = new DTOPrestamoCilindro(10,4,3,40000);
        daoPrestamoCilindro.registrarPrestamoCilindro(dtoPrestamoCilindro);*/
        
        //--Actualizar un prestamo de un cilindro
        //---1
        /*DTOPrestamoCilindro dtoPrestamoCilindro = new DTOPrestamoCilindro();
        dtoPrestamoCilindro.setCodigoPrestamo(18);
        dtoPrestamoCilindro.setCodCilindro(7);
        dtoPrestamoCilindro.setCantidad(8);
        dtoPrestamoCilindro.setPrecio(12000);
        daoPrestamoCilindro.modificarPrestamoCilindro(dtoPrestamoCilindro);
        
        //---2
        
        DTOPrestamoCilindro dtoPrestamoCilindro = new DTOPrestamoCilindro(19,11,2,18743);
        daoPrestamoCilindro.modificarPrestamoCilindro(dtoPrestamoCilindro);*/

        //Eliminar un registro de tblprestamocilindros
        //daoPrestamoCilindro.eliminarPrestamoCilindro(18, 11);
        
        //buscar un solo registro por codigo de prestamo y codigo de cilindro
        /*DTOPrestamoCilindro dtoPrestamoCilindro = new DTOPrestamoCilindro();
        dtoPrestamoCilindro = daoPrestamoCilindro.buscar1PrestamoCilindro(19, 11);
        System.out.println("El codigo del prestamo es: "+dtoPrestamoCilindro.getCodigoPrestamo());
        System.out.println("El codigo del cilindro es: "+dtoPrestamoCilindro.getCodCilindro());
        System.out.println("la cantidad de cilindros prestados es: "+dtoPrestamoCilindro.getCantidad());
        System.out.println("El precio de los  prestamo es: "+dtoPrestamoCilindro.getPrecio());
        
        
        //mostrar todos los registros de tblprestamocilindros que pertenescan al mismo prestmo
        List<DTOPrestamoCilindro> listaPrestamoCilindro = daoPrestamoCilindro.mostrarPrestamoCilindroxCodigoPrestamo(18);
        for (int i = 0; i < listaPrestamoCilindro.size(); i++) {
            System.out.print(listaPrestamoCilindro.get(i).getCodigoPrestamo()+" ");
            System.out.print(listaPrestamoCilindro.get(i).getCodCilindro()+" ");
            System.out.print(listaPrestamoCilindro.get(i).getCantidad()+" ");
            System.out.println(listaPrestamoCilindro.get(i).getPrecio()+" ");           
        }
        
        
        //mostrar todos los registros de tblprestamocilindros
        System.out.println("registros de la tabla tblprestamocilindros");
        List<DTOPrestamoCilindro> listaPrestamoCilindro = daoPrestamoCilindro.listaPrestamoCilindro();
        for (int i = 0; i < listaPrestamoCilindro.size(); i++) {
            System.out.print(listaPrestamoCilindro.get(i).getCodigoPrestamo()+" ");
            System.out.print(listaPrestamoCilindro.get(i).getCodCilindro()+" ");
            System.out.print(listaPrestamoCilindro.get(i).getCantidad()+" ");
            System.out.println(listaPrestamoCilindro.get(i).getPrecio()+" ");           
        }*/
        
        //-ROL
        //--Insertar un Rol 
        //---1.
        
        DAORol daoRol = new DAORol();
         /*DTORol dtoRol = new DTORol();
               
        dtoRol.setRol("9");
        dtoRol.setNombres("Admin");
        
        daoRol.registrarRol(dtoRol);*/
        
        //2.
        /*
        
        DTORol dtoRol = new DTORol("3","verrv");
        daoRol.registrarRol(dtoRol);*/
        
        //Imprimir datos insertados en la tabla tblRol
       /* System.out.println("Numero de rol: "+dtoRol.getRol());
        System.out.println("El nombre del rol es: "+dtoRol.getNombres());*/
       
       
       //--Actualizar un prestamo de un cilindro
       //---1.
       /*DTORol dtoRol = new DTORol("4","rayogas");
       daoRol.modificarRol(dtoRol);
       //---2.
       DTORol dtoRol = new DTORol();
               
        dtoRol.setRol("1");
        dtoRol.setNombres("Admin");
        
        daoRol.modificarRol(dtoRol);
       
       //--eliminar rol
       //daoRol.eliminarUsuario("3");
       
       //mostrar un rol
       DTORol dtoRol = new DTORol();
       dtoRol = daoRol.buscarRol("4");
       System.out.println("El codigo del rol es: "+dtoRol.getRol());
       System.out.println("El nombre del rol es: "+dtoRol.getNombres());
       
       //mostrar todos los roles
        System.out.println("registros de la tabla Roles");
        List<DTORol> listaRoles = daoRol.mostrarRoles();
        for (int i = 0; i < listaRoles.size(); i++) {
            System.out.print(listaRoles.get(i).getRol()+" ");
            System.out.println(listaRoles.get(i).getNombres()+" ");         
        }*/  
   }
    
}
