package coding;

import io.protostuff.LinkedBuffer;
import io.protostuff.Pipe;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineEventResult;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProtostuffUtil {
    
    public static List<byte[]> serializeProtoStuffObjectList(List list,Class clazz) {
        if(list == null  ||  list.size() <= 0) {
            return null;
        }
 
        long start = System.currentTimeMillis() ;
        List<byte[]> bytes = new ArrayList<byte[]>();
        Schema schema = RuntimeSchema.getSchema(clazz);
        LinkedBuffer buffer = LinkedBuffer.allocate(4096);
        byte[] protostuff = null;
        for(Object p : list) {
            try {
                protostuff = ProtostuffIOUtil.toByteArray(p, schema, buffer);
                bytes.add(protostuff);
            } finally {
                buffer.clear();
            }
        }
        long end = System.currentTimeMillis() ;
        System.out.println("usetime is"+(end - start));
        return bytes;
    }
    
     public static List  deserializeProtoStuffDataListToObjectList(
                List<byte[]> bytesList,Class clazz) {
            if(bytesList == null || bytesList.size() <= 0) {
                return null;
            }
            long start = System.currentTimeMillis() ;
            Schema  schema = RuntimeSchema.getSchema(clazz);
            List<Object> list = new ArrayList<Object>();
            for(byte[] bs : bytesList) {
                Object obj = null;
                try {
                    obj = clazz.newInstance();
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                ProtostuffIOUtil.mergeFrom(bs,obj, schema);
                list.add(obj);
            }
            long end = System.currentTimeMillis() ;
            System.out.println("usetime is"+(end - start));
            return list;
        }
    
    
        public static  byte[]  serializeProtoStuffObject(Object obj,Class clazz) {
            if(obj == null) {
                return null;
            }
            long start = System.currentTimeMillis() ;
            Schema  schema = RuntimeSchema.getSchema(clazz);
            LinkedBuffer buffer = LinkedBuffer.allocate(4096);
            byte[] protostuff = null;
            protostuff = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
            long end = System.currentTimeMillis() ;
            System.out.println("usetime is"+(end - start));
            return protostuff;
        }
        
        
         public static Object  deserializeProtoStuffDataListToProductsObject(
                     byte[]  bytes,Class clazz) {
             if(bytes == null) {
                    return null;
                }
                long start = System.currentTimeMillis() ;
                Schema  schema = RuntimeSchema.getSchema(clazz);
                Object obj = null;
                try {
                    obj = clazz.newInstance();
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

             ProtostuffIOUtil.mergeFrom(bytes,obj, schema);
                long end = System.currentTimeMillis() ;
                System.out.println("usetime is"+(end - start));
                return obj;
            }
    public static void main(String[] args) {
        StateMachineBuilder.Builder<String, String> stringStringBuilder = new StateMachineBuilder.Builder<>();
        try {
            stringStringBuilder.configureConfiguration().withConfiguration().autoStartup(true);
            stringStringBuilder.configureStates().
                    withStates()
                    .initial("S1")
                    .states(Set.of("S1","S2","S3"));
            stringStringBuilder.configureTransitions()
                    .withExternal()
                    .source("S1")
                    .target("S2")
                    .event("event1")
                    .action(t -> {
                        System.out.println("change1");
                        System.out.println(t.getEvent() + t.getSource() + t.getTarget());
                    })
                    .and()
                    .withExternal()
                    .source("S2")
                    .target("S3")
                    .event("event2")
                    .action(t -> {
                        System.out.println("change2");
                        System.out.println(t.getEvent() + t.getSource() + t.getTarget());
                    });

            StateMachine<String, String> machine = stringStringBuilder.build();


            new Thread(()->{
                Message<String> message = MessageBuilder.withPayload("event1").build();
                Flux<StateMachineEventResult<String, String>> stateMachineEventResultFlux1 =
                        machine.sendEvent(Mono.just(message));
                stateMachineEventResultFlux1.subscribe(t->{
                    System.out.println("result1");
                    System.out.println(t);
                });
            }).start();
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Flux<StateMachineEventResult<String, String>> stateMachineEventResultFlux2 =
                        machine.sendEvent(Mono.just( MessageBuilder.withPayload("event2").build()));
                stateMachineEventResultFlux2.subscribe(t->{
                    System.out.println("result2");
                    System.out.println(t);

                });
            }).start();

            Thread.sleep(100000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
