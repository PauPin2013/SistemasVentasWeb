    
package controlador;

import config.GenerarSerie;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Venta;
import modelo.VentaDAO;

public class Controlador extends HttpServlet {

    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado em = new Empleado();
    ProductoDAO pdao = new ProductoDAO();
    Producto prod = new Producto();
    ClienteDAO cdao = new ClienteDAO();
    Cliente cliente = new Cliente();
    int ide;
    
    
    Venta vent=new Venta();
    List<Venta>lista=new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    
    String numeroserie;
    VentaDAO vdao=new VentaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List<Cliente> lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nombres = request.getParameter("txtNombres");
                    String direccion = request.getParameter("txtDireccion");
                    String estado = request.getParameter("txtEstado");

                    cliente.setDni(dni);
                    cliente.setNombres(nombres);
                    cliente.setDireccion(direccion);
                    cliente.setEstado(estado);

                    cdao.agregar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cdao.listarId(ide);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dniA = request.getParameter("txtDni");
                    String nombresA = request.getParameter("txtNombres");
                    String direccionA = request.getParameter("txtDireccion");
                    String estadoA = request.getParameter("txtEstado");

                    cliente.setDni(dniA);
                    cliente.setNombres(nombresA);
                    cliente.setDireccion(direccionA);
                    cliente.setEstado(estadoA);
                    cliente.setIdCliente(ide);

                    cdao.actualizar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String nombres = request.getParameter("txtNombres");
                    double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String estado = request.getParameter("txtEstado");

                    prod.setNombres(nombres);
                    prod.setPrecio(precio);
                    prod.setStock(stock);
                    prod.setEstado(estado);

                    pdao.agregar(prod);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Producto producto = pdao.listarId(ide);
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom = request.getParameter("txtNombres");
                    double precioA = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stockA = Integer.parseInt(request.getParameter("txtStock"));
                    String estadoA = request.getParameter("txtEstado");

                    prod.setNombres(nom);
                    prod.setPrecio(precioA);
                    prod.setStock(stockA);
                    prod.setEstado(estadoA);
                    prod.setIdProducto(ide);
                    pdao.actualizar(prod);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        if (menu.equals("NuevaVenta")) {
            vent=new Venta();
            switch(accion){
                case "BuscarCliente":
                    String dni=request.getParameter("codigocliente");
                    cliente.setDni(dni);
                    cliente=cdao.buscar(dni);
                    request.setAttribute("cliente", cliente);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "BuscarProducto":
                    int id=Integer.parseInt(request.getParameter("codigoproducto"));
                    prod=pdao.listarId(id);
                    request.setAttribute("cliente", cliente);
                    request.setAttribute("producto", prod);
                    request.setAttribute("lista",lista);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "Agregar":
                    request.setAttribute("cliente", cliente);
                    totalPagar=0.0;
                    item = item +1;
                    cod=prod.getIdProducto();
                    descripcion=request.getParameter("nomproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant=Integer.parseInt(request.getParameter("cant"));
                    subtotal=precio*cant;
                    vent = new Venta();
                    vent.setItem(item);
                    vent.setIdproducto(cod);
                    vent.setDescripcionP(descripcion);
                    vent.setPrecio(precio);
                    vent.setCantidad(cant);
                    vent.setSubtotal(subtotal);
                    lista.add(vent);
                    vdao.guardarVenta(vent);
                    for(int i=0;i<lista.size();i++){
                        totalPagar=totalPagar+lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar",totalPagar);
                    request.setAttribute("lista",lista);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "GenerarVenta":
                    //Actualizacion del stock
                    for(int i=0;i<lista.size();i++){
                        Producto pr=new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        ProductoDAO aO=new ProductoDAO();
                        pr=aO.buscar(idproducto);
                        int sac=pr.getStock()-cantidad;
                        aO.actualizarstock(idproducto, sac);
                    }
                    //guardar venta
                    vent.setIdcliente(cliente.getIdCliente());
                    vent.setIdempleado(2);
                    vent.setNumserie(numeroserie);
                    vent.setFecha("2019-06-14");
                    vent.setMonto(totalPagar);
                    vent.setEstado("1");
                    vdao.guardarVenta(vent);
                    //guardar detalle de venta
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for(int i=0;i<lista.size();i++){
                        vent=new Venta();
                        vent.setId(idv);
                        vent.setIdproducto(lista.get(i).getIdproducto());
                        vent.setCantidad(lista.get(i).getCantidad());
                        vent.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleVentas(vent);
                        
                    }
                    request.setAttribute("nserie", numeroserie);
                    break;                
                
                default:
                    numeroserie=vdao.GenerarSerie();
                    if(numeroserie==null){
                        numeroserie="00000001";
                        request.setAttribute("nserie", numeroserie);
                    }else{
                        int incrementar=Integer.parseInt(numeroserie);
                        GenerarSerie gs= new GenerarSerie();
                        numeroserie=gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
