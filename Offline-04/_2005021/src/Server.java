import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    public static final String FILE_NAME = "init_stocks.txt";
    public static HashMap<String, Stock> stockHashMap;
    public static HashMap<String, Client> clientHashMap;
    public static NotificationManager notificationManager;

    public static void main(String[] args) {
        new Admin();
        new Server();
    }
    public Server() {
        stockHashMap = new HashMap<>();
        clientHashMap = new HashMap<>();
        notificationManager = new NotificationManager();
        retrieveStocks();
        connectClient();
    }
    public void retrieveStocks(){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
        } catch (FileNotFoundException exception) {
            exception.printStackTrace(System.out);
        }
        if (bufferedReader != null){
            while (true) {
                String line = null;
                try {
                    line = bufferedReader.readLine();
                } catch (IOException exception) {
                    exception.printStackTrace(System.out);
                }
                if (line == null) break;
                String[] stockInfo = line.split(" ");
                stockHashMap.put(stockInfo[0], new Stock(stockInfo));
                notificationManager.addNewStock(stockInfo[0]);
            }
            try {
                bufferedReader.close();
            } catch (IOException exception) {
                exception.printStackTrace(System.out);
            }
        } else {
            System.out.println("BufferedReader is null");
        }
    }
    private void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        new Thread(()->{
            SocketWrapper socketWrapper = null;
            try {
                socketWrapper = new SocketWrapper(clientSocket);
            } catch (IOException e) {
                System.out.println("Connection failed.");
            }
            String clientName = null;
            try {
                assert socketWrapper != null;
                clientName = (String) socketWrapper.read();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("An error occur during reading client name.");
            }
            System.out.println(clientName + " is connected.");
            Client client = clientHashMap.get(clientName);
            if(client != null) {
                client.setSocketWrapper(socketWrapper);
            } else {
                client = new Client(clientName, socketWrapper);
                clientHashMap.put(clientName, client);
            }
            client.sendAllStockInfo();
            client.sendNotification();
            new ReadWriteThread(client);
        }).start();
    }
    private void connectClient()  {
        try{
            try(ServerSocket serverSocket = new ServerSocket(12345)) {
                while (true){
                    try {
                        Socket clientSocket = serverSocket.accept();
                        serve(clientSocket);
                    } catch (IOException | ClassNotFoundException exception) {
                        exception.printStackTrace(System.out);
                    }
                }
            }
        }catch (Exception exception){
            exception.printStackTrace(System.out);
        }
    }
}
