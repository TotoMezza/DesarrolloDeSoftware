package com.desarrollo.tpJpa;

import com.desarrollo.tpJpa.entidades.*;
import com.desarrollo.tpJpa.enumeraciones.EstadoPedido;
import com.desarrollo.tpJpa.enumeraciones.FormaPago;
import com.desarrollo.tpJpa.enumeraciones.TipoEnvio;
import com.desarrollo.tpJpa.enumeraciones.TipoProducto;
import com.desarrollo.tpJpa.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class TpJpaApplication {

	@Autowired
	ClienteRepositorio clienteRepositorio;
	@Autowired
	DomicilioRepositorio domicilioRepositorio;
	@Autowired
	DetallePedidoRepositorio detallePedidoRepositorio;
	@Autowired
	FacturaRepositorio facturaRepositorio;
	@Autowired
	PedidoRepositorio pedidoRepositorio;
	@Autowired
	ProductoRepositorio productoRepositorio;
	@Autowired
	RubroRepositorio rubroRepositorio;
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);}

	@Bean
	CommandLineRunner init(ClienteRepositorio clienteRepositorio){
		return args -> {
			System.out.println("-----------ESTOY CANSADO JEFE----------");

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Ozamis")
					.numero("1000")
					.localidad("maipú").
					build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Videla Castillo")
					.numero("6043")
					.localidad("Russel").
					build();

			Cliente cliente = Cliente.builder()
					.nombre("Juan")
					.apellido("Alvarez")
					.telefono("261 1234-567")
					.email("juanalvarez@email.com")
					.build();

			cliente.agregarDomicilio(domicilio1);
			cliente.agregarDomicilio(domicilio2);

			clienteRepositorio.save(cliente);
			Cliente clienteRecuperado = clienteRepositorio.findById(cliente.getId()) .orElse(null);

			if (clienteRecuperado != null) {
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Teléfono: " + clienteRecuperado.getTelefono());
				System.out.println("Email: " + clienteRecuperado.getEmail());
				clienteRecuperado.mostrarDomicilios();
			}


			Producto producto1 = Producto.builder()
					.denominacion("Sanguches de Miga")
					.unidadMedida("1 docena")
					.precioCompra(1000.0)
					.precioVenta(2700.0)
					.receta("pan de miga, con jamón cocido y queso de máquina")
					.stockActual(20)
					.stockMinimo(5)
					.tipoProducto(TipoProducto.MANUFACTURADO)
					.tiempoEstimadoCocina(10)
					.build();
			Producto producto2 = Producto.builder()
					.denominacion("Pebete")
					.unidadMedida("1 unidad")
					.precioCompra(700.0)
					.precioVenta(1200.0)
					.receta("Pan de leche, con jamón cocido, queso gouda y un poco de mostaza")
					.stockActual(50)
					.stockMinimo(5)
					.tipoProducto(TipoProducto.MANUFACTURADO)
					.tiempoEstimadoCocina(7)
					.build();

			Rubro rubro1 = Rubro.builder()
					.denominacion("Sanguches")
					.build();

			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);

			rubroRepositorio.save(rubro1);

			Rubro rubroRecuperado = rubroRepositorio.findById(rubro1.getId()) .orElse(null);

			if (rubroRecuperado != null) {
				System.out.println("Denominación: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProducto();
			}

			DetallePedido detalle1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(5400.0)
					.build();
			DetallePedido detalle2 = DetallePedido.builder()
					.cantidad(5)
					.subtotal(3500.0)
					.build();


			detalle1.setProducto(producto2);
			detalle2.setProducto(producto1);

			SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
			String fechaString1 = "2023-09-18";
			String fechaString2 = "2023-08-19";
			Date fechaPedido1 = fechaFormato.parse(fechaString1);
			Date fechaPedido2 = fechaFormato.parse(fechaString2);

			Pedido pedido1 = Pedido.builder()
					.estadoPedido(EstadoPedido.ENTREGADO)
					.fecha(fechaPedido1)
					.tipoEnvio(TipoEnvio.TAKE_AWAY)
					.total(5400.0)
					.build();
			Pedido pedido2 = Pedido.builder()
					.estadoPedido(EstadoPedido.PREPARACION)
					.fecha(fechaPedido2)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.total(3500.0)
					.build();

			pedido1.agregarDetalle(detalle1);
			pedido1.agregarDetalle(detalle2);


			Factura factura1 = Factura.builder()
					.numero(19)
					.fecha(fechaPedido1)
					.descuento(0.0)
					.total(5400)
					.formaPago(FormaPago.EFECTIVO)
					.build();
			Factura factura2 = Factura.builder()
					.numero(21)
					.fecha(fechaPedido2)
					.descuento(0.0)
					.total(3500)
					.formaPago(FormaPago.EFECTIVO)
					.build();

			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);


		};


	}

}
