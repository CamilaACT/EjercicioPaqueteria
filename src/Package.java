
import java.time.LocalDate;

public class Package {

    private String trackingNumber;
    private static int contador=0;
    private Adress senderAddress;
    private Adress recipientAddress;
    private LocalDate estimatedDeliveryDate;

    public Package(Adress senderAddress, Adress recipientAddress, LocalDate estimatedDeliveryDate) {
        this.trackingNumber=asignarTracking();
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private String asignarTracking(){
        contador=contador+1;
        return"PK-"+contador;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public Adress getRecipientAddress() {
        return recipientAddress;
    }

    @Override
    public String toString() {
        return "\n INFORMACION PAQUETE { " +
                " trackingNumber='" + trackingNumber + '\'' +
                ", senderAddress=" + senderAddress +
                ", recipientAddress=" + recipientAddress +
                ", estimatedDeliveryDate=" + estimatedDeliveryDate +
                '}'+"\n";
    }
}
