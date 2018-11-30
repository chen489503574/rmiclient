package rpc;

import java.lang.reflect.Proxy;

/**
 * 屏蔽了网络访问的细节
 * Created by Chenjf on 2018/11/30.
 *  在客户端实现一个动态代理，使得客户端可以操作代理对象，进而调用远程服务
 */
public class RpcClientProxy {

    public <T> T clientProxy(final Class<T> interfaceCls , final String host,final int port){
        return (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(),new Class[]{interfaceCls},new RemoteInvocationHandler(host,port));
    }
}
