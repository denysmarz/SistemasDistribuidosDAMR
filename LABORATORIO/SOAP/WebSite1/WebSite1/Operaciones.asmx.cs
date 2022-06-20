using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace WebSite1
{
    /// <summary>
    /// Descripción breve de Operaciones
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class Operaciones : System.Web.Services.WebService
    {

        private string carnet;
        private string nombres;
        private string primerapellido;
        private string segundoapellido;
        private string fechanacimiento;
        private string sexo;
        private string estadocivil;
        private string DatosPadre;
        private string Madre;

        private string fechanadefuncion;
        private string causa;

        public Operaciones()
        {
            this.carnet = "123";
            this.nombres = "Juan";
            this.primerapellido = "Perez";
            this.segundoapellido = "Gomez";
            this.fechanacimiento = "10-09-1960";
            this.sexo = "Masculino";
            this.estadocivil = "soltero";
            this.DatosPadre = "Marcelo";
            this.Madre = "Sonia";
            this.fechanadefuncion = "15-12-2010";
            this.causa = "Accidente automovilistico";
        }

        [WebMethod]
        public string HelloWorld()
        {
            return "Hola a todos";
        }

        [WebMethod]
        public string ObtenerDatos(string CI)
        {
            if(CI == this.carnet)
            return "CARNET: " + carnet + "\nNOMBRES: " + nombres + "\nPRIMER APELLIDO: " + primerapellido + "\nSEGUNADO APELLIDO: " + segundoapellido + "\nFECHA DE NACIMIENTO: " + fechanacimiento + "\nSEXO: " + sexo + "\nESTADO CIVIL: " + estadocivil;

            return "NO SE ENCONTRO EL CI";
        }
        [WebMethod]
        public string ObtenerCertificadoNacimiento(String CI)
        {
            if (CI == this.carnet)
                return "NOMBRES: "+nombres+"\nPRIMER APELLIDO: " + primerapellido + "\nSEGUNDO APELLIDO: "+segundoapellido +"\nFECHA DE NACIMIENTO: "+ fechanacimiento +"\nPADRE: "+ DatosPadre +"\nMADRE: "+ Madre;

            return "NO SE ENCONTRO EL CI";
        }
        [WebMethod]
        public string ObtenerCertificadoMatrimonio(String CI)
        {
            esposo es = new esposo();
            if (CI == this.carnet)
                return "CI: " + CI + "\nNOMBRES: " + nombres + "\nPRIMER APELLIDO: " + primerapellido + "\nSEGUNDO APELLIDO: " + segundoapellido + "\nDATOS DE ESPOSO: " + es;
            return "NO SE ENCONTRO EL CI";
        }
        [WebMethod]
        public string ObtenerCertificadoDefuncion(String CI)
        {
            if (CI == this.carnet)
                return "CARNET: " + carnet + "\nNOMBRES: " + nombres + "\nPRIMER APELLIDO: " + primerapellido + "\nSEGUNDO APELLIDO: " + segundoapellido + "\nFECHA DE DEFUNCION: " + fechanadefuncion + "\nCAUSA: " + causa;

            return "NO SE ENCONTRO EL CI";
        }

    }


}
