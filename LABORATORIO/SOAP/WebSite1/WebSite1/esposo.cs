using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebSite1
{
    public class esposo
    {

        private string ci;
        private string nombres;
        private string primerapellido;
        private string segundoapellido;

        public esposo()
        {
            this.ci = "321";
            this.nombres = "Anabel";
            this.primerapellido = "Gonzales";
            this.segundoapellido = "Mamani";
        }

        public String getci()
        {
            return ci;
        }
        public String getnombres()
        {
            return nombres;
        }
        public String getprimerapellido()
        {
            return primerapellido;
        }
        public String getsegundoapellido()
        {
            return segundoapellido;
        }

        public override string ToString()
        {
            return "\nCI: " + ci + "\nNombres: " + nombres + "\nPrimer apellido: " + primerapellido + "\nSegundp apellido: " + segundoapellido;
        }
    }
}