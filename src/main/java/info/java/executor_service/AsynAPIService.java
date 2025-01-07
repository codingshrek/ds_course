package info.java.executor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsynAPIService {


    private ExecutorService ex = Executors.newFixedThreadPool(10);

    public void callApis() throws InterruptedException, ExecutionException {

        List<CompletableFuture<Long>> cFutures = new ArrayList<>();
        for(int i=1;i<=10;i++){
            int finalI = i;
            CompletableFuture<Long> cF = CompletableFuture.supplyAsync(()-> {
                try {
                    return new AdditionService().add(finalI,finalI*2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            },ex).handle((res, ex)->{
                if(ex!=null) return 0;
                return res;
            }).thenApplyAsync(added-> {
                try {
                    return new MultiplicationService().multiply(added);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            },ex);

            cFutures.add(cF);
        }

        for(CompletableFuture<Long> fut :  cFutures){
            System.out.println(fut.get());
        }

        ex.shutdown();

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsynAPIService s =  new AsynAPIService();
        s.callApis();
    }
}
