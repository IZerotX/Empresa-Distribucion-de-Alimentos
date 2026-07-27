import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Envía a la cola de ActiveMQ la información de cada
 * transacción de compra o venta generada en una sucursal.
 */
public class Productor {

    private static final String URL_BROKER = "tcp://localhost:61616";
    private static final String NOMBRE_COLA = "cola.transacciones";

    public void enviarMensaje(String contenidoTransaccion) {
        Connection connection = null;
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory(URL_BROKER);
            connection = factory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(NOMBRE_COLA);
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            TextMessage message = session.createTextMessage(contenidoTransaccion);
            producer.send(message);

            System.out.println("Mensaje enviado a la cola: " + contenidoTransaccion);

            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Productor productor = new Productor();
        // Ejemplo: transacción serializada como texto simple (JSON en un caso real)
        String ejemplo = "{\"idTransaccion\":1,\"sucursal\":1,\"tipo\":\"VENTA\",\"idProducto\":1,\"cantidad\":5}";
        productor.enviarMensaje(ejemplo);
    }
}
