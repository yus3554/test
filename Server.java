import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;

class Server {
    public static void main(String args[]) {
        try {
            int port = Integer.parseInt(args[0]); //サーバ側の待受ポート番号
            ServerSocket ss = new ServerSocket(port);

            while(true) {
                Socket s = ss.accept(); //クライアントからの通信開始要求が来るまで待機

                System.out.println("connect success!!");

                // 以下、クライアントからの要求発生後
                InputStream is = s.getInputStream(); //クライアントから数値を受信
                DataInputStream dis = new DataInputStream(is);
                int req = dis.readInt();

                System.out.println("received data : " + req);

                OutputStream os = s.getOutputStream(); //二乗した結果を送信
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeInt(req*req);

                // ストリームを閉じる
                dos.close();
                dis.close();

                System.out.println("connect finish");
            }
        }
        catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
