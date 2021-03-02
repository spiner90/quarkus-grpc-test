package com.test;

import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class HelloService extends GreeterGrpc.GreeterImplBase{
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        String message = "Hello " + name;
        responseObserver.onNext(HelloReply.newBuilder().setMessage(message).build());
        //responseObserver.onNext(HelloReply.newBuilder().setMessage(message + " ,you are fine").build());
        responseObserver.onCompleted();
    }
}
