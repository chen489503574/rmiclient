package rpc;

/**
 * Created by Chenjf on 2018/11/30.
 */
public class ClientDemo {
    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
        IGpHello iGpHello = rpcClientProxy.clientProxy(IGpHello.class, "localhost", 8888);
        System.out.println(iGpHello.sayHi("佳阳"));
    }
}
