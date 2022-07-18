using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace WebImpuesto
{
    /// <summary>
    /// Descripción breve de WebService1
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class WebService1 : System.Web.Services.WebService
    {

        [WebMethod]
        public string HelloWorld()
        {
            return "Hola a todos";
        }
        [WebMethod]
        public string SincronizarFechaHora()
        {
            string datetime = DateTime.Now.ToString("hh:mm:ss tt");
            
            return datetime;
        }
        [WebMethod]
        public string obtenerCufd(int idambiente,int modelidad,int nit)
        {
            
            return "AB0000345C34521";
        }
        [WebMethod]
        public string EmitirFactura(int idambiente, int modelidad, int nit,string Cufd)
        {
            int t = idambiente + nit;
            string total = t.ToString();
            factura es = new factura(total);
            return "estado: valido Mensaje: recibido correctamente "+es;
        }
    }
}
