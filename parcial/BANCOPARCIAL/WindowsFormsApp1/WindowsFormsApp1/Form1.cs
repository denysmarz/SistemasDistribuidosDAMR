using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string cotizacion = textBox1.Text;
            string idambiente = textBox2.Text;
            string nit = textBox3.Text;
            string modalidad = textBox4.Text;

            int nit2 = Int32.Parse(nit);
            int idambiente2 = Int32.Parse(idambiente);
            int modalidad2 = Int32.Parse(modalidad);

            ServiceBanco.WebService1SoapClient webService1Soap = new ServiceBanco.WebService1SoapClient();
            
            ServiceImpuestos.WebService1SoapClient si = new ServiceImpuestos.WebService1SoapClient();
            //SOperaciones.OperacionesSoapClient c1 = new SOperaciones.OperacionesSoapClient();

            string re = webService1Soap.ObtenerCotizacion(cotizacion);
            String hora = si.SincronizarFechaHora();
            String cufd = si.obtenerCufd(idambiente2,modalidad2,nit2);

            string emitir = si.EmitirFactura(idambiente2,modalidad2,nit2,cufd);
            
            label16.Text ="COTIZACION: " +re.ToString() + "\nHORA: "+hora.ToString()+"\nCUFD: "+cufd.ToString()+"\nEmitir Factura: \n"+emitir.ToString();
        }
    }
}
