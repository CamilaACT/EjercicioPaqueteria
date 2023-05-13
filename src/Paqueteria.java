import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class Paqueteria extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField txtCalleEnvio;
    private JTextField txtCiudadEnvio;
    private JTextField txtEstadoEnvio;
    private JTextField txtCdigoEnvio;
    private JTextField txtcalleRecibo;
    private JTextField txtciudadrecibo;
    private JTextField txtestadoRecibo;
    private JTextField txtcodigoRecibo;
    private JTextField txtDia;
    private JTextField txtMes;
    private JTextField txtanio;
    private JButton btncrearpaquete;
    private JTextField txtcodigoeliminar;
    private JButton btneliminarpaquete;
    private JButton btncargardatos;
    private JButton btnMostrarPaquetes;
    private JTextArea txtImprimirdatos;
    private JTextField txtBuscarCiudad;
    private JButton btnBuscarCiudad;
    private JTextArea txtBusquedaporciudad;
    private JTextField txtbuscarcalle;
    private JTextField txtbuscarciudad;
    private JTextField txtbuscarestado;
    private JTextField txtbuscarcodigpo;
    private JButton btnBuscardireccion;
    private JTextArea txtBusquedapordireccion;
    private JTextField txtnumero;
    private JTextArea txtbusquedapornumero;
    private JButton btnbuscarpornumero;
    private TrackingSystem tk;

    public Paqueteria(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        tk=new TrackingSystem();

        btncrearpaquete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tk.addPackage(new Package(new Adress(txtCalleEnvio.getText(),txtCiudadEnvio.getText(),txtEstadoEnvio.getText(),txtCdigoEnvio.getText()),
                        new Adress(txtciudadrecibo.getText(),txtciudadrecibo.getText(),txtestadoRecibo.getText(),txtcodigoRecibo.getText()),
                        LocalDate.of(Integer.parseInt(txtanio.getText()),Integer.parseInt(txtMes.getText()),Integer.parseInt(txtDia.getText()))));
                JOptionPane.showMessageDialog(null, "Paquete creado con éxito \n Código de rastreo: "+tk.getLastPackageCode());
            }
        });
        btneliminarpaquete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(tk.removePackage(txtcodigoeliminar.getText())){
                   JOptionPane.showMessageDialog(null, "Paquete encontrado y eliminado con exito");
               }else{
                   JOptionPane.showMessageDialog(null, "No se pudo eliminar el paquete, compruebe que ingreso correctamente el código");
               }
            }
        });

        btncargardatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tk.Quemardatos();
                JOptionPane.showMessageDialog(null, "Datos quemados");
                btncargardatos.setEnabled(false);
            }
        });

        btnMostrarPaquetes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               txtImprimirdatos.setText(tk.toString());
            }
        });
        btnBuscardireccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Package pk1=tk.searchByRecipientAddress(new Adress(txtbuscarcalle.getText(),txtbuscarciudad.getText(),txtbuscarestado.getText(),txtbuscarcodigpo.getText()));
                if(pk1!=null){
                    txtBusquedapordireccion.setText(pk1.toString());
                }else{
                    txtBusquedapordireccion.setText("No se encontraron resultados para la busqueda");
                }
            }
        });

        btnBuscarCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Package> ciudades=tk.searchByCity(txtBuscarCiudad.getText());
                System.out.println("Tamaño arreglo ciudades: "+ciudades.size());
                if(ciudades.size()>0){
                    txtBusquedaporciudad.setText(tk.imprimirLista(ciudades));
                }
                else{txtBusquedaporciudad.setText("No se encontraron resultados para la busqueda");
                }


            }
        });
        btnbuscarpornumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Package pk1=tk.searchByTrackingNumber(txtnumero.getText());
                if(pk1!=null){
                    txtbusquedapornumero.setText(pk1.toString());
                }else{
                    txtbusquedapornumero.setText("No se encontraron resultados de la busqueda");
                }
            }
        });
    }

}
