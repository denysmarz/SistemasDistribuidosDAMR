using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteWebSoap
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string ci = textBox1.Text;
            SOperaciones.OperacionesSoapClient c1 = new SOperaciones.OperacionesSoapClient();
            string re = "CI NO ENCONTRADO";
            switch (comboBox1.Text)
            {

                case "Obtener Datos":
                    re = c1.ObtenerDatos(ci);
                    break;
                case "Obtener Certificado Nacimiento":
                    re = c1.ObtenerCertificadoNacimiento(ci);
                    break;
                case "Obtener Certificado Matrimonio":
                    re = c1.ObtenerCertificadoMatrimonio(ci);
                    break;
                case "Obtener Certificado Defuncion":
                    re = c1.ObtenerCertificadoDefuncion(ci);
                    break;

            }
            label2.Text = re.ToString();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string ci = textBox2.Text;
            SOperaciones.OperacionesSoapClient c1 = new SOperaciones.OperacionesSoapClient();
            string re = "";
            switch (comboBox2.Text)
            {

                case "ObtenerDatos":
                    re = c1.ObtenerDatos(ci);
                    break;
                case "ObtenerCertificadoNacimiento":
                    re = c1.ObtenerCertificadoNacimiento(ci);
                    break;
                case "ObtenerCertificadoMatrimonio":
                    re = c1.ObtenerCertificadoMatrimonio(ci);
                    break;
                case "ObtenerCertificadoDefuncion":
                    re = c1.ObtenerCertificadoDefuncion(ci);
                    
                    break;

            }
            label4.Text = re.ToString();
        }

        private void label5_Click(object sender, EventArgs e)
        {

        }
    }
}
