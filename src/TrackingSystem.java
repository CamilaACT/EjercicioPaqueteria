import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrackingSystem {
    private List<Package> packages;

    public TrackingSystem() {
        this.packages = new ArrayList<Package>();
    }

    public void addPackage(Package pkg){
        packages.add(pkg);
    }

    public boolean removePackage(String trackingNumber){
        Package package1;
        for (int i=0;i<packages.size();i++) {
            package1=packages.get(i);
            if(package1.getTrackingNumber().equals(trackingNumber)){
                packages.remove(i);
                return true;
            }
        }
        return false;
    }

    public Package searchByRecipientAddress (Adress recipientAddress){
        for (Package package1 : packages) {
            if(package1.getRecipientAddress().equals(recipientAddress)){
                return package1;
            }
        }
        return null;
    }

    public Package searchByTrackingNumber(String trackingNumber){
        try{
            int soloNumTrcking=Integer.parseInt(trackingNumber.substring(3));

            int izquierda = Integer.parseInt(packages.get(0).getTrackingNumber().substring(3));
            int derecha = Integer.parseInt(packages.get(packages.size()-1).getTrackingNumber().substring(3));

            while (izquierda <= derecha) {
                int medio = (izquierda + derecha) / 2;
                int condicion=Integer.parseInt(packages.get(medio).getTrackingNumber().substring(3));
                if (condicion==soloNumTrcking) {//nums[medio] == target
                    return packages.get(medio);
                } else if (condicion < soloNumTrcking) {
                    izquierda = medio + 1;
                } else {
                    derecha = medio - 1;
                }
            }
        }catch (IndexOutOfBoundsException e) {
            return null;
        }

        return null;
    }

    public List<Package> searchByCity (String city){
        List<Package> paquetesporCiudad=new ArrayList<Package>();
        for (Package package1 : packages) {
            if(package1.getRecipientAddress().getCity().equals(city)){
                paquetesporCiudad.add(package1);
            }
        }
        return paquetesporCiudad;
    }

    public String getLastPackageCode() {
        return packages.get(packages.size()-1).getTrackingNumber();
    }

    public String imprimirLista(List<Package> lista){
        String impresion="";
        for (Package package1 : lista) {
            impresion=impresion+package1.toString();

        }
        return impresion;
    }
    public void Quemardatos(){
        packages.add(new Package(new Adress("Calle Envio 1","Ciudad envio 1","Estado envio 1","Codigo envio 1"),new Adress("Calle Recibo 1","Ciudad Recibo 1","Estado Recibo 1","Codigo Recibo 1"), LocalDate.of(2023,5,12)));
        packages.add(new Package(new Adress("Calle Envio 2","Ciudad envio 2","Estado envio 2","Codigo envio 2"),new Adress("Calle Recibo 2","Ciudad Recibo 2","Estado Recibo 2","Codigo Recibo 2"),LocalDate.of(2023,5,12)));
        packages.add(new Package(new Adress("Calle Envio 3","Ciudad envio 3","Estado envio 3","Codigo envio 3"),new Adress("Calle Recibo 3","Ciudad Recibo 3","Estado Recibo 3","Codigo Recibo 3"),LocalDate.of(2023,5,12)));
        packages.add(new Package(new Adress("Calle Envio 4","Ciudad envio 4","Estado envio 4","Codigo envio 4"),new Adress("Calle Recibo 4","Ciudad Recibo 4","Estado Recibo 4","Codigo Recibo 4"),LocalDate.of(2023,5,12)));
        packages.add(new Package(new Adress("Calle Envio 5","Ciudad envio 5","Estado envio 5","Codigo envio 5"),new Adress("Calle Recibo 5","Ciudad Recibo 5","Estado Recibo 5","Codigo Recibo 5"),LocalDate.of(2023,5,12)));
        packages.add(new Package(new Adress("Calle Envio 6","Ciudad envio 6","Estado envio 6","Codigo envio 6"),new Adress("Calle Recibo 6","Ciudad Recibo 6","Estado Recibo 6","Codigo Recibo 6"),LocalDate.of(2023,5,12)));
    }

    @Override
    public String toString() {
        return "TrackingSystem{" +
                "packages=" + packages +
                '}';
    }
}
