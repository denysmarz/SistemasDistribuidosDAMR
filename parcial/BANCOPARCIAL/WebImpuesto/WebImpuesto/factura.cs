using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebImpuesto
{

    public class factura
    {
        private string nit;
        private string razonsocial;
        private string fecha;
        private string numerofactura;
        private string cuf;
        private string tipodocumento;
        private string nombrecliente;
        private string cantidad;
        private string producto;
        private string preciounitario;
        private string preciototal;

        public factura(string cuf)
        {
            this.nit = "12345";
            this.razonsocial = "compras ropa";
            this.fecha = "9/07/2022";
            this.numerofactura = "8888888";
            this.cuf = cuf;
            this.tipodocumento = "NIT";
            this.nombrecliente = "JUAN";
            this.cantidad = "1";
            this.producto = "polera";
            this.preciounitario = "10";
            this.preciototal = "10";
        }
        public override string ToString()
        {
            return razonsocial;
        }
    }
}