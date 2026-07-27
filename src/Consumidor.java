import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Lee los mensajes de la cola de ActiveMQ y los procesa
 * contra la base de datos del sistema de gestión de inventarios.
 */
public class Consumidor {

    private static final String URL_BROKER = "tcp://localhost:61616";
    private static final String NOMBRE_COLA = "cola.transacciones";

    public void escucharMensajes() {
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory(URL_BROKER);
            Connection connection = factory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(NOMBRE_COLA);
            MessageConsumer consumer = session.createConsumer(destination);

            consumer.setMessageListener(message -> {
                try {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        String contenido = textMessage.getText();
                        System.out.println("Mensaje recibido: " + contenido);
                        procesarEnBaseDeDatos(contenido);
                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * Aquí se haría el INSERT/UPDATE real en MySQL
     * (tablas Transaccion, Compra/Venta) usando JDBC.
     */
    private void procesarEnBaseDeDatos(String contenidoTransaccion) {
        System.out.println("Procesando en la base de datos: " + contenidoTransaccion);
        // Ejemplo conceptual:
        // Connection conn = DriverManager.getConnection(url, user, pass);
        // PreparedStatement stmt = conn.prepareStatement("INSERT INTO Transaccion ...");
        // stmt.executeUpdate();
    }

    public static void main(String[] args) {
        Consumidor consumidor = new Consumidor();
        consumidor.escucharMensajes();
        System.out.println("Consumidor escuchando la cola de transacciones...");
    }
}
