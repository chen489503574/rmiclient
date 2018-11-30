package client;

import server.IHelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Chenjf on 2018/11/29.
 * 调用远程服务，不能实例了，需要通过代理类进行操作
 */
public class ClientDemo {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        IHelloService helloService =
                (IHelloService) Naming.lookup("rmi://127.0.0.1/Hello");//从注册中心里拿到一个代理类实例
        System.out.println(helloService.sayHello("嚣张"));
    }
}
