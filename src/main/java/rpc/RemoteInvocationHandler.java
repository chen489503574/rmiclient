package rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Chenjf on 2018/11/30.
 *  发起客户端和服务端的远程调用，处理对应请求的Handler
 */
public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    //直接发起跟 远程服务进行调用
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);

        TCPTransport tcpTransport = new TCPTransport(host,port);
        Object result = tcpTransport.send(rpcRequest);
        return result;
    }
}
