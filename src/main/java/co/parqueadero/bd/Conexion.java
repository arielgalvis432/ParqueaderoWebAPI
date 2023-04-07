/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.parqueadero.bd;

import co.parqueadero.modelos.Cliente;
import co.parqueadero.modelos.Cubiculo;
import co.parqueadero.modelos.Factura;
import co.parqueadero.modelos.FormaPago;
import co.parqueadero.modelos.Parqueadero;
import co.parqueadero.modelos.Parqueo;
import co.parqueadero.modelos.Rol;
import co.parqueadero.modelos.Vehiculo;
import co.parqueadero.modelos.VehiculoTipo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felix Linares
 */
public class Conexion {

    // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "parqueadero";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con
    // "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database
            + "?allowPublicKeyRetrieval=true&useSSL=false";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public List<VehiculoTipo> obtenerVehiculosTipos() {
        List<VehiculoTipo> vehiculosTipos = new ArrayList<>();

        try {
            final String SQL = "SELECT * FROM vehiculo_tipo";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                VehiculoTipo vehiculoTipo = new VehiculoTipo();
                vehiculoTipo.setId(rst.getInt("id"));
                vehiculoTipo.setNombre(rst.getString("nombre"));
                vehiculoTipo.setTarifa(rst.getDouble("tarifa"));

                vehiculosTipos.add(vehiculoTipo);
            }
        } catch (Exception e) {
        }

        return vehiculosTipos;
    }

    public List<Rol> obtenerRoles() {
        List<Rol> roles = new ArrayList<>();

        try {
            final String SQL = "SELECT * FROM rol";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Rol rol = new Rol();
                rol.setId(rst.getInt("id"));
                rol.setNombre(rst.getString("nombre"));

                roles.add(rol);
            }
        } catch (Exception e) {
        }

        return roles;
    }

    public List<FormaPago> obtenerFormasPago() {
        List<FormaPago> lista = new ArrayList<>();

        try {
            final String SQL = "SELECT * FROM forma_pago";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                FormaPago formaPago = new FormaPago();
                formaPago.setId(rst.getInt("id"));
                formaPago.setNombre(rst.getString("nombre"));

                lista.add(formaPago);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public List<Cliente> obtenerClientes() {
        List<Cliente> lista = new ArrayList<>();

        try {
            final String SQL = "SELECT C.*, P.nombre FROM cliente C INNER JOIN parqueadero P ON C.parqueadero_id = P.id";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("id"));
                cliente.setNombreCompleto(rst.getString("nombre_completo"));
                cliente.setEmail(rst.getString("email"));
                cliente.setDocumento(rst.getString("documento"));
                cliente.setTelefono(rst.getString("telefono"));
                cliente.setParqueaderoId(rst.getInt("parqueadero_id"));
                cliente.setNombreParqueadero(rst.getString("nombre"));

                lista.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public Cliente obtenerClientePorId(int id) {
        try {
            final String SQL = "SELECT * FROM cliente WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rst = pstmt.executeQuery();

            if (rst.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(id);
                cliente.setNombreCompleto(rst.getString("nombre_completo"));
                cliente.setEmail(rst.getString("email"));
                cliente.setDocumento(rst.getString("documento"));
                cliente.setTelefono(rst.getString("telefono"));
                cliente.setParqueaderoId(rst.getInt("parqueadero_id"));

                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    public Cliente obtenerClientePorDocumento(String documento) {
        try {
            final String SQL = "SELECT * FROM cliente WHERE documento = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setString(1, documento);

            ResultSet rst = pstmt.executeQuery();

            if (rst.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("id"));
                cliente.setNombreCompleto(rst.getString("nombre_completo"));
                cliente.setEmail(rst.getString("email"));
                cliente.setDocumento(documento);
                cliente.setTelefono(rst.getString("telefono"));
                cliente.setParqueaderoId(rst.getInt("parqueadero_id"));

                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    public Cliente crearCliente(Cliente cliente) {
        try {
            final String SQL = "INSERT INTO cliente VALUES (DEFAULT, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, cliente.getNombreCompleto());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getDocumento());
            pstmt.setString(4, cliente.getTelefono());
            pstmt.setInt(5, cliente.getParqueaderoId());

            pstmt.executeUpdate();

            ResultSet rst = pstmt.getGeneratedKeys();

            if (rst.next()) {
                cliente.setId(rst.getInt(1));

                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    /**
     * Actualiza un cliente en la base de datos
     * @param cliente Objeto cliente con los datos a actualizar
     * 
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    public boolean actualizarCliente(Cliente cliente) {
        try {
            final String SQL = "UPDATE cliente SET nombre_completo = ?, email = ?, documento = ?, telefono = ?, parqueadero_id = ? WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setString(1, cliente.getNombreCompleto());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getDocumento());
            pstmt.setString(4, cliente.getTelefono());
            pstmt.setInt(5, cliente.getParqueaderoId());
            pstmt.setInt(6, cliente.getId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return false;
    }

    public List<Vehiculo> obtenerVehiculos() {
        List<Vehiculo> lista = new ArrayList<>();

        try {
            final String SQL = "SELECT V.*, C.nombre_completo, VT.nombre FROM vehiculo V INNER JOIN cliente C ON v.cliente_id = C.id INNER JOIN vehiculo_tipo VT ON v.vehiculo_tipo_id = VT.id";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(rst.getInt("id"));
                vehiculo.setPlaca(rst.getString("placa"));
                vehiculo.setMarca(rst.getString("marca"));
                vehiculo.setColor(rst.getString("color"));
                vehiculo.setClienteId(rst.getInt("cliente_id"));
                vehiculo.setTipoVehiculoId(rst.getInt("vehiculo_tipo_id"));
                vehiculo.setNombreCliente(rst.getString("nombre_completo"));
                vehiculo.setNombreTipoVehiculo(rst.getString("nombre"));

                lista.add(vehiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public Vehiculo obtenerVehiculoPorId(int id) {
        try {
            final String SQL = "SELECT * FROM vehiculo WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rst = pstmt.executeQuery();

            if (rst.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(id);
                vehiculo.setPlaca(rst.getString("placa"));
                vehiculo.setMarca(rst.getString("marca"));
                vehiculo.setColor(rst.getString("color"));
                vehiculo.setClienteId(rst.getInt("cliente_id"));
                vehiculo.setTipoVehiculoId(rst.getInt("vehiculo_tipo_id"));

                return vehiculo;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    public Vehiculo obtenerVehiculoPorPlaca(String placa) {
        try {
            final String SQL = "SELECT * FROM vehiculo WHERE placa = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setString(1, placa);

            ResultSet rst = pstmt.executeQuery();

            if (rst.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(rst.getInt("id"));
                vehiculo.setPlaca(placa);
                vehiculo.setMarca(rst.getString("marca"));
                vehiculo.setColor(rst.getString("color"));
                vehiculo.setClienteId(rst.getInt("cliente_id"));
                vehiculo.setTipoVehiculoId(rst.getInt("vehiculo_tipo_id"));

                return vehiculo;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        try {
            final String SQL = "INSERT INTO vehiculo VALUES (DEFAULT, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, vehiculo.getPlaca());
            pstmt.setString(2, vehiculo.getMarca());
            pstmt.setString(3, vehiculo.getColor());
            pstmt.setInt(4, vehiculo.getClienteId());
            pstmt.setInt(5, vehiculo.getTipoVehiculoId());

            pstmt.executeUpdate();

            ResultSet rst = pstmt.getGeneratedKeys();

            if (rst.next()) {
                vehiculo.setId(rst.getInt(1));

                return vehiculo;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    public List<Cubiculo> obtenerCubiculos() {
        List<Cubiculo> lista = new ArrayList<>();

        try {
            final String SQL = "SELECT * FROM cubiculo";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Cubiculo cubiculo = new Cubiculo();

                cubiculo.setId(rst.getInt("id"));
                cubiculo.setNombre(rst.getString("nombre"));
                cubiculo.setDisponible(rst.getInt("disponible"));

                lista.add(cubiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public Cubiculo obtenerCubiculoPorId(int id) {
        try {
            final String SQL = "SELECT * FROM cubiculo WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rst = pstmt.executeQuery();

            if (rst.next()) {
                Cubiculo cubiculo = new Cubiculo();

                cubiculo.setId(rst.getInt("id"));
                cubiculo.setNombre(rst.getString("nombre"));
                cubiculo.setDisponible(rst.getInt("disponible"));

                return cubiculo;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    /**
     * Recupera todos los datos de la tabla parqueo.
     */
    public List<Parqueo> obtenerParqueos() {
        List<Parqueo> lista = new ArrayList<>();

        try {
            final String SQL = "SELECT * FROM parqueo";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Parqueo parqueo = new Parqueo();

                parqueo.setId(rst.getInt("id"));
                parqueo.setFechaInicio(rst.getString("fecha_inicio"));
                parqueo.setFechaFinal(rst.getString("fecha_final"));
                parqueo.setHoraInicio(rst.getString("hora_inicio"));
                parqueo.setHoraFinal(rst.getString("hora_final"));
                parqueo.setVehiculoId(rst.getInt("vehiculo_id"));
                parqueo.setFacturaId(rst.getInt("factura_id"));
                parqueo.setCubiculoId(rst.getInt("cubiculo_id"));
                parqueo.setReserva(rst.getInt("reserva"));
                parqueo.setEstadoReserva(rst.getInt("estado_reserva"));

                lista.add(parqueo);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    /**
     * Recuperar el parqueo por id.
     * 
     * @param id del parqueo.
     * @return parqueo.
     */
    public Parqueo obtenerParqueoPorId(int id) {
        try {
            final String SQL = "SELECT * FROM parqueo WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rst = pstmt.executeQuery();

            if (rst.next()) {
                Parqueo parqueo = new Parqueo();

                parqueo.setId(rst.getInt("id"));
                parqueo.setFechaInicio(rst.getString("fecha_inicio"));
                parqueo.setFechaFinal(rst.getString("fecha_final"));
                parqueo.setHoraInicio(rst.getString("hora_inicio"));
                parqueo.setHoraFinal(rst.getString("hora_final"));
                parqueo.setVehiculoId(rst.getInt("vehiculo_id"));
                parqueo.setFacturaId(rst.getInt("factura_id"));
                parqueo.setCubiculoId(rst.getInt("cubiculo_id"));
                parqueo.setReserva(rst.getInt("reserva"));
                parqueo.setEstadoReserva(rst.getInt("estado_reserva"));

                return parqueo;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    /**
     * Recuperar el parqueo por vehiculo id.
     * 
     * @param ID del vehiculo.
     * @return parqueo.
     */
    public List<Parqueo> obtenerParqueosPorVehiculoId(int id) {
        List<Parqueo> lista = new ArrayList<>();

        try {
            final String SQL = "SELECT * FROM parqueo WHERE vehiculo_id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Parqueo parqueo = new Parqueo();

                parqueo.setId(rst.getInt("id"));
                parqueo.setFechaInicio(rst.getString("fecha_inicio"));
                parqueo.setFechaFinal(rst.getString("fecha_final"));
                parqueo.setHoraInicio(rst.getString("hora_inicio"));
                parqueo.setHoraFinal(rst.getString("hora_final"));
                parqueo.setVehiculoId(rst.getInt("vehiculo_id"));
                parqueo.setFacturaId(rst.getInt("factura_id"));
                parqueo.setCubiculoId(rst.getInt("cubiculo_id"));
                parqueo.setReserva(rst.getInt("reserva"));
                parqueo.setEstadoReserva(rst.getInt("estado_reserva"));

                lista.add(parqueo);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    /**
     * Recuperar el parqueo por vehiculo id.
     * 
     * @param ID del vehiculo.
     * @return parqueo.
     */
    public List<Parqueo> obtenerParqueosPorVehiculoPlaca(String placa) {
        List<Parqueo> lista = new ArrayList<>();

        try {
            final String SQL = "SELECT * FROM parqueo WHERE placa = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setString(1, placa);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Parqueo parqueo = new Parqueo();

                parqueo.setId(rst.getInt("id"));
                parqueo.setFechaInicio(rst.getString("fecha_inicio"));
                parqueo.setFechaFinal(rst.getString("fecha_final"));
                parqueo.setHoraInicio(rst.getString("hora_inicio"));
                parqueo.setHoraFinal(rst.getString("hora_final"));
                parqueo.setVehiculoId(rst.getInt("vehiculo_id"));
                parqueo.setFacturaId(rst.getInt("factura_id"));
                parqueo.setCubiculoId(rst.getInt("cubiculo_id"));
                parqueo.setReserva(rst.getInt("reserva"));
                parqueo.setEstadoReserva(rst.getInt("estado_reserva"));

                lista.add(parqueo);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    /**
     * Buscar parqueo por ID de cubiculo.
     * 
     * @param ID del cubiculo.
     * @return parqueo.
     */
    public List<Parqueo> obtenerParqueosPorCubiculoId(int id) {
        List<Parqueo> lista = new ArrayList<>();

        try {
            final String SQL = "SELECT * FROM parqueo WHERE cubiculo_id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Parqueo parqueo = new Parqueo();

                parqueo.setId(rst.getInt("id"));
                parqueo.setFechaInicio(rst.getString("fecha_inicio"));
                parqueo.setFechaFinal(rst.getString("fecha_final"));
                parqueo.setHoraInicio(rst.getString("hora_inicio"));
                parqueo.setHoraFinal(rst.getString("hora_final"));
                parqueo.setVehiculoId(rst.getInt("vehiculo_id"));
                parqueo.setFacturaId(rst.getInt("factura_id"));
                parqueo.setCubiculoId(rst.getInt("cubiculo_id"));
                parqueo.setReserva(rst.getInt("reserva"));
                parqueo.setEstadoReserva(rst.getInt("estado_reserva"));

                lista.add(parqueo);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    /**
     * Crear un nuevo parqueo.
     * 
     * @param parqueo a crear.
     * @return parqueo creado.
     */
    public Parqueo crearParqueo(Parqueo parqueo) {
        try {
            final String SQL = "INSERT INTO parqueo (fecha_inicio, hora_inicio, vehiculo_id, cubiculo_id) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, parqueo.getFechaInicio());
            pstmt.setString(2, parqueo.getHoraInicio());
            pstmt.setInt(3, parqueo.getVehiculoId());
            pstmt.setInt(4, parqueo.getCubiculoId());

            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                parqueo.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return parqueo;
    }

    /**
     * Actualizar un parqueo por ID.
     * 
     * @param Parqueo a actualizar.
     * @return parqueo actualizado.
     */
    public Parqueo actualizarParqueo(Parqueo parqueo) {
        try {
            final String SQL = "UPDATE parqueo SET fecha_inicio = ?, fecha_final = ?, hora_inicio = ?, hora_final = ?, vehiculo_id = ?, factura_id = ?, cubiculo_id = ? WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setString(1, parqueo.getFechaInicio());
            pstmt.setString(2, parqueo.getFechaFinal());
            pstmt.setString(3, parqueo.getHoraInicio());
            pstmt.setString(4, parqueo.getHoraFinal());
            pstmt.setInt(5, parqueo.getVehiculoId());
            pstmt.setInt(6, parqueo.getFacturaId());
            pstmt.setInt(7, parqueo.getCubiculoId());
            pstmt.setInt(8, parqueo.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return parqueo;
    }

    /**
     * Crear una factura (fechaHora, impuesto, total, usuarioId, formaPagoId).
     * 
     * @param factura a crear.
     * @param factura creada.
     */
    public Factura crearFactura(Factura factura) {
        try {
            final String SQL = "INSERT INTO factura (fecha_hora, impuesto, total, usuario_id, forma_pago_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, factura.getFechaHora());
            pstmt.setInt(2, factura.getImpuesto());
            pstmt.setDouble(3, factura.getTotal());
            pstmt.setInt(4, factura.getUsuarioId());
            pstmt.setInt(5, factura.getFormaPagoId());

            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                factura.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return factura;
    }

    /**
     * Actualizar una factura por ID.
     * 
     * @param factura a actualizar.
     * @return factura actualizada.
     */
    public Factura actualizarFactura(Factura factura) {
        try {
            final String SQL = "UPDATE factura SET fecha_hora = ?, impuesto = ?, total = ?, usuario_id = ?, forma_pago_id = ? WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setString(1, factura.getFechaHora());
            pstmt.setInt(2, factura.getImpuesto());
            pstmt.setDouble(3, factura.getTotal());
            pstmt.setInt(4, factura.getUsuarioId());
            pstmt.setInt(5, factura.getFormaPagoId());
            pstmt.setInt(6, factura.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return factura;
    }

    /**
     * Obtener todas las facturas.
     * 
     * @return lista de facturas.
     */
    public List<Factura> obtenerFacturas() {
        List<Factura> lista = new ArrayList<>();

        try {
            final String SQL = "SELECT * FROM factura";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Factura factura = new Factura();

                factura.setId(rst.getInt("id"));
                factura.setFechaHora(rst.getString("fecha_hora"));
                factura.setImpuesto(rst.getInt("impuesto"));
                factura.setTotal(rst.getDouble("total"));
                factura.setUsuarioId(rst.getInt("usuario_id"));
                factura.setFormaPagoId(rst.getInt("forma_pago_id"));

                lista.add(factura);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    /**
     * Obtener una factura por ID.
     * 
     * @param id de la factura.
     * @return factura.
     */
    public Factura obtenerFacturaPorId(int id) {
        Factura factura = null;

        try {
            final String SQL = "SELECT * FROM factura WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                factura = new Factura();
                factura.setId(rst.getInt("id"));
                factura.setFechaHora(rst.getString("fecha_hora"));
                factura.setImpuesto(rst.getInt("impuesto"));
                factura.setTotal(rst.getDouble("total"));
                factura.setUsuarioId(rst.getInt("usuario_id"));
                factura.setFormaPagoId(rst.getInt("forma_pago_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return factura;
    }

    /*
     * Obtener todas las facturas a partir del ID del usuario.
     * 
     * @param id del usuario.
     * 
     * @return lista de facturas.
     */
    public List<Factura> obtenerFacturasPorUsuarioId(int id) {
        List<Factura> lista = new ArrayList<>();

        try {
            final String SQL = "SELECT * FROM factura WHERE usuario_id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Factura factura = new Factura();

                factura.setId(rst.getInt("id"));
                factura.setFechaHora(rst.getString("fecha_hora"));
                factura.setImpuesto(rst.getInt("impuesto"));
                factura.setTotal(rst.getDouble("total"));
                factura.setUsuarioId(rst.getInt("usuario_id"));
                factura.setFormaPagoId(rst.getInt("forma_pago_id"));

                lista.add(factura);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    /**
     * Crear un parqueadero (nombre, nit, direccion, telefono).
     * 
     * @param parqueadero a crear.
     * @param parqueadero creado.
     */
    public Parqueadero crearParqueadero(Parqueadero parqueadero) {
        try {
            final String SQL = "INSERT INTO parqueadero (nombre, nit, direccion, telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, parqueadero.getNombre());
            pstmt.setString(2, parqueadero.getNit());
            pstmt.setString(3, parqueadero.getDireccion());
            pstmt.setString(4, parqueadero.getTelefono());

            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                parqueadero.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return parqueadero;
    }

    /**
     * Obtener todos los parqueaderos.
     * 
     * @return lista de parqueaderos.
     */
    public List<Parqueadero> obtenerParqueaderos() {
        List<Parqueadero> lista = new ArrayList<>();

        try {
            final String SQL = "SELECT * FROM parqueadero";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                Parqueadero parqueadero = new Parqueadero();

                parqueadero.setId(rst.getInt("id"));
                parqueadero.setNombre(rst.getString("nombre"));
                parqueadero.setNit(rst.getString("nit"));
                parqueadero.setDireccion(rst.getString("direccion"));
                parqueadero.setTelefono(rst.getString("telefono"));

                lista.add(parqueadero);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    /**
     * Obtener un parqueadero por ID.
     * 
     * @param ID del parqueadero.
     * @return parqueadero.
     */
    public Parqueadero obtenerParqueaderoPorId(int id) {
        Parqueadero parqueadero = null;

        try {
            final String SQL = "SELECT * FROM parqueadero WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                parqueadero = new Parqueadero();
                parqueadero.setId(rst.getInt("id"));
                parqueadero.setNombre(rst.getString("nombre"));
                parqueadero.setNit(rst.getString("nit"));
                parqueadero.setDireccion(rst.getString("direccion"));
                parqueadero.setTelefono(rst.getString("telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return parqueadero;
    }

    /**
     * Obtener un parqueadero por NIT.
     * 
     * @param NIT del parqueadero.
     * @return parqueadero.
     */
    public Parqueadero obtenerParqueaderoPorNit(String nit) {
        Parqueadero parqueadero = null;

        try {
            final String SQL = "SELECT * FROM parqueadero WHERE nit = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setString(1, nit);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                parqueadero = new Parqueadero();
                parqueadero.setId(rst.getInt("id"));
                parqueadero.setNombre(rst.getString("nombre"));
                parqueadero.setNit(rst.getString("nit"));
                parqueadero.setDireccion(rst.getString("direccion"));
                parqueadero.setTelefono(rst.getString("telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return parqueadero;
    }

    public static void main(String[] args) {
        List<VehiculoTipo> vehiculosTipos = new Conexion().obtenerVehiculosTipos();

        for (VehiculoTipo vehiculosTipo : vehiculosTipos) {
            System.out.println(vehiculosTipo);
        }
    }

    public FormaPago actualizarMedioPago(FormaPago entidad) {
        try {
            final String SQL = "UPDATE forma_pago SET nombre = ? WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setString(1, entidad.getNombre());
            pstmt.setInt(2, entidad.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return entidad;
    }

    public Parqueadero actualizarParqueadero(Parqueadero entidad) {
        try {
            final String SQL = "UPDATE parqueadero SET nombre = ?, nit = ?, direccion = ?, telefono = ? WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setString(1, entidad.getNombre());
            pstmt.setString(2, entidad.getNit());
            pstmt.setString(3, entidad.getDireccion());
            pstmt.setString(4, entidad.getTelefono());
            pstmt.setInt(5, entidad.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return entidad;
    }

    /**
     * Actualizar un vehiculo tipo (nombre, tarifa).
     * 
     * @param entidad a actualizar.
     */
    public void actualizarVehiculoTipo(VehiculoTipo entidad) {
        try {
            final String SQL = "UPDATE vehiculo_tipo SET nombre = ?, tarifa = ? WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setString(1, entidad.getNombre());
            pstmt.setDouble(2, entidad.getTarifa());
            pstmt.setInt(3, entidad.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void actualizarVehiculo(Vehiculo entidad) {
        try {
            final String SQL = "UPDATE vehiculo SET placa = ?, marca = ?, color = ?, cliente_id = ?, vehiculo_tipo_id = ? WHERE id = ?";
            PreparedStatement pstmt = conectarMySQL().prepareStatement(SQL);
            pstmt.setString(1, entidad.getPlaca());
            pstmt.setString(2, entidad.getMarca());
            pstmt.setString(3, entidad.getColor());
            pstmt.setInt(4, entidad.getClienteId());
            pstmt.setInt(5, entidad.getTipoVehiculoId());
            pstmt.setInt(6, entidad.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
