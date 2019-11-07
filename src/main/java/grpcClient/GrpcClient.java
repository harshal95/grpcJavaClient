package grpcClient;

import com.grpc.sampleClient.User;
import com.grpc.sampleClient.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(managedChannel);
        User.LoginRequest loginRequest = User.LoginRequest.newBuilder().setUsername("harshal").setPassword("harshal").build();
        User.APIResponse response = userStub.login(loginRequest);
        System.out.println(response.getResponseMessage());
    }
}
